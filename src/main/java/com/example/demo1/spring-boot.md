###配置文件
在application.properties

配置端口
```$xslt
server.port=8021
```


###配置输出模板文件
maven依赖
```$xslt
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

定位模板的目录
```$xslt
spring.mvc.view.prefix=classpath:/templates/
```
给返回的页面添加后缀名
```$xslt
spring.mvc.view.suffix=.html
```
```$xslt
@Controller
public class WebController {
    @GetMapping("/index")
    public String index(){
        return "index"; //当浏览器输入/index时，会返回 /templates/index.html页面
    }
    @GetMapping("/home")
    public String home(){
        return "home"; //当浏览器输入/index时，会返回 /templates/home.html页面
    }
}
```


###restful api
```$xslt
@RestController
public class HelloController {
    @RequestMapping(value = "/api", method = RequestMethod.GET)
    public String any() {
        return "test first api";
    }
}
```

###错误处理
```$xslt
@Controller
@RequestMapping(value = "error")
public class BaseErrorController implements ErrorController {
    private static final Logger logger = LoggerFactory.getLogger(BaseErrorController.class);

    @Override
    public String getErrorPath() {
        logger.info("error");
        return "error/error";
    }

    @RequestMapping
    public String error() {
        logger.info("1111");
        return getErrorPath();
    }

}
```
或者在resources目录下创建public/error/404.html页面

或者在resources目录下创建templates/error/500.html页面