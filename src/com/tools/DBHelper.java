package com.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBHelper<T> {

	private String url;
	private Connection conn;
	private PreparedStatement stat;
	private ResultSet rs;

	public DBHelper(String url) {
		this.url = url;
	}

	public List<T> doQueryAll(String sql, BuildEntity<T> be) {
		getStatement(sql);
		List<T> list = new ArrayList<> ();
		try {
			rs = stat.executeQuery();
			while (rs != null && rs.next()) {
				list.add(be.build(rs));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public T doQueryOne(String sql, BuildEntity<T> be, Object... para) {
		getStatement(sql);
		for (int i = 1; i <= para.length; i++) {
			try {
				stat.setObject(i, para[i - 1]);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		try {
			rs = stat.executeQuery();
			if (rs != null && rs.next()) {
				return be.build(rs);
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			close();
		}

	}

	public Integer doUpdate(String sql, Object... para) {
		getStatement(sql);
		for (int i = 0; i < para.length; i++) {
			try {
				stat.setObject(i + 1, para[i]);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		try {
			return stat.executeUpdate();
		} catch (SQLException e) {
			System.out.println("do update error");
			return null;
		}
	}

	private void getStatement(String sql) {
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection(url);
			stat = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stat != null)
					stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
