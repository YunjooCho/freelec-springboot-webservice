package com.yjcho.springboot.domain.posts;


import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @After //Junit에서 단위테스트가 끝날때마다 수행되는 메소드
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        String title = "테스트 게시글";
        String content = "테스트 본문";


        //given
        postsRepository.save( //insert into, update
                Posts.builder()
                        .title(title)
                        .content(content)
                        .author("blarblar")
                        .build()
        );

        //when
        List<Posts> postsList = postsRepository.findAll(); //select * from ~~

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록(){
        //given
        LocalDateTime now = LocalDateTime.of(2000,12,31,0,0,0);
        postsRepository.save(Posts.builder()
                .title("바람")
                .content("소리")
                .author("좋다")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll(); //select * from posts;

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>> createDate : " + posts.getCreatedDate()+"" 
                + ", modifiedDate : " + posts.getModifiedDate());
        
        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);

    }

}
