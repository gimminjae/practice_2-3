package com.practice.post.controller;

import com.practice.post.dto.PostDto;
import com.practice.post.entity.Post;
import com.practice.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("postList", postService.getAll());

        return "post/list";
    }
    @GetMapping("")
    public String form() {
        return "post/write";
    }
    @PostMapping("")
    public String write(@RequestParam String title, @RequestParam String content) {
        postService.create(title, content);

        return "redirect:/post/all";
    }
    @GetMapping("/{id}")
    public String detail(@PathVariable long id, Model model) {
        PostDto postDto = postService.getById(id);

        model.addAttribute("post", postDto);

        return "post/detail";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {
        postService.delete(id);

        return "redirect:/post/all";
    }
}
