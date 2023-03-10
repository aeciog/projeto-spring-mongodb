package com.aetios.projetospringmongo.services;

import com.aetios.projetospringmongo.domain.Post;
import com.aetios.projetospringmongo.repository.PostRepository;
import com.aetios.projetospringmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PostService {
    
    @Autowired
    private PostRepository repo;

    public Optional<Post> findById(String id){
        Optional<Post> user = repo.findById(id);
        if(user == null){
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return user;
    }

    public List<Post> findByTitle(String text){
        return repo.findByTitleContainingIgnoreCase(text);
    }

}
