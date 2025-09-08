package com.example.springbootprac.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data","Hello!!");
        return "hello";

    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name",name);
        return "hello-template";
    }
    @GetMapping("hello-string")
    @ResponseBody //HTTP에서 바디에 아래 데이터를 그대로 넣는다
    public String helloString(@RequestParam("name") String name, Model model) {
        return "hello " + name; //hello Stirng으로 출력
    }

    @GetMapping("Hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
    }
}
