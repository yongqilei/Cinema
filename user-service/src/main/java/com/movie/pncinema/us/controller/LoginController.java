package com.movie.pncinema.us.controller;

import java.io.IOException;
import java.util.List;

import com.movie.pncinema.utils.captcha.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.movie.pncinema.common.dto.ResponseEntity;
import com.movie.pncinema.user.api.entity.po.AccountPO;
import com.movie.pncinema.user.api.service.LoginService;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/user/api/list")
    public ResponseEntity<List<AccountPO>> list() {
        ResponseEntity<List<AccountPO>> result = new ResponseEntity<List<AccountPO>>();
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
