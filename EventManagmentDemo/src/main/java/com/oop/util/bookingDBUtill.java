package com.oop.util;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.oop.model.Booking;

public class bookingDBUtill extends DBconnect {
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public static boolean validate(String bookingID) {
		try {
			con = getConnection();
			stmt = con.createStatement();
			String sql = "select * from booking where booking_ID='"+bookingID+"' ";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				isSuccess = true;	
			}
			else {
				isSuccess = false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
}