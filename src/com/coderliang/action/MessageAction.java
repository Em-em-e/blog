package com.coderliang.action;

import java.util.ArrayList;
import java.util.List;

import com.coderliang.dao.MessageDao;
import com.coderliang.entity.Message;

public class MessageAction{
	private int totalPage;
	private int page=1;
	private List<Message> list=new ArrayList<Message>();
	public String execute(){
		MessageDao dao=new MessageDao();
		list=dao.findAllMessages(page);
		int a=MessageDao.getCountMsg();
		totalPage=a%5==0?(a/5):(a/5+1);
		return "success";
	}
	public List<Message> getList() {
		return list;
	}
	public void setList(List<Message> list) {
		this.list = list;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
}
