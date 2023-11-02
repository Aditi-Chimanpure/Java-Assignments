package com.core.app;

public enum PenMaterial {
PLASTIC(10),ALLOYSTEEL(20),METAL(30);
	int stock;
	PenMaterial(int stock )
	{
		this.stock=stock;
		
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
}
