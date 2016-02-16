package com.coderliang.action;

import com.coderliang.dao.UserDao;
import com.coderliang.entity.User;

public class LoginAction extends BaseAction{
	private String username;
	private String password;
	private String check_code="";
	private String login_msg;
	
	public String execute(){
		UserDao dao=new UserDao();
		User user=dao.findUserByName(username);
		String code=(String) session.get("validateCode");
		if(check_code.equalsIgnoreCase(code)){
			if(user!=null){
				if(user.getPassword().equals(password)){
					login_msg="登陆成功！";
					session.put("user", user);
					return "success";
				}else{
					login_msg="密码错误！";
				}
			}else{
				login_msg="用户名不存在！";
			}
		}else{
			login_msg="验证码错误！";
		}
		return "fail";
	}
	
	public String loginOut(){
		User user=(User) session.get("user");
		if(user!=null){
			session.remove("user");
		}
		
		return "success";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCheck_code() {
		return check_code;
	}

	public void setCheck_code(String check_code) {
		this.check_code = check_code;
	}

	public String getLogin_msg() {
		return login_msg;
	}

	public void setLogin_msg(String login_msg) {
		this.login_msg = login_msg;
	}

	
	
}
