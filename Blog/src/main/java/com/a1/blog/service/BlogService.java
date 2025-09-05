package com.a1.blog.service;

import com.a1.blog.model.Blog;
import com.a1.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//marks this class as a service component in the spring context
@Service
public class BlogService {

    //injects the BlogRepository dependency
    @Autowired
    private BlogRepository blogRepository;

    //get all blogs from the database
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    //get a single blog by its id
    public Blog getBlogById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    //create and save a new blog
    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    //update an existing blog if it exists, otherwise return null
    public Blog updateBlog(Long id, Blog updatedBlog) {
        return blogRepository.findById(id).map(blog -> {
                    //update blog fields with values from updatedBlog
                    blog.setTitle(updatedBlog.getTitle());
                    blog.setDescription(updatedBlog.getDescription());
                    blog.setCategory(updatedBlog.getCategory());

                    //save the updated blog back to the database
                    return blogRepository.save(blog);
                })
                .orElse(null);
    }
}