package com.example.postcoreapi.service;

import com.example.postcoreapi.model.PostModel;
import com.example.postcoreapi.repository.PostEntity;

import java.util.List;

public interface PostService {

    String createPost(PostEntity postEntity);

    List<PostEntity> getAllPosts();

    PostEntity getPostById(String postID);

    void updatePostById(String postID , PostEntity postEntity);

    void deletePostById(String postID);

}
