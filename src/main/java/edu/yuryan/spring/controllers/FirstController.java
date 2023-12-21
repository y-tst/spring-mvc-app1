package edu.yuryan.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/prior-link")
// prior link will be added to all links i.g /prior-link/hello, ! it should be considered in links from view folders!
public class FirstController {

    @GetMapping("/hello")
//  *** this variant gets parameters from HttpServletRequest object, which contains a lot of info
//    (input parameters into address line is not obligatory)
//    public String helloPage(HttpServletRequest request) {
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");

    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname) {
        //    (input parameters into address line is obligatory or use required = false)

        System.out.println("Parameters: name = " + name + ", surname = " + surname);
        return "/first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "/first/goodbye";
    }
}
