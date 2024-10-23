package com.hzipyb.blogservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @GetMapping("/list")
    public String showPostList(Model model) {
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);

        return "post-list";
    }

    @GetMapping("/{id}")
    public String showPostDetails(Model model, @PathVariable Long id) {
        Post post = this.postService.getPostById(id);

        model.addAttribute("post", post);

        return "post-detail";
    }

}
