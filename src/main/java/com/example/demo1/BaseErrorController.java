package com.example.demo1;
import org.slf4j.*;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhouli on 18/5/4
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 */
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
