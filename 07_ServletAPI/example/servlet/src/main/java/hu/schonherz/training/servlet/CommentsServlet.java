package hu.schonherz.training.servlet;

import hu.schonherz.training.beans.Comment;
import hu.schonherz.training.beans.CommentsBean;
import hu.schonherz.training.utils.RequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * Custom extension of {@code HttpServlet}.
 *
 * This servlet implements a little commenting functionality, nothing serious.
 * A user gets a list of comments (strings) if he sends a GET request while
 * using POST, he can submit a new comment.
 */
@WebServlet(name = "commentsServlet", urlPatterns = "/comments")
public class CommentsServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(CommentsServlet.class);

    // Constants help you to avoid typos, and make refactor easier
    private static final String NEW_COMMENT_INPUT_NAME = "content";
    private static final String COMMENTER_INPUT_NAME = "name";
    private static final String COMMENTS_SESSION_KEY = "comments";
    private static final String ENCODING = "utf-8";

    private CommentsBean comments;
    private String[] contributors = {"Robert Discoteque", "John Cena"};

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        LOG.debug("Handling GET request to /comments...");

        resp.setHeader("Content-Type", "text/html; charset=utf-8");
        resp.setCharacterEncoding(ENCODING);

        PrintWriter out = resp.getWriter();
        String name = (req.getParameter(COMMENTER_INPUT_NAME) != null ? req.getParameter(COMMENTER_INPUT_NAME) : "Anonymous");

        comments = getCommentsFromSession(req);

        out.append("<h1>Hello " + name + "!</h1>");

        if (!comments.getComments().isEmpty()) {
            for (Comment comment : comments.getComments()) {
                out.append("<div style='padding: 10px;margin-bottom: 20px;border: solid 1px;'>");
                out.append("<strong>").append(comment.getCommenter()).append("</strong>").append("<br>");
                out.append("<span>").append(comment.getContent()).append("</span>");
                out.append("</div>");
            }
        } else {
            out.append("<div>There is no comment yet</div>");
        }

        out.append("<form action='comments' method='POST'>");
        out.append("<input name='" + COMMENTER_INPUT_NAME + "' type='hidden' value='" + name + "'></input>");
        out.append("<textarea name='" + NEW_COMMENT_INPUT_NAME + "' placeholder='Enter comment here, " + name + "!'></textarea>");
        out.append("<div>");
        out.append("<input type='submit' value='Submit'></input>");
        out.append("</div>");
        out.append("</form>");

        out.append("<footer>");
        out.append("<h2>Contributors:</h2>");
        out.append("<ul>");

        for (String contributor : contributors) {
            out.append("<li>" + contributor + "</li>");
        }

        out.append("</ul>");
        out.append("</footer>");
    }

    /**
     * Handles POST requests coming to /comments.
     * We expect the request to have a request body of plain text data (a new comment).
     *
     * After storing the incoming data on Session scope, we redirect the client.
     *
     * @param req the incoming HTTP request
     * @param res the outgoing HTTP response
     *
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        LOG.debug("Handling POST request to /comments...");

        req.setCharacterEncoding(ENCODING);
        res.setCharacterEncoding(ENCODING);

        comments = getCommentsFromSession(req);
        comments.getComments().add(parseBodyAsComment(req));

        req.getSession().setAttribute(COMMENTS_SESSION_KEY, this.comments);
        res.sendRedirect("/servlet-examples/comments");
    }

    /**
     * Returns with an instance of {@code CommentsBean}, stored in the Session.
     *
     * @param req the request which is part of the Session.
     * @return an instance of {@code CommentsBean}.
     */
    private CommentsBean getCommentsFromSession(final HttpServletRequest req) {
        HttpSession session = req.getSession(true);

        if (session.getAttribute(COMMENTS_SESSION_KEY) == null) {
            session.setAttribute(COMMENTS_SESSION_KEY, new CommentsBean());
        }

        return (CommentsBean) session.getAttribute(COMMENTS_SESSION_KEY);
    }

    private Comment parseBodyAsComment(final HttpServletRequest req) {
        Properties formProperties = RequestUtils.parseFormBody(req);
        Comment commentFromBody = new Comment();

        commentFromBody.setCommenter(formProperties.getProperty(COMMENTER_INPUT_NAME, "Anonymous"));
        commentFromBody.setContent(formProperties.getProperty(NEW_COMMENT_INPUT_NAME, ""));

        LOG.debug("Got new comment: {}.", commentFromBody);

        return commentFromBody;
    }

}
