package com.practice.post.service;

import com.practice.post.dto.PostDto;
import com.practice.post.entity.Post;
import com.practice.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<PostDto> getAll() {
        List<Post> posts = postRepository.findAll();
        List<PostDto> postDtos = new ArrayList<>();
        for(Post post : posts) {
            postDtos.add(post.toDto());
        }
        return postDtos;
    }

    public void create(String title, String content) {
        Post post = Post.builder()
                .title(title)
                .content(content)
                .createDateTime(LocalDateTime.now())
                .build();
        postRepository.save(post);
    }

    public PostDto getById(long id) {
        Post post = postRepository.findById(id).get();

        if(post == null) {
            //추가 예외처리 필요
        }

        return post.toDto();
    }

    public void delete(long id) {
        Post post = postRepository.findById(id).get();

        postRepository.delete(post);
    }
}
