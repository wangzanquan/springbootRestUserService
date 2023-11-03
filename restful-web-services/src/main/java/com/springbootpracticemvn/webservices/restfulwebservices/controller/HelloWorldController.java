package com.springbootpracticemvn.webservices.restfulwebservices.controller;

import org.springframework.web.bind.annotation.*;

//Rest API
@RestController
public class HelloWorldController {
    //  /hello-world

//    @RequestMapping(method = RequestMethod.GET,path = "/hello-world")
//    public String helloWorld() {
//        return "Hello World";
//    }

    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World!");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean("Hello World, %s" + name);
    }

}
