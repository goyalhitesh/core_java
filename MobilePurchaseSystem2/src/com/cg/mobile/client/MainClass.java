package com.cg.mobile.client;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.Scanner;

import com.cg.mobile.beans.Customer;
import com.cg.mobile.beans.Mobile;
import com.cg.mobile.exceptions.InvalidMobileId;
import com.cg.mobile.exceptions.InvalidMobileNumber;
import com.cg.mobile.exceptions.MobileDetailNotFound;
import com.cg.mobile.services.MobileServices;
import com.cg.mobile.services.MobileServicesImpl;


public class MainClass {
	
	public static void main(String[] args) {
		MobileServices mobileServices = new MobileServicesImpl();
		String ch="y";
		Scanner sc = new Scanner(System.in);
		 int choice = 0;
		while(ch.equalsIgnoreCase("y")){
			System.out.println("1. Insert the customer and purchase details into database\n2. Update the mobile quantity in mobile table,once mobile is purchased by a customer.\n3. View details of all mobiles available in the shop.\n4. Delete a mobile details based on mobile id.\n5. Search mobiles based on price range.\n");
			System.out.println("Enter your choice:");
			choice = sc.nextInt();
			sc.nextLine();
			switch(choice){
			case(1):
				System.out.println("Enter the customer name: ");
				String cname=sc.nextLine();
				System.out.println("Enter the mailId: ");
				String mailId = sc.nextLine();
				System.out.println("Enter the mobile number: ");
				String phoneNo = sc.nextLine();
				System.out.println("Enter the mobileId: ");
				int mobileId = sc.nextInt();
				sc.nextLine();
				try {
					int mobileService = mobileServices.addCustomerDetails(cname, mailId, phoneNo, mobileId);
					System.out.println(mobileService);
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (MobileDetailNotFound e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvalidMobileNumber e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case(2):
				System.out.println("Enter the mobileId: ");
				int mobId = sc.nextInt(); 
				sc.nextLine();
				System.out.println("Enter the quantity sold: ");
				int quantity = sc.nextInt();
				sc.nextLine();
				try {
					boolean mobileService = mobileServices.updateMobileDetails(mobId,quantity);
				} catch (InvalidMobileId e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case(3):
				try {
					ArrayList<Mobile> mobileServices2 = mobileServices.getAllDetails();
					for (Mobile mobile : mobileServices2)
						System.out.println(mobile);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;
			
			case(4):
				System.out.println("Enter the mobile Id: ");
				int mobiId = sc.nextInt();
				sc.nextLine();
				try {
					int customer1 = mobileServices.deleteMobileDetails(mobiId);
					System.out.println("deleted");
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (MobileDetailNotFound e) {
					e.printStackTrace();
				}
				break;
				
			case(5):
				System.out.println("Enter the lower limit of price range: ");
				int price1 = sc.nextInt();
				System.out.println("Enter the upper limit of price range: ");
				int price2 = sc.nextInt();
				sc.nextLine();
				try {
					ArrayList<Mobile> mobile = mobileServices.getFewMobileDetails(price1,price2);
					for (Mobile mobile2 : mobile) {
						System.out.println(mobile2);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MobileDetailNotFound e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			System.out.println("Do you want to continue (y/n): ");
			ch = sc.nextLine();
		}
	}
}
