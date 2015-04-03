package com.team.graduate.common.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBProperties {
	
	public static Properties getProperties() {
		Properties properties = new Properties();
		InputStream propertiesStream = null;
		try {
			propertiesStream = DBProperties.class.getResourceAsStream("/application/db.properties");
			properties.load(propertiesStream);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(propertiesStream != null) {
				try {
					propertiesStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return properties;
	}
}
