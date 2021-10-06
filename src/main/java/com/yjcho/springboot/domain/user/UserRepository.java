package com.yjcho.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    
    //신규 가입자인지 기존 사용자인지 판단
    Optional<User> findByEmail(String email);
}
