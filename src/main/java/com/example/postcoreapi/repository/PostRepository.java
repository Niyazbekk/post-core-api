package com.example.postcoreapi.repository;

import com.example.postcoreapi.model.PostModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PostRepository extends CrudRepository<PostEntity,Long> {
    PostEntity getPostEntityByPostID(String postID);

    @Transactional
    void deletePostEntitiesByPostID(String postID);

}
