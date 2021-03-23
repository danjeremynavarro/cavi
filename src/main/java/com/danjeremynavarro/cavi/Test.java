package com.danjeremynavarro.cavi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class Test {

    @GetMapping("/admin")
    public String test(HttpServletRequest request, HttpServletResponse response){
        return "test";
    }
}
