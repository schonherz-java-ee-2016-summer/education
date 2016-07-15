package hu.schonherz.training.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple Java Bean encapsulating a number of "comments".
 * Comments are plain Strings for the sake of simplicity.
 */
public class CommentsBean implements Serializable {
    private static final long serialVersionUID = 1324354353653L;
  
    private List<Comment> comments = new ArrayList<>();

    public List<Comment> getComments() {
      return comments;
    }

    public void setComments(final List<Comment> comments) {
      this.comments = comments;
    }

}
