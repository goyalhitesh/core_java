package com.cg.mobile.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import com.cg.mobile.beans.Customer;
import com.cg.mobile.beans.Mobile;
import com.cg.mobile.exceptions.InvalidMobileId;
import com.cg.mobile.exceptions.InvalidMobileNumber;
import com.cg.mobile.exceptions.MobileDetailNotFound;

public interface MobileServices {

	boolean updateMobileDetails(int mobId, int quantity) throws InvalidMobileId, SQLException;

	ArrayList<Mobile> getAllDetails() throws SQLException;

	int deleteMobileDetails(int mobileId) throws SQLException, MobileDetailNotFound;

	ArrayList<Mobile> getFewMobileDetails(int price1, int price2) throws SQLException, MobileDetailNotFound;

	int addCustomerDetails(String cname, String mailId, String phoneNo,
			int mobileId) throws InvalidMobileNumber, MobileDetailNotFound, SQLException;
	
	
	}
