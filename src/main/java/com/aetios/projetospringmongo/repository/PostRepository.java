package com.aetios.projetospringmongo.repository;

import com.aetios.projetospringmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    // Query method
    List<Post> findByTitleContainingIgnoreCase(String text);
}
