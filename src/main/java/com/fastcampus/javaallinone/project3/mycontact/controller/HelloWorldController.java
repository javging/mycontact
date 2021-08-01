package com.fastcampus.javaallinone.project3.mycontact.controller;

//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
// 레스트 컨트롤러 하면 위에 2개 없어도 됨,, 포함돼있음. cmd+B 눌러서 확인해볼 수 있음,,
@RestController //(value = "/api")
public class HelloWorldController {
    @GetMapping(value="/api/helloWorld")
    public String helloWorld() {
        return "hello world!";
    }
}
