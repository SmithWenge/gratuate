package com.team.graduate.common.jdbc;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DruidConnUtil {
	public static DataSource getDataSource() {
		DataSource dataSource = null;
		try {
			dataSource = DruidDataSourceFactory.createDataSource(DBProperties.getProperties());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dataSource;
	}
}