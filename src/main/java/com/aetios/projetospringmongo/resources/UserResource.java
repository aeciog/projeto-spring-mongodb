package com.aetios.projetospringmongo.resources;

import com.aetios.projetospringmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){
        User usuario1 = new User("1", "user um", "user1@gmail.com");
        User usuario2 = new User("2", "user dois", "user2@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(usuario1, usuario2));
        return ResponseEntity.ok().body(list);
    }
}


