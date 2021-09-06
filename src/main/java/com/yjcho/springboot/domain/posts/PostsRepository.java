package com.yjcho.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//DAO와 유사, interface로 생성, JpaRepository<Entity클래스, PK타입>로 CRUD메소드 자동생성
public interface PostsRepository extends JpaRepository<Posts, Long> {
    
    
}
