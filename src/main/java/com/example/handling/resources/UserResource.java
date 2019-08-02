package com.example.handling.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserResource {

    @RequestMapping("/add")
    public String add() {
        int num = 10 / 0;
        return "add";
    }

    @ExceptionHandler(value = {ArithmeticException.class})
    public ModelAndView handleArithmeticException(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e.toString());
        modelAndView.setViewName("mathError");
        return modelAndView;
    }
}
