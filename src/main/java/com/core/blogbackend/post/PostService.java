package com.core.blogbackend.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public List<Post> getPosts(){
        return postRepository.findAll();
    }

    public Optional<Post> getPostBySlugTitle(String slugTitle){
        return postRepository.getPostBySlugTitle(slugTitle);
    }

    public void addNewPost(Post post) {
        Optional<Post> postOptional = postRepository.findPostByTitle(post.getTitle());
        if(postOptional.isPresent())
            throw  new IllegalStateException("Post title already exist.");
        postRepository.save(post);

    }

    public void updatePost(Post post, Long postId){
        Optional<Post> postOptional = postRepository.findById(postId);
        if(!postOptional.isPresent())
            throw new IllegalStateException("Post does not exist!");
        post.setId(postId);
        postRepository.save(post);
        ResponseEntity.noContent().build();
    }

    public void deletePost(Long postId){
        boolean isExist = postRepository.existsById(postId);
        if(!isExist)
            throw new IllegalStateException("Post does not exist");
        postRepository.deleteById(postId);
    }
}
