package com.cg.mobile.daoservices;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.mobile.beans.Customer;
import com.cg.mobile.beans.Mobile;

public interface DaoServices {

	Customer savePurchaseDetails(Customer customer) throws SQLException;

	boolean updateMobileDetails(int mobileId, int quantity) throws SQLException;

	ArrayList<Mobile> getAllMobileDetails() throws SQLException;

	boolean deleteMobileDetails(int mobileId) throws SQLException;

	ArrayList fetchFewMobileDetails(int price1, int price2) throws SQLException;

	

}
