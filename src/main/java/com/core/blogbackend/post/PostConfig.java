package com.core.blogbackend.post;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class PostConfig {
    @Bean
    CommandLineRunner commandLineRunner(PostRepository postRepository){
        return args -> {
            Post ml = new Post(
                    "Machine Learning",
                    1L,
                    "machine-learning-basics",
                    LocalDate.of(1979, Month.DECEMBER, 3),
                    1
            );

            postRepository.save(ml);
        };
    }
}
