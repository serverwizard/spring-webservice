package com.serverwizard.webservice.web;

import com.serverwizard.webservice.domain.posts.PostsRepository;
import com.serverwizard.webservice.dto.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/posts")
public class PostsController {

    private PostsRepository postsRepository;

    @PostMapping
    public void savePosts(@RequestBody PostsSaveRequestDto dto){
        postsRepository.save(dto.toEntity());
    }

}
