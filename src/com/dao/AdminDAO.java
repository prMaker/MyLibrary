package com.dao;

import com.entity.Admin;
import com.tools.BeanRowMapper;
import com.tools.DBHelper;

public class AdminDAO {
	DBHelper<Admin> db = new DBHelper<>(Conf.DB_URL);
	public boolean find(String name ,String password){
		String sql = "select 1 from `Admin` where name = ? and password = ?";
		return db.doQueryOne(sql,new BeanRowMapper<Admin>(Admin.class), name,password) != null;
	}
}
