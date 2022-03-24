package com.example.postcoreapi.service;

import com.example.postcoreapi.model.PostModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService{
    private static final HashMap<String, PostModel> postMap = new HashMap<>();

    static {
        PostModel postModel1 = new PostModel(
                UUID.randomUUID().toString() ,
                UUID.randomUUID().toString() ,
                UUID.randomUUID().toString(),
                "Письмо" , "Отправлено из центра сортировки");

        PostModel postModel2 = new PostModel(
                UUID.randomUUID().toString() ,
                UUID.randomUUID().toString() ,
                UUID.randomUUID().toString(),
                "Бандероль" , "Прибыло в центр сортировки");

        PostModel postModel3 = new PostModel(
                UUID.randomUUID().toString() ,
                UUID.randomUUID().toString() ,
                UUID.randomUUID().toString(),
                "Посылка" , "Принято почтовое отправление");

        postMap.put(postModel1.getPostID() , postModel1);
        postMap.put(postModel2.getPostID() , postModel2);
        postMap.put(postModel3.getPostID() , postModel3);

    }

    @Override
    public void createPost(PostModel postModel){
        postModel.setPostID(UUID.randomUUID().toString());
        postMap.put(postModel.getPostID(), postModel);
    };

    @Override
    public List<PostModel> getAllPosts(){
        return new ArrayList<>(postMap.values());
    };

    @Override
    public PostModel getPostById(String postID){
        return postMap.get(postID);
    };

    @Override
    public void updatePostById(String postID , PostModel postModel){
        postModel.setPostID(postID);
        postMap.put(postID,postModel);
    };

    @Override
    public void deletePostById(String postID){
        postMap.remove(postID);
    };

}
