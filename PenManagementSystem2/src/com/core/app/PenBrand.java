package com.core.app;

public enum PenBrand {
	CELLO(10),PARKER(50),REYNOLDS(70);
	int price;
	PenBrand(int price)
	{
		this.price=price;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

}
