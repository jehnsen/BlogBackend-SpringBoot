package com.core.blogbackend.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/post")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getPosts(){
        return postService.getPosts();
    }

    @GetMapping(path = "{slugTitle}")
    public Optional<Post> getPostBySlug(@PathVariable("slugTitle") String slugTitle){
        return postService.getPostBySlugTitle(slugTitle);
    }

    @PostMapping
    public void addNewPost(@RequestBody Post post){
        postService.addNewPost(post);
    }

    @PutMapping(path="{id}")
    public void updatePost(@RequestBody Post post, @PathVariable("id") Long id){
        postService.updatePost(post, id);
    }

    @DeleteMapping(path = "{id}")
    public void deletePost(@PathVariable("id") Long id){
        postService.deletePost(id);
    }
}
