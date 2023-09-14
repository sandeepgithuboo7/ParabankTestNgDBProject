package com.db.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.framework.commons.DBCommons;

public class DataBaseTest {
	
	@Test
	public void getAllTheHorrorMoviesFromDvdRentalDataBase() throws SQLException {
		
		String Query = "SELECT FILM.TITLE, CATEGORY.NAME AS CATEGORY, LANGUAGE.NAME AS LANGUAGE FROM CATEGORY\r\n"
				+ "JOIN FILM_CATEGORY \r\n"
				+ "ON \r\n"
				+ "CATEGORY.CATEGORY_ID = FILM_CATEGORY.CATEGORY_ID\r\n"
				+ "JOIN \r\n"
				+ "FILM\r\n"
				+ "ON\r\n"
				+ "FILM_CATEGORY.FILM_ID = FILM.FILM_ID\r\n"
				+ "JOIN\r\n"
				+ "LANGUAGE\r\n"
				+ "ON\r\n"
				+ "FILM.LANGUAGE_ID = LANGUAGE.LANGUAGE_ID\r\n"
				+ "WHERE \r\n"
				+ "CATEGORY.NAME ='Horror'\r\n"
				+ "AND \r\n"
				+ "LANGUAGE.NAME ='English'\r\n"
				+ "ORDER BY\r\n"
				+ "FILM.TITLE ASC";
		
		ResultSet results = DBCommons.dbResults(Query);
		
		List<Map<String,String>> data = new ArrayList<Map<String,String>>();
		while(results.next()) {
			Map<String,String> records = new HashMap<String,String>();
			for(int i=1; i<=results.getMetaData().getColumnCount();i++ ) {
				String columnName= results.getMetaData().getColumnName(i);
				String colValue=results.getString(i);
				records.put(columnName, colValue);
			}
			data.add(records);
		}
		
		System.out.println(data);
		System.out.println(data.get(2).get("title"));
		System.out.println(data.size());
		
	}

}
