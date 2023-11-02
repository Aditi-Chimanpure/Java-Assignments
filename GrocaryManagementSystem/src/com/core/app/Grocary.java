package com.core.app;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Grocary {
	private String name;
	private double price;
	private int quantity;
	private LocalDate stockUpdateDate;
	private LocalDate stockListedDate;
	
	public Grocary(String name, double price, int quantity, LocalDate stockListedDate ) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.stockUpdateDate = LocalDate.of(stockListedDate.getYear(), stockListedDate.getMonth(), stockListedDate.getDayOfMonth());
		this.stockListedDate=stockListedDate;
	}

	

	public LocalDate getStockListedDate() {
		return stockListedDate;
	}



	public void setStockListedDate(LocalDate stockListedDate) {
		this.stockListedDate = stockListedDate;
	}



	@Override
	public String toString() {
		return "Grocary [name=" + name + ", price=" + price + ", quantity=" + quantity + ", stockUpdateDate="
				+ stockUpdateDate + ", stockListedDate=" + stockListedDate + "]";
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDate getstockUpdateDate() {
		return stockUpdateDate;
	}

	public void setstockUpdateDate(LocalDate stockUpdateDate) {
		this.stockUpdateDate = stockUpdateDate;
	}

	

}
