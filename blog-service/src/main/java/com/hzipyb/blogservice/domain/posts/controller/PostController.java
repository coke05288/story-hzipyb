package com.hzipyb.blogservice.domain.posts.controller;

import com.hzipyb.blogservice.domain.posts.entity.Post;
import com.hzipyb.blogservice.domain.posts.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @GetMapping
    public String getAllPost(Model model) {
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);

        return "post-list";
    }

    @GetMapping("/{postId}")
    public String getPostById(Model model, @PathVariable Long postId) {
        Post post = this.postService.getPostById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found with id"));

        model.addAttribute("post", post);

        return "post-detail";
    }

}
