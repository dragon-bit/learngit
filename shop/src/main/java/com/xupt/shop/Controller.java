package com.xupt.shop;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping("/test")
    public String getA() {
        return "login.html";
    }
}
