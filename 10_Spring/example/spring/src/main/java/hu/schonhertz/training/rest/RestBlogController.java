package hu.schonhertz.training.rest;

import hu.schonhertz.training.jdbctemplate.BlogJDBCTemplate;
import hu.schonhertz.training.pojo.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ikant on 2016. 07. 26..
 */
@RestController
@RequestMapping(path = "/api/blogs", produces = "application/json")
public class RestBlogController {

    @Autowired
    private BlogJDBCTemplate blogJDBCTemplate;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity listBlogs(Model model) {
        List<Blog> blogs = blogJDBCTemplate.getAllBlog();
        return new ResponseEntity(blogs, HttpStatus.OK);

    }
}
