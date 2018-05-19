package com.example.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.internet.MimeMessage;

/**
 * Created by zhouli on 18/5/19
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 */
@RestController
@RequestMapping("/mail")
public class MailController {
    @Autowired
    JavaMailSender mailSender;

    @ResponseBody
    @RequestMapping(value = "/send",method = RequestMethod.GET)
    public Object sendEmail(@RequestParam("id") String id) {
        try {
            System.out.println("发送邮件测试");
            final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
            final MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
            message.setFrom("15921552946@163.com");
            String targetMail = id;
            System.out.println(targetMail);
            message.setTo(targetMail);
            message.setSubject("IT资源大放送");
            message.setText("请加qq：2138420383,或者微信：qianchaochushui");
            this.mailSender.send(mimeMessage);
            return "sucesss";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "error";
        }
    }

}
