package com.cg.mobile.beans;

import java.sql.Date;

public class Customer {
	private int purchaseId;
	private String cname, mailId,phoneNo;
	private Date purchaseDate;
	private int mobileId;
	public Customer() {
		super();
	}
	public Customer(int purchaseId) {
		super();
		this.purchaseId = purchaseId;
	}
	public Customer(String cname, String mailId, String phoneNo, int mobileId) {
		super();
		this.cname = cname;
		this.mailId = mailId;
		this.phoneNo = phoneNo;
		this.mobileId = mobileId;
	}
	public Customer(int purchaseId, String cname, String mailId,
			String phoneNo, Date purchaseDate, int mobileId) {
		super();
		this.purchaseId = purchaseId;
		this.cname = cname;
		this.mailId = mailId;
		this.phoneNo = phoneNo;
		this.purchaseDate = purchaseDate;
		this.mobileId = mobileId;
	}
	public int getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public int getMobileId() {
		return mobileId;
	}
	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cname == null) ? 0 : cname.hashCode());
		result = prime * result + ((mailId == null) ? 0 : mailId.hashCode());
		result = prime * result + mobileId;
		result = prime * result + ((phoneNo == null) ? 0 : phoneNo.hashCode());
		result = prime * result
				+ ((purchaseDate == null) ? 0 : purchaseDate.hashCode());
		result = prime * result + purchaseId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (cname == null) {
			if (other.cname != null)
				return false;
		} else if (!cname.equals(other.cname))
			return false;
		if (mailId == null) {
			if (other.mailId != null)
				return false;
		} else if (!mailId.equals(other.mailId))
			return false;
		if (mobileId != other.mobileId)
			return false;
		if (phoneNo == null) {
			if (other.phoneNo != null)
				return false;
		} else if (!phoneNo.equals(other.phoneNo))
			return false;
		if (purchaseDate == null) {
			if (other.purchaseDate != null)
				return false;
		} else if (!purchaseDate.equals(other.purchaseDate))
			return false;
		if (purchaseId != other.purchaseId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [purchaseId=" + purchaseId + ", cname=" + cname
				+ ", mailId=" + mailId + ", phoneNo=" + phoneNo
				+ ", purchaseDate=" + purchaseDate + ", mobileId=" + mobileId
				+ "]";
	}
}
