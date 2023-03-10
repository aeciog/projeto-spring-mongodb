package com.aetios.projetospringmongo.config;

import com.aetios.projetospringmongo.domain.Post;
import com.aetios.projetospringmongo.domain.User;
import com.aetios.projetospringmongo.dto.AuthorDTO;
import com.aetios.projetospringmongo.dto.CommentDTO;
import com.aetios.projetospringmongo.repository.PostRepository;
import com.aetios.projetospringmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User user1 = new User(null, "Usuario 1", "usuario_1@gmail.com");
        User user2 = new User(null, "Usuario 2", "usuario_2@gmail.com");
        User user3 = new User(null, "Usuario 3", "usuario_3@gmail.com");
        userRepository.saveAll(Arrays.asList(user1, user2, user3));

        Post post1 = new Post(null, sdf.parse("08/03/2023"), "Titulo 1", "Texto a ser inserido.", new AuthorDTO(user1));
        Post post2 = new Post(null, sdf.parse("08/03/2023"), "Titulo 2", "Texto a ser inserido.", new AuthorDTO(user1));
        Post post3 = new Post(null, sdf.parse("10/03/2023"), "Titulo 3", "Texto a ser inserido.", new AuthorDTO(user2));

        CommentDTO comment1 = new CommentDTO("Comentario a ser inserido",sdf.parse("09/03/2023"), new AuthorDTO(user3));
        CommentDTO comment2 = new CommentDTO("Comentario a ser inserido 2",sdf.parse("11/03/2023"), new AuthorDTO(user1));
        CommentDTO comment3 = new CommentDTO("Comentario a ser inserido 3",sdf.parse("12/03/2023"), new AuthorDTO(user2));

        post1.getComments().add(comment1);
        post2.getComments().add(comment2);
        post3.getComments().add(comment3);


        postRepository.saveAll(Arrays.asList(post1, post2, post3));

        user1.getPosts().addAll(Arrays.asList(post1, post2));

        userRepository.save(user1);

    }
}
