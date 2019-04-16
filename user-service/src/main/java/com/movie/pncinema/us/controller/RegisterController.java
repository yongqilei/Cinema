package com.movie.pncinema.us.controller;

import com.movie.pncinema.common.dto.ResponseEntity;
import com.movie.pncinema.us.dao.AccountMapper;
import com.movie.pncinema.utils.captcha.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class RegisterController {

    @Autowired
    private AccountMapper accountMapper;

    @PostMapping("/catpcha")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) {
        try {
            CaptchaUtil.out(70, 30, 4, request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 验证用户名是否重复
     * @param username 注册时填写的用户名
     * @return 是否重复
     */
    @PostMapping("/")
    public ResponseEntity validUsername(String username) {
        // TODO: 验证用户名是否重复，注册用
        return null;
    }


}
