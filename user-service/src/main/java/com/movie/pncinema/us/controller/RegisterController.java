package com.movie.pncinema.us.controller;

import com.movie.pncinema.utils.captcha.CaptchaUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class RegisterController {

    @PostMapping("/catpcha")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) {
        try {
            CaptchaUtil.out(70, 30, 4, request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
