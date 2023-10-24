package com.core.app;



import java.time.LocalDate;

import CustomExceptions.BankHandlingException;

public class BankAccount{
	private Integer accNo;
	private String firstName;
	private String lastName;
	private AccountType accType;
	private Double balance;
	private LocalDate acCreationDate;

	public BankAccount(Integer accNo, String firstName, String lastName, AccountType accType, double balance,
			LocalDate acCreationDate) {

		this.accNo = accNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.accType = accType;
		this.balance = balance;
		this.acCreationDate = acCreationDate;
	}

	

	public int getaccNo() {
		return accNo;
	}

	public void setaccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public AccountType getAccType() {
		return accType;
	}

	@Override
	public String toString() {
		return "BankAccount [accNo=" + accNo + ", firstName=" + firstName + ", lastName=" + lastName + ", balance="
				+ balance + ", acCreationDate=" + acCreationDate + "]";
	}

	public void setAccType(AccountType accType) {
		this.accType = accType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public LocalDate getAcCreationDate() {
		return acCreationDate;
	}

	public void setAcCreationDate(LocalDate acCreationDate) {
		this.acCreationDate = acCreationDate;
	}


	public void depositeMoney(int amount)
	{
		this.balance=balance+amount;
	}
	
	
	public void withdrawMoney(int amount) throws BankHandlingException
	{
		//validateBalance(this.balance-amount,this.accType);
		
		this.balance=balance-amount;
		
		
	}
	
	public void fundTransfer(BankAccount bdest, int amt)throws BankHandlingException
	{
		this.withdrawMoney(amt);
		bdest.depositeMoney(amt);
	
	}


}
