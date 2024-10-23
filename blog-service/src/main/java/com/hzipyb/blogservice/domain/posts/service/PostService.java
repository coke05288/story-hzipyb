package com.hzipyb.blogservice.domain.posts.service;

import com.hzipyb.blogservice.DataNotFoundException;
import com.hzipyb.blogservice.domain.posts.entity.Post;
import com.hzipyb.blogservice.domain.posts.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }
}
