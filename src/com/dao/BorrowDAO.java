package com.dao;

import com.entity.Borrow;
import com.tools.BeanRowMapper;
import com.tools.DBHelper;

public class BorrowDAO {
	DBHelper<Borrow> db = new DBHelper<Borrow>(Conf.DB_URL);

	public boolean bor(Borrow b) {
		String sql = "insert into `borrow` (bid,cid) values (?,?)";
		return db.doUpdate(sql, b.getBid(),b.getCid()) == 1;
	}
	
	public Borrow find(String bid,String cid){
		String sql = "SELECT bor.id,bor.bid,bor.cid,bor.btime FROM `borrow` bor INNER JOIN `book` b ON b.id = bor.bid INNER JOIN `card` c ON c.id = bor.cid WHERE b.`code`=? AND c.`code` = ?";
		return db.doQueryOne(sql, new BeanRowMapper<Borrow>(Borrow.class), bid,cid);
	}
	
	public boolean delete(Integer bid,Integer cid){
		String sql = "delete from `borrow` where bid = ? and cid = ?";
		return db.doUpdate(sql, bid,cid)==1;
	}
}
