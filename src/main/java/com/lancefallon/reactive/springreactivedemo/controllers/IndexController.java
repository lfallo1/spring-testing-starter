package com.lancefallon.reactive.springreactivedemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping("/")
    public ModelAndView getIndex() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("title", "Index Page");
        mv.addObject("pageTitle", "Index Page");
        return mv;
    }

}
