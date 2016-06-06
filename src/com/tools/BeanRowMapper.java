package com.tools;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class BeanRowMapper<T> implements BuildEntity<T> {

	private T obj = null;
	private Class<T> type;

	public BeanRowMapper(Class<T> type) {
		this.type = type;
	}

	@Override
	public T build(ResultSet rs) {
		try {
			obj = type.newInstance();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		Method[] mds = type.getMethods();
		try {
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				String cole = "set" + rsmd.getColumnLabel(i).substring(0, 1).toUpperCase()
						+ rsmd.getColumnLabel(i).substring(1);
				for (Method md : mds) {
					if (md.getName().equals(cole)) {
						try {
							md.invoke(obj, rs.getObject(i));
						} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
							System.out.println("��Ӵ���");
							e.printStackTrace();
						}
					}
				}
			}
			return obj;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

}
