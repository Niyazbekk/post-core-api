package com.example.postcoreapi.service;

import com.example.postcoreapi.model.PostRequest;
import com.example.postcoreapi.model.PostResponse;
import com.example.postcoreapi.repository.PostEntity;

import java.util.List;

public interface PostService {

    PostResponse createPost(PostRequest postRequest);

    List<PostResponse> getAllPosts();

    PostResponse getPostById(String postID);

    PostResponse updatePostById(PostRequest postRequest);

    PostResponse deletePostById(String postID);

}
