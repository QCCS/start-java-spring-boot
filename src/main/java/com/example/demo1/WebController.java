package com.example.demo1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhouli on 18/5/4.
 */
@Controller
public class WebController {
    @GetMapping("/index")
    public String index(){
        //如果没有这个页面，会报错
        return "index"; //当浏览器输入/index时，会返回 /templates/index.html页面
    }
    @GetMapping("/home")
    public String home(){
        return "home"; //当浏览器输入/index时，会返回 /templates/home.html页面
    }
}
