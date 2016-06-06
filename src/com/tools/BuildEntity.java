package com.tools;

import java.sql.ResultSet;

public interface BuildEntity<T> {
	T build(ResultSet rs);
}
