package com.dao;

import java.util.List;

import com.entity.Book;
import com.tools.BeanRowMapper;
import com.tools.DBHelper;

public class BookDAO {
	DBHelper<Book> db = new DBHelper<Book>(Conf.DB_URL);

	
	public List<Book> find(String str) {
		String sql = "select id,code,title,author,publishing,total,count from `book` where code like '%"+str+"%' or title like '%"+str+"%' or author like '%"+str+"%' or publishing like '%"+str+"%'";
		return db.doQueryAll(sql, new BeanRowMapper<Book>(Book.class));
	}

	public Book selectB(String str){
		String sql = "select id,code,title,author,publishing,total,count from `book` where id=? or code=? or title=?";
		return db.doQueryOne(sql, new BeanRowMapper<Book>(Book.class), str,str,str);
	}
	
	public List<Book> showA() {
		String sql = "select id,code,title,author,publishing,total,count from `book`";
		return db.doQueryAll(sql, new BeanRowMapper<Book>(Book.class));
	}

	public boolean delete(String str) {
		String sql = "delete from `book` where code = ? or id=?";
		return db.doUpdate(sql, str,str) == 1;
	}

	public boolean add(Book b) {
		String sql = "insert into `book` (code,title,author,publishing," + "total,count) values (?,?,?,?,?,?)";
		return db.doUpdate(sql, b.getCode(), b.getTitle(), b.getAuthor(), b.getPublishing(), b.getTotal(),
				b.getCount()) == 1;
	}

	public boolean updateB(Book b) {
		String sql = "update `book` set code = ?,title=?,author=?,publishing=?,total=?,count=? where id=?";
		return db.doUpdate(sql,b.getCode(),b.getTitle(), b.getAuthor(), b.getPublishing(), b.getTotal(), b.getCount(),b.getId()) == 1;
	}

}
