package com.example.postcoreapi.repository;

import com.example.postcoreapi.model.PostResponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<PostEntity,Long> {
    PostEntity getPostEntityByPostID(String postID);

    @Transactional
    PostResponse deletePostEntitiesByPostID(String postID);

    List<PostEntity> getPostEntitiesBy();

}
