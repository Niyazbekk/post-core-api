package com.example.postcoreapi.service;

import com.example.postcoreapi.model.PostModel;
import com.example.postcoreapi.repository.PostEntity;
import com.example.postcoreapi.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public String createPost(PostEntity postEntity){
        postEntity.setPostID(UUID.randomUUID().toString());
        postRepository.save(postEntity);
        return "OK";
    };

    @Override
    public List<PostEntity> getAllPosts(){
        return (List<PostEntity>) postRepository.findAll();
    };

    @Override
    public PostEntity getPostById(String postID){
        return postRepository.getPostEntityByPostID(postID);
    };

    @Override
    public void updatePostById(String postID , PostEntity postEntity){
        PostEntity dbEntity = postRepository.getPostEntityByPostID(postID);
        dbEntity.setPostID(postEntity.getPostID());
        dbEntity.setPostItem(postEntity.getPostItem());
        dbEntity.setClientID(postEntity.getClientID());
        dbEntity.setPostRecipientId(postEntity.getPostRecipientId());
        dbEntity.setStatus(postEntity.getStatus());

        postRepository.save(dbEntity);
    };

    @Override
    public void deletePostById(String postID){
        postRepository.deletePostEntitiesByPostID(postID);
    };

}
