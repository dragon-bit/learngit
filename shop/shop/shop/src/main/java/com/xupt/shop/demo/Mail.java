package com.xupt.shop.demo;

import com.xupt.shop.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mail {
    @Autowired
    private MailService mailService;
    @RequestMapping("/mail")
    public void sendSimpleMail(String mail) {
        mailService.sendSimpleMail(mail,"西邮派验证码","abcd");
    }

}