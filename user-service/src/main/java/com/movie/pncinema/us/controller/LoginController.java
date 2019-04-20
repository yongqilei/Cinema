package com.movie.pncinema.us.controller;

import java.io.IOException;
import java.util.List;

import com.movie.pncinema.utils.captcha.CaptchaUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.movie.pncinema.common.dto.ResponseEntity;
import com.movie.pncinema.user.api.entity.po.AccountPO;
import com.movie.pncinema.user.api.service.LoginService;

@RestController
@Api(value = "用户登录接口")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/user/api/list")
    @ApiOperation(value = "用户查询接口（测试）", notes = "用于测试数据库链接是否正常")
    public ResponseEntity list() {
        ResponseEntity result = new ResponseEntity();
        List<AccountPO> list = loginService.list();
        result.setCode(200);
        result.setMessage("OK");
        result.setData(list);
        return result;
    }

//    @PostMapping("/login")
//    public ResponseEntity<Object> login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) {
//        request.getRequestedSessionId();
//
//    }



}
