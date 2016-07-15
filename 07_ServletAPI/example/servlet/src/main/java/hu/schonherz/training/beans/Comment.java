package hu.schonherz.training.beans;

import java.io.Serializable;

/**
 * Encapsulation of a comment.
 * Instances of this class contain information about who posted the comment
 * and of course, the contents of the comment itself.
 */
public class Comment implements Serializable {
    private static final long serialVersionUID = 6245145615416L;

    private String commenter;
    private String content;

    public String getCommenter() {
        return commenter;
    }

    public void setCommenter(final String commenter) {
        this.commenter = commenter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Comment comment = (Comment) o;

        if (getCommenter() != null ? !getCommenter().equals(comment.getCommenter()) : comment.getCommenter() != null) {
            return false;
        }

        return getContent() != null ? getContent().equals(comment.getContent()) : comment.getContent() == null;

    }

    @Override
    public int hashCode() {
        int result = getCommenter() != null ? getCommenter().hashCode() : 0;
        result = 31 * result + (getContent() != null ? getContent().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commenter='" + commenter + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
