package utils;

import static java.time.LocalDate.parse;

import java.util.List;
import java.util.Map;

import com.core.app.AccountType;
import com.core.app.BankAccount;

import CustomExceptions.BankHandlingException;

public class BankUtils {
	public static Map<Integer,BankAccount>  populatedList(Map<Integer,BankAccount> accts)
	{
		//int accNo, String firstName, String lastName, AccountType accType, double balance, LocalDate acCreationDate;
		
		accts.put(103,(new BankAccount(103,"Kalyani","Badakh",AccountType.SAVINGS,1000,parse("2020-05-11"))));
		accts.put(202,(new BankAccount(202,"Jyoti","Panmand",AccountType.FD,800,parse("2019-09-08"))));
		accts.put(402, (new BankAccount(402,"Anjali","Phasale",AccountType.SAVINGS,1500,parse("2022-09-06"))));
		
		accts.put(340,(new BankAccount(340,"Aditi","Chimanpure",AccountType.CURRENT,1000,parse("2020-03-06"))));
		accts.put(231,(new BankAccount(231,"Sakshi","Nikum",AccountType.FD,4000,parse("2021-02-06"))));
		
		return accts;
	}
	
	public static BankAccount checkIfAccExist(int accNo,Map<Integer,BankAccount> accts) throws BankHandlingException
	{
		if(accts.containsKey(accNo))
			return accts.get(accNo);
		else 
			throw new BankHandlingException("Invalid Acc no..");
	}

}
