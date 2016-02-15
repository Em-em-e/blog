package com.coderliang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.coderliang.base.BaseDao;
import com.coderliang.entity.User;

/**
 * 用户表操作类
 * @author Administrator
 *
 */
public class UserDao {
	
	public User findUserByName(String username){
		User user=null;
		Connection con=null;
		String sql="select * from user where username=?";
		try {
			con=BaseDao.getConnection();
			PreparedStatement state=con.prepareStatement(sql);
			state.setString(1, username);
			ResultSet rs=state.executeQuery();
			while(rs.next()){
				user=new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeConnection(con);
		}
		return user;
	}
}
