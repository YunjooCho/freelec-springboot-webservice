package com.yjcho.springboot.domain.posts;

import com.yjcho.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor //기본생성자 자동 추가
@Entity
public class Posts extends BaseTimeEntity {
    @Id //PrimaryKey
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PrimaryKey 생성규칙
    private Long id;

    @Column(length=500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

}
