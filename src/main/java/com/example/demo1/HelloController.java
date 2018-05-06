package com.example.demo1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhouli on 18/5/1.
 */
@RestController
public class HelloController {

    //可以从配置文件获取值
    @Value("${age}")
    private String age;

    @RequestMapping(value = "/api", method = RequestMethod.GET)
    public String any() {
        return "test first api";
    }

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public String getUsername() {
        return age;
    }


    //获取路由的参数
    //http://localhost:1111/test/10/name
    @RequestMapping(value = "/{id}/name", method = RequestMethod.GET)
    public String getId(@PathVariable("id") Integer id) {
        return "id="+id;
    }

    //获取路由的请求参数
    //http://localhost:1111/test/getparam?id=11
    @RequestMapping(value = "/getparam", method = RequestMethod.GET)
    public String getParam(@RequestParam("id") Integer id) {
        return "paramId="+id;
    }

}
