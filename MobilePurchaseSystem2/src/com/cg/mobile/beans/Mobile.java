package com.cg.mobile.beans;

public class Mobile {
	private int moibleId;
	private String name;
	private int price, quantity;
	public Mobile() {
		super();
	}
	public Mobile(int moibleId, String name, int price, int quantity) {
		super();
		this.moibleId = moibleId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	public int getMoibleId() {
		return moibleId;
	}
	public void setMoibleId(int moibleId) {
		this.moibleId = moibleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Mobile [moibleId=" + moibleId + ", name=" + name + ", price="
				+ price + ", quantity=" + quantity + "]";
	}
}
