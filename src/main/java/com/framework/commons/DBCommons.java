package com.framework.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.framework.utilities.ReadProp;

public class DBCommons {
	
	public static ResultSet dbResults(String Query) {
		ResultSet results = null;		
		try {
			Properties prop = ReadProp.readData("Config.properties");
			Connection con = DriverManager.getConnection(prop.getProperty("DbUrl"),prop.getProperty("DbUsername"),prop.getProperty("DbPassword"));
			results = con.createStatement().executeQuery(Query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;		
	}

}
