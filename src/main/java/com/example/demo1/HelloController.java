package com.example.demo1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhouli on 18/5/1.
 */
@RestController
public class HelloController {
    @RequestMapping(value = "/api", method = RequestMethod.GET)
    public String any() {
        return "test first api";
    }
}
