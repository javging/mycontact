package com.fastcampus.javaallinone.project3.mycontact.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class HelloWorldControllerTest {
    // 컨트롤러에 helloWorld 메서드를 PostMapping 으로 바꾸고 테스트 전체를 실행하면
    // 첫번째 helloWorld 테스트는 성공(메서드를 그냥 실행시켜서 결과값확인하는거니까)
    // mockMvcTest는 실패(메서드가 달라져서 호출이 안됨)


    @Autowired
    private HelloWorldController helloWorldController;
    // @Autowired 로 HelloWorldController 선언한 것은 스프링 컨텍스트에서 bin을 주입하겠다는?

    private MockMvc mockMvc;

    @Test
    void helloWorld() {
        System.out.println(helloWorldController.helloWorld());
        // System.out.println("test");

        assertThat(helloWorldController.helloWorld()).isEqualTo("hello world!");
        // http 리퀘스트 없이 바로 메서드 실행해서 결과값 테스트,,
    }

    @Test
    void mockMvcTest() throws Exception {
        // mockMVC테스트 - 모의 request, responce 만들어서 테스트하는 방식
        mockMvc = MockMvcBuilders.standaloneSetup(helloWorldController).build();

        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/helloWorld")
        ).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("hello world!"));
    }
}