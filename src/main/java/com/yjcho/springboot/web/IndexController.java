package com.yjcho.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
        //머스테치 스타터로 인해 prefix, suffix 자동 지정
        //prefix : src/main/resource/templates
        //suffix : .mustache
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }
}
