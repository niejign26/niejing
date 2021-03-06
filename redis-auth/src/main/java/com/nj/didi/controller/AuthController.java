package com.nj.didi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nj.didi.service.AuthService;
import com.nj.didi.vo.ReturnVo;

@RestController
public class AuthController {

	@Autowired
	private AuthService authService;
	
	@RequestMapping("/save")
	public ReturnVo<String> save(String userName,String passWord){
		ReturnVo<String> returnvo = new ReturnVo<String>();
		try{
			if(StringUtils.isEmpty(userName)){
				return returnvo;
			}
			authService.insert(userName,passWord);
			returnvo.setReturnCode(200);
			returnvo.setReturnMsg("SUCCESS");
		}catch(Exception e){
			returnvo.setReturnCode(500);
			returnvo.setReturnMsg("FAIL");
		}
		
		return returnvo;
	}
	
	@RequestMapping("/getValue")
	public ReturnVo<String> getExpire(String userName){
		ReturnVo<String> returnvo = new ReturnVo<String>();
		try{
			String value = authService.getValue(userName);
			returnvo.setReturnCode(200);
			returnvo.setReturnMsg("SUCCESS");
			returnvo.setT(value);
		}catch(Exception e){
			returnvo.setReturnCode(500);
			returnvo.setReturnMsg("FAIL");
		}
		
		return returnvo;
	}
}
