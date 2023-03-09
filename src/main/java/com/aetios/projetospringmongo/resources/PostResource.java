package com.aetios.projetospringmongo.resources;

import com.aetios.projetospringmongo.domain.Post;
import com.aetios.projetospringmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;


    @RequestMapping(value = "/{id}", method= RequestMethod.GET)
    public ResponseEntity<Optional<Post>> findById(@PathVariable String id){
        Optional<Post> obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}


