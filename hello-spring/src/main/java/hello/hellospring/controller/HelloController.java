package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    //    localhost:8080/hello
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        // templates/hello.html
        return "hello";
    }

    //    localhost:8080/hello-mvc?name="minjungkim"
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    //    localhost:8080/hello-string?name="minjungkim"
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // "hello minjungkim"
    }

    //    localhost:8080/hello-api?name=minjungkim
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // JSON {"name":"minjungkim"}
    }

    static class Hello {
        private String name;

        // getter setter -> java bean 규약
        // getter -> JSON  응답
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
