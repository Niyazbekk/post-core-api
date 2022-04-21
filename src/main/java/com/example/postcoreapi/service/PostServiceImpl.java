package com.example.postcoreapi.service;


import com.example.postcoreapi.model.PostRequest;
import com.example.postcoreapi.model.PostResponse;
import com.example.postcoreapi.repository.PostEntity;
import com.example.postcoreapi.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public PostResponse createPost(PostRequest postRequest){
        postRequest.setPostID(UUID.randomUUID().toString());

        PostEntity postEntity = modelMapper.map(postRequest,PostEntity.class);
        postEntity = postRepository.save(postEntity);
        return modelMapper.map(postEntity, PostResponse.class);
    };

    @Override
    public List<PostResponse> getAllPosts(){
        return postRepository.getPostEntitiesBy().stream()
                .map(post -> modelMapper.map(post,PostResponse.class))
                .collect(Collectors.toList());
    };

    @Override
    public PostResponse getPostById(String postID){
        PostEntity postEntity = postRepository.getPostEntityByPostID(postID);
        return modelMapper.map(postEntity, PostResponse.class);
    };

    @Override
    public PostResponse updatePostById(PostRequest postRequest){
        PostEntity postEntity = modelMapper.map(postRequest, PostEntity.class);

        PostEntity dbEntity = postRepository.getPostEntityByPostID(postRequest.getPostID());
        postEntity.setId(dbEntity.getId());

        postEntity = postRepository.save(postEntity);

        return modelMapper.map(postEntity, PostResponse.class);
    };

    @Override
    public PostResponse deletePostById(String postID){
        return postRepository.deletePostEntitiesByPostID(postID);
    };

}
