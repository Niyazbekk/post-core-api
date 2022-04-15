package com.example.postcoreapi.controller;

import com.example.postcoreapi.model.PostModel;
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
    public ResponseEntity<String> createPost(@Valid @RequestBody PostEntity postEntity) {
        postService.createPost(postEntity);
        return new ResponseEntity<>("Successfully created", HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<PostEntity> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("/{postID}")
    public PostEntity getPostById(@PathVariable String postID) {
        return postService.getPostById(postID);
    }

    @PutMapping("/{postID}")
    public ResponseEntity<String> updatePostById(@PathVariable String postID,
                                                     @Valid @RequestBody PostEntity postEntity) {
        postService.updatePostById(postID, postEntity);
        return new ResponseEntity<>("Successfully updated", HttpStatus.OK);
    }

    @DeleteMapping("/{postID}")
    public ResponseEntity<String> deletePostById(@PathVariable String postID) {
        postService.deletePostById(postID);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }

}
