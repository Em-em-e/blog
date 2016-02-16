package com.coderliang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.coderliang.base.BaseDao;
import com.coderliang.entity.Message;
/**
 * 实现对Message表的数据库操作
 * @author Administrator
 *
 */
public class MessageDao {
	private static int countMsg;
	
	static{
		countMsg=MessageDao.findMessageCount();
	}
	/**
	 * 查找所有的留言
	 */
	public List<Message> findAllMessages(int page){
		List<Message> list=new ArrayList<Message>();
		String sql="select * from message order by createtime desc limit ?,5";
		Connection con=null;
		try {
			con=BaseDao.getConnection();
			PreparedStatement state=con.prepareStatement(sql);
			state.setInt(1, (page-1)*5);
			ResultSet rs=state.executeQuery();
			while(rs.next()){
				Message me=new Message();
				me.setId(rs.getInt("id"));
				me.setMsg(rs.getString("msg"));
				me.setPhoto(rs.getString("photo"));
				me.setTime(rs.getDate("createtime"));
				list.add(me);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeConnection(con);
		}
		return list;
	}
	
	/**
	 * 查找留言总条数
	 * @return
	 */
	public static int findMessageCount(){
		List<Message> list=new ArrayList<Message>();
		String sql="select * from message";
		Connection con=null;
		try {
			con=BaseDao.getConnection();
			PreparedStatement state=con.prepareStatement(sql);
			ResultSet rs=state.executeQuery();
			while(rs.next()){
				Message me=new Message();
				me.setId(rs.getInt("id"));
				me.setMsg(rs.getString("msg"));
				me.setPhoto(rs.getString("photo"));
				me.setTime(rs.getDate("createtime"));
				list.add(me);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeConnection(con);
		}
		return list.size();
	}
	public static int getCountMsg() {
		return countMsg;
	}
	public static void setCountMsg(int countMsg) {
		MessageDao.countMsg = countMsg;
	}
	
}
