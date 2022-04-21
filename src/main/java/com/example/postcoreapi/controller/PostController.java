package com.example.postcoreapi.controller;

import com.example.postcoreapi.model.PostRequest;
import com.example.postcoreapi.model.PostResponse;
import com.example.postcoreapi.repository.PostEntity;
import com.example.postcoreapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    Environment env;


    @GetMapping("/check")
    public String check(){
        return "post-core-api is working at " + env.getProperty("local.server.port") + " port";
    }

    @PostMapping
    public PostResponse createPost(@Valid @RequestBody PostRequest postRequest) {
        return postService.createPost(postRequest);
    }

    @GetMapping("/all")
    public List<PostResponse> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("/{postID}")
    public PostResponse getPostById(@PathVariable String postID) {
        return postService.getPostById(postID);
    }

    @PutMapping("/{postID}")
    public PostResponse updatePostById(@Valid @RequestBody PostRequest postRequest) {
        return postService.updatePostById(postRequest);
    }

    @DeleteMapping("/{postID}")
    public PostResponse deletePostById(@PathVariable String postID) {
        return postService.deletePostById(postID);
    }

}
