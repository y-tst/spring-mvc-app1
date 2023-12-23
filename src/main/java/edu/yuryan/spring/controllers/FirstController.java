package edu.yuryan.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {
        //    (input parameters into address line is obligatory or use required = false)

//        System.out.println("Parameters: name = " + name + ", surname = " + surname);
        model.addAttribute("message", "Parameters: name = " + name + ", surname = " + surname);
        return "/first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "/first/goodbye";
    }

    @GetMapping("/calculator")
    public String countingResult(@RequestParam(value = "a", required = false) int a,
                                 @RequestParam(value = "b", required = false) int b,
                                 @RequestParam(value = "operation", required = false) String operation,
                                 Model model) {
        int result = -1;
        switch (operation) {
            case "plus":
                result = a + b;
                break;
            case "minus":
                result = a - b;
                break;
            case "multiple":
                result = a * b;
                break;
            case "divide":
                result = a / b;
                break;
        }

        model.addAttribute("countResult", "a " + operation + " b equal to " + result);
        return "/calculator/result";
    }
}
