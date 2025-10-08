package com.talentstream.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talentstream.dto.BlogRequestDTO;
import com.talentstream.service.BlogService;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/active")
    public ResponseEntity<?> getActiveBlogs() {
        return blogService.getActiveBlogs();
    }
    
    @GetMapping("/all")
    public ResponseEntity<?> getAllBlogs() {
        return blogService.getAllBlogs();
    }

    @GetMapping("/inactive")
    public ResponseEntity<?> getInActiveBlogs() {
        return blogService.getInActiveBlogs();
    }

    @PutMapping("/updateOrDelete")
    public ResponseEntity<String> updateOrDeleteBlog(@Valid @RequestBody BlogRequestDTO blogRequest,BindingResult result) {

		if (result.hasErrors()) {
			StringBuilder errors = new StringBuilder();
			result.getFieldErrors().forEach(err -> errors.append(err.getField()).append(" - ")
					.append(err.getDefaultMessage()).append(System.lineSeparator()));
			return ResponseEntity.badRequest().body(errors.toString());
		}
        if (blogRequest.getIsActive()) {
            return blogService.updateBlog(blogRequest.getId(), blogRequest.getAuthor(), blogRequest.getIsActive());
        } else {
            return blogService.deleteBlog(blogRequest.getId());
        }
    }

    @GetMapping("/getBlogById/{id}")
    public ResponseEntity<?> getBlogById(@PathVariable UUID id) {
        return blogService.getBlogById(id);
    }

}
