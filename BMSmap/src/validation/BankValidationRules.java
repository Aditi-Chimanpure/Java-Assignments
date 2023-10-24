package validation;

import java.time.LocalDate;
import java.util.Map;

import com.core.app.AccountType;
import com.core.app.BankAccount;

import CustomExceptions.BankHandlingException;

public class BankValidationRules {
	public static int checkForDups(int accNo, Map<Integer, BankAccount> accts) throws BankHandlingException {
		if (accts.containsKey(accNo))
			throw new BankHandlingException("Bank account already exists");
		else
			return accNo;

	}

	public static AccountType validateAccountType(String accType) throws IllegalArgumentException {
		return AccountType.valueOf(accType.toUpperCase());

	}

	public static LocalDate validateAndParseDate(String acCreationDate) {
		return LocalDate.parse(acCreationDate);
	}
	
	public static void validateBalance(double balance , AccountType accType)throws BankHandlingException
	{
		if(balance < accType.getMinBalance())
		{
			throw new BankHandlingException("Minimum balance not sufficient ");
		}
	}
	
	public static BankAccount validateAll(int accNo, String firstName, String lastName, String accType,
			double balance, String acCreationDate,Map<Integer,BankAccount> accts) throws BankHandlingException {
		AccountType vAccType = validateAccountType(accType);
		LocalDate vDate= validateAndParseDate(acCreationDate);
		

		return new BankAccount(accNo,firstName,lastName,vAccType,balance,vDate);
	}

}
