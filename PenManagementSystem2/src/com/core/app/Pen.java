package com.core.app;

import java.time.LocalDate;

public class Pen {
 private int penId;
 private PenBrand brand;
 private String color;
 private String InkColor;
 private PenMaterial pMate;
 private int stock;
 private LocalDate stockUpdateDate;
 private LocalDate stockListingDate;
 private int price;
 private int discount;
 
public Pen(int penId, PenBrand brand, String color, String inkColor, PenMaterial pMate, int stock,
		LocalDate stockListingDate, int discount) {
	super();
	this.penId = penId;
	this.brand = brand;
	this.color = color;
	InkColor = inkColor;
	this.pMate = pMate;
	this.stock = stock;
	this.stockListingDate = stockListingDate;
	this.price = this.brand.getPrice();
	this.discount = discount;
	this.stockUpdateDate=LocalDate.of(this.stockListingDate.getYear(),this.stockListingDate.getMonth(),this.stockListingDate.getDayOfMonth());
			}

@Override
public String toString() {
	return " [penId=" + penId + ", brand=" + brand + ", color=" + color + ", InkColor=" + InkColor + ", pMate="
			+ pMate + ", stock=" + stock + ", stockUpdateDate=" + stockUpdateDate + ", stockListingDate="
			+ stockListingDate + ", price=" + price + ", discount=" + discount + "]";
}

public int getPenId() {
	return penId;
}

public void setPenId(int penId) {
	this.penId = penId;
}

public PenBrand getBrand() {
	return brand;
}

public void setBrand(PenBrand brand) {
	this.brand = brand;
}

public String getColor() {
	return color;
}

public void setColor(String color) {
	this.color = color;
}

public String getInkColor() {
	return InkColor;
}

public void setInkColor(String inkColor) {
	InkColor = inkColor;
}

public PenMaterial getpMate() {
	return pMate;
}

public void setpMate(PenMaterial pMate) {
	this.pMate = pMate;
}

public int getStock() {
	return stock;
}

public void setStock(int stock) {
	this.stock = stock;
}

public LocalDate getStockUpdateDate() {
	return stockUpdateDate;
}

public void setStockUpdateDate(LocalDate stockUpdateDate) {
	this.stockUpdateDate = stockUpdateDate;
}

public LocalDate getStockListingDate() {
	return stockListingDate;
}

public void setStockListingDate(LocalDate stockListingDate) {
	this.stockListingDate = stockListingDate;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public int getDiscount() {
	return discount;
}

public void setDiscount(int discount) {
	this.discount = discount;
}
 
 
}
