package com.team.graduate.common;

import java.sql.ResultSet;

public interface DataMapper<T> {
	public T mapRecord(ResultSet rs, int num);
}