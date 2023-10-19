package com.app.core;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Customer implements Comparable<Customer> {
	private int custid;
	private String firstname;
	private String lastname;

	private LocalDate dob;
	private String email;
	private String password;
	private double regamt;
	private ServicePlan plan; // enum declaration
	private LocalDate regDate;
	private static int count = 1;
	
	private long subscrMonths=0;

	public long getSubscrMonths() {
		return subscrMonths;
	}

	public void setSubscrMonths(long subscrMonths) {
		this.subscrMonths = subscrMonths;
	}

	public Customer(String firstname, String lastname, LocalDate dob, String email, String password, double regamt,
			ServicePlan plan, LocalDate regDate) {
		this.custid = count++;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.email = email;
		this.password = password;
		this.regamt = regamt;
		this.plan = plan;
		this.regDate = regDate;
		//this.pm=null;
		
	}


	public Customer(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "customer{" + "custid=" + custid + ", firstname=" + firstname + ", lastname=" + lastname + "dob=" + dob
				+ ", email=" + email + ", password=" + password + ", regamt=" + regamt + ", plan=" + plan + '}';
	}

	@Override
	public boolean equals(Object o) {
		// ystem.out.println("in customer's equal ");
		if (o instanceof Customer) {
			Customer anotherCustomer = (Customer) o;
			return this.email.equals(anotherCustomer.email);
		}
		return false;
	}

	@Override
	public int compareTo(Customer c) {
		return this.email.compareTo(c.email);

	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
