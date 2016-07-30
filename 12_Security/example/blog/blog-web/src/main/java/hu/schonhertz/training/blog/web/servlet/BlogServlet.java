package hu.schonhertz.training.blog.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.google.gson.Gson;

import hu.schonhertz.training.blog.service.BlogService;
import hu.schonhertz.training.blog.vo.BlogVo;

@WebServlet("/blog")
public class BlogServlet extends HttpServlet {

	private static final long serialVersionUID = 1795959081410371020L;

	@Autowired
	BlogService blogService;

	@PostConstruct
	public void postConstruct() {
		System.out.println("postconstruct has run.");
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		BlogVo blogVo = new BlogVo();
		blogVo.setCreator(request.getParameter("creator"));
		blogVo.setTitle(request.getParameter("title"));
		blogVo.setText(request.getParameter("text"));
		blogService.createBlog(blogVo);

		resp.setContentType("text/html");
		resp.setStatus(HttpServletResponse.SC_OK);
		resp.getWriter().write("OK");

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

		String parameter = request.getParameter("blogId");

		if (StringUtils.isEmpty(parameter)) {
			List<BlogVo> blogVos = blogService.getAllBlog();

			resp.setContentType("application/json");
			resp.setStatus(HttpServletResponse.SC_OK);

			Gson gson = new Gson();
			gson.toJson(blogVos, resp.getWriter());
		} else {
			Integer blogId = Integer.valueOf(parameter);
			BlogVo blogVo = blogService.getBlogById(blogId);

			resp.setContentType("application/json");
			resp.setStatus(HttpServletResponse.SC_OK);

			Gson gson = new Gson();
			gson.toJson(blogVo, resp.getWriter());
		}
	}
}
