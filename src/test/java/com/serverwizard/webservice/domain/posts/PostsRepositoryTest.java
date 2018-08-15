package com.serverwizard.webservice.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void cleanup() {
        /**
         이후 테스트 코드에 영향을 끼치지 않기 위해
         테스트 메소드가 끝날때 마다 respository 전체 비우는 코드
         **/
        postsRepository.deleteAll();
    }


    @Test
    public void 게시글_저장_불러오기() {
        //given
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder()
                .title("제목")
                .contents("내용")
                .author("서버위저드")
                .build());

        //when
       List<Posts> posts = postsRepository.findAll();

       //then
        Posts post = posts.get(0);
        assertThat(post.getTitle()).isEqualTo("제목");
        assertThat(post.getContents()).isEqualTo("내용");
        assertThat(post.getAuthor()).isEqualTo("서버위저드");
        assertThat(post.getCreatedTime()).isAfter(now);
        assertThat(post.getModifiedTime()).isAfter(now);
    }
}