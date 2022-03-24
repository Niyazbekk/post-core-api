package com.example.postcoreapi.service;

import com.example.postcoreapi.model.PostModel;

import java.util.List;

public interface PostService {

    void createPost(PostModel postModel);

    List<PostModel> getAllPosts();

    PostModel getPostById(String postID);

    void updatePostById(String postID , PostModel postModel);

    void deletePostById(String postID);

}
