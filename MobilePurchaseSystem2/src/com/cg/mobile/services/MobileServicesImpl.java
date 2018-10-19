package com.cg.mobile.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import com.cg.mobile.beans.Customer;
import com.cg.mobile.beans.Mobile;
import com.cg.mobile.daoservices.DaoServices;
import com.cg.mobile.daoservices.DaoServicesImpl;
import com.cg.mobile.exceptions.InvalidMobileId;
import com.cg.mobile.exceptions.InvalidMobileNumber;
import com.cg.mobile.exceptions.MobileDetailNotFound;

public class MobileServicesImpl implements MobileServices{
	private DaoServices DaoServices = new DaoServicesImpl();

	@Override
	public int addCustomerDetails(String cname, String mailId, String phoneNo,
			int mobileId) throws SQLException,
			MobileDetailNotFound, InvalidMobileNumber {
		Customer customer = new Customer(cname, mailId, phoneNo, mobileId);
		customer = DaoServices.savePurchaseDetails(customer);
		return customer.getPurchaseId();
	}

	@Override
	public boolean updateMobileDetails(int mobId, int quantity) throws InvalidMobileId,
			SQLException {
		Customer customer = new Customer(mobId);
		if(mobId!=0){
			DaoServices.updateMobileDetails(mobId, quantity);
			return true;
		}
		else
			throw new InvalidMobileId("Incorrect Mobile Id!! Please check again.");
	}

	@Override
	public ArrayList<Mobile> getAllDetails() throws SQLException {
		ArrayList<Mobile> list = DaoServices.getAllMobileDetails();
		return list;
	}

	@Override
	public int deleteMobileDetails(int mobileId) throws SQLException,
			MobileDetailNotFound {
		boolean daoServices = DaoServices.deleteMobileDetails(mobileId);
		return 1;
	}
	
	@Override
	public ArrayList<Mobile> getFewMobileDetails(int price1, int price2)
			throws SQLException, MobileDetailNotFound {
		ArrayList list = DaoServices.fetchFewMobileDetails(price1,price2);
		return list;
	}
	
	
}
