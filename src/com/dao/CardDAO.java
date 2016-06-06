package com.dao;

import java.util.List;

import com.entity.Card;
import com.tools.BeanRowMapper;
import com.tools.DBHelper;

public class CardDAO {
	DBHelper<Card> db = new DBHelper<Card>(Conf.DB_URL);

	public boolean addC(Card c) {
		String sql = "insert into Card (code,name,tel) values(?,?,?)";
		return db.doUpdate(sql, c.getCode(), c.getName(), c.getTel()) == 1;
	}
	
	public boolean deleteC(String str) {
		String sql = "delete from Card where id=? or code=? or name=?";
		return db.doUpdate(sql, str, str, str) == 1;
	}
	
	public boolean updateC(Card c) {
		String sql = "update `card` set code=?,name=?,tel=? where id=?";
		return db.doUpdate(sql, c.getCode(),c.getName(),c.getTel(),c.getId()) == 1;
	}
	
	public Card selectC(String str) {
		String sql = "select * from `card` where code=? or id=? or name=?";
		return db.doQueryOne(sql, new BeanRowMapper<Card>(Card.class),str,str,str);
	}

	public Card findC(String str) {
		String sql = "select * from `card` where `code` like '%" + str + "%' or `name` like '%" + str + "%'";
		return db.doQueryOne(sql, new BeanRowMapper<Card>(Card.class));
	}
	
	public List<Card> findAll() {
		String sql = "select * from `card`";
		return db.doQueryAll(sql, new BeanRowMapper<Card>(Card.class));
	}
}
