package com.example.myproject.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("app/v1/tests/")
public class TestController{

@GetMapping()
    public String getName(){
    return "Muhammad Mubashir";
}

}