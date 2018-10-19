package com.cg.mobile.daoservices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.cg.project.util.ConnectionProvider;
import com.cg.mobile.beans.Customer;
import com.cg.mobile.beans.Mobile;

public class DaoServicesImpl implements DaoServices {
	private Connection conn = ConnectionProvider.getDBConnection();
	
	@Override
	public Customer savePurchaseDetails(Customer customer) throws SQLException {
		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO CUSTOMER(purchaseId, cname, mailId, phoneNo, purchaseDate, mobileId) VALUES(purchaseId_sequence.nextval, ?,?,?,sysdate,?)");
			pstmt.setString(1, customer.getCname());
			pstmt.setString(2, customer.getMailId());
			pstmt.setString(3, customer.getPhoneNo());
			pstmt.setInt(4, customer.getMobileId());
			pstmt.executeUpdate();
			
			PreparedStatement pstmt2 = conn.prepareStatement("select max(purchaseId) from customer");
			ResultSet rs = pstmt2.executeQuery();
			rs.next();
			int purchaseId = rs.getInt(1);
			Customer customer2 = new Customer(purchaseId);
			conn.commit();
			return customer2;
		}catch(SQLException e){
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally { conn.setAutoCommit(true); }
	}
	
	public Mobile findOne(int mobileId) throws SQLException{
		PreparedStatement p = conn.prepareStatement("SELECT * FROM MOBILES WHERE MOBILEID="+mobileId);
		ResultSet rs = p.executeQuery();
		if (rs.next())	return new Mobile(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
		return null;
	}

	@Override
	public boolean updateMobileDetails(int mobileId, int quantity) throws SQLException {
		try {
			Mobile mobile = findOne(mobileId);
			PreparedStatement pstmt = conn.prepareStatement("UPDATE MOBILES SET QUANTITY = ? WHERE MOBILEID = ?");
			pstmt.setInt(1, (mobile.getQuantity()-quantity));
			pstmt.setInt(2, mobileId);
			int rs = pstmt.executeUpdate();
			if(rs>0) return true;
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ArrayList<Mobile> getAllMobileDetails() throws SQLException {
		ArrayList<Mobile> mobiles= new ArrayList<Mobile>();
		PreparedStatement pstmt1 = conn.prepareStatement("select * from mobiles");
		ResultSet findMobileDetailsRS = pstmt1.executeQuery();
		while(findMobileDetailsRS.next()){
			int moibleId=findMobileDetailsRS.getInt("MobileId");
			String name = findMobileDetailsRS.getString("Name");
			int price = findMobileDetailsRS.getInt("Price");
			int quantity = findMobileDetailsRS.getInt("Quantity");
			Mobile mobile= new Mobile(moibleId, name, price, quantity);
			mobiles.add(mobile);
		}
		return mobiles;
	}

	@Override
	public boolean deleteMobileDetails(int mobileId) throws SQLException {
		String sql = "DELETE FROM MOBILES WHERE MOBILEID="+ mobileId;
		System.out.println(sql);
		PreparedStatement pstmt = conn.prepareStatement(sql);
		System.out.println("hi");
		int flag = pstmt.executeUpdate();
		System.out.println(flag);
		return true;
	}

	@Override
	public ArrayList fetchFewMobileDetails(int price1, int price2)
			throws SQLException {
		ArrayList<Mobile> mobiles= new ArrayList<Mobile>();
		PreparedStatement pstmt1 = conn.prepareStatement("select * from mobiles where price>=? and price<=?");
		pstmt1.setInt(1, price1);
		pstmt1.setInt(2, price2);
		ResultSet findMobileDetailsRS = pstmt1.executeQuery();
		while(findMobileDetailsRS.next()){
			int moibleId=findMobileDetailsRS.getInt("MobileId");
			String name = findMobileDetailsRS.getString("Name");
			int price = findMobileDetailsRS.getInt("Price");
			int quantity = findMobileDetailsRS.getInt("Quantity");
			Mobile mobile= new Mobile(moibleId, name, price, quantity);
			mobiles.add(mobile);
		}
		return mobiles;
	}

}
