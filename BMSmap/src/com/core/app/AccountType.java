package com.core.app;

public enum AccountType {
	SAVINGS(100), CURRENT(200), FD(500);

	int minBalance;

	private AccountType(int minBalance) {
		this.minBalance = minBalance;
	}

	public int getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(int minBalance) {
		this.minBalance = minBalance;
	}

}
