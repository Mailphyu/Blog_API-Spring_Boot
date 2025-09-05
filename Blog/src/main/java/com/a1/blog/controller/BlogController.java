package com.a1.blog.controller;

import com.a1.blog.model.Blog;
import com.a1.blog.repository.BlogRepository;
import com.a1.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//marks this class as a REST controller (handles HTTP requests/responses)
@RestController
//base URL for all endpoints in this controller will start with /blogs
@RequestMapping("/blogs")           
public class BlogController {

    //injects the BlogRepository dependency
    @Autowired
    private BlogRepository blogRepository;

    //injects the BlogService dependency
    @Autowired
    private BlogService blogService;       

    //get /blogs = retrieve all blogs
    @GetMapping
    public List<Blog> getAllBlogs() {
        //delegates fetching all blogs to the service layer
        return blogService.getAllBlogs();
    }

    //get /blogs/{id} = retrieve a blog by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable Long id) {
        //calls service to find blog by ID
        Blog blog = blogService.getBlogById(id);

        //if no blog is found = return 404 not found
        if (blog == null) {
            return ResponseEntity.notFound().build();
        }

        //if found = return 200 ok with the blog object
        return ResponseEntity.ok(blog);
    }

    //post /blogs = create a new blog
    @PostMapping
    public Blog createBlog(@RequestBody Blog blog) {
        //@RequestBody maps incoming JSON into a Blog object
        //delegates blog creation to the service layer
        return blogService.createBlog(blog);
    }

    //put /blogs/{id} = update an existing blog by ID
    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable Long id, @RequestBody Blog updatedBlog) {
        //calls service to update the blog
        Blog blog = blogService.updateBlog(id, updatedBlog);

        //if blog with given ID does not exist = return 404 not found
        if (blog == null) {
            return ResponseEntity.notFound().build();
        }

        //if update successful = return 200 ok with updated blog
        return ResponseEntity.ok(blog);
    }
}
