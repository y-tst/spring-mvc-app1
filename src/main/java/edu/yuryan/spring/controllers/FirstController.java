package edu.yuryan.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping ("/prior-link")  -  prior link will be added to all links i.g /prior-link/hello, ! it should be considered in links from view folders!
public class FirstController {

    @GetMapping("/hello")
    public String helloPage() {
        return "/first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "/first/goodbye";
    }
}
