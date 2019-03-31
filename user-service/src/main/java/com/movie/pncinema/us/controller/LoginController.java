package com.movie.pncinema.us.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.pncinema.common.dto.JsonResponse;
import com.movie.pncinema.user.api.entity.po.AccountPO;
import com.movie.pncinema.user.api.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@GetMapping("/user/api/list")
	public ResponseEntity<List<AccountPO>> list(){
		JsonResponse<List<AccountPO>> result = new JsonResponse<List<AccountPO>>();
		List<AccountPO> list = loginService.list();
		result.setCode(200);
		result.setMessage("OK");
		result.setData(list);
		return result;
	}
	
}
