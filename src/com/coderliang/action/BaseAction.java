package com.coderliang.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
/**
 * 继承该类的action可以直接获取session对象
 * @author Administrator
 *
 */
public class BaseAction implements SessionAware{
	protected Map<String,Object> session;
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

}
