package com.movie.pncinema.us.controller;

import com.movie.pncinema.common.dto.ResponseEntity;
import com.movie.pncinema.us.dao.AccountMapper;
import com.movie.pncinema.utils.captcha.CaptchaUtil;
import com.movie.pncinema.utils.redis.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@Api(value = "用户注册接口")
public class RegisterController {

    @Autowired
    private AccountMapper accountMapper;

    @PostMapping("/user/catpcha")
    @ApiOperation(value = "获取验证码", notes = "根据输入的用户名来声称验证码，未输入需要注册的用户名则无法生成验证码。")
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
    @PostMapping("/user/testredis")
    @ApiOperation(value = "验证用户名是否存在（是否已经被注册）")
    public ResponseEntity validUsername(String username) {
        // TODO: 验证用户名是否重复，注册用
        RedisUtils.set("test", "Hello World", 120L);
        ResponseEntity result = new ResponseEntity();
        result.setCode(200);
        result.setData(RedisUtils.exists("test"));
        result.setMessage("测试redis");

        return result;
    }


}
