package com.aetios.projetospringmongo.resources;

import com.aetios.projetospringmongo.domain.User;
import com.aetios.projetospringmongo.dto.UserDTO;
import com.aetios.projetospringmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value = "/{id}", method= RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    @RequestMapping(method= RequestMethod.POST) // OU @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDto){
        User obj = service.fromDTO(objDto); // Conversão DTO para User
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri(); //Busca do novo endereço inserido
        return ResponseEntity.created(uri).build(); // Retorna resposta vazia com código 201, cabecalho contendo a localização do recurso criado
    }
}


