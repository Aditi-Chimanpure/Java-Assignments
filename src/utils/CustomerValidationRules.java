package utils;

import java.time.LocalDate;
import java.util.List;

import com.app.core.Customer;
import com.app.core.ServicePlan;

import Custom_Exception.CustomerHandlingException;

public class CustomerValidationRules {
	public static void checkForDups(String emailID,List<Customer> customers) throws CustomerHandlingException{
		Customer newCustomer = new Customer(emailID);
		if(customers.contains(newCustomer))
			throw new CustomerHandlingException("Customer Already exists");
		System.out.println("No Duplicates");
		
	}
	
	public static ServicePlan parseAndValidateServicePlan(String plan) throws IllegalArgumentException{
		return ServicePlan.valueOf(plan.toUpperCase());
		
	}
	public static LocalDate parseDate(String dob)
	{
		return LocalDate.parse(dob);
		 
	}
	
	public static void regiAmtValidate(double regAmt,ServicePlan plan)throws CustomerHandlingException{
		if(plan.getCharges()==regAmt)
		{
		 System.out.println("RegisterAmount is okay");
		}
		else
			throw new CustomerHandlingException("Registerd amount is not valid");
		
	}

	
	public static Customer validateAllInputs( String firstname, String lastname, String dob, String email, String password, double regamt, String plan,String regDate,List<Customer> customers)throws CustomerHandlingException,IllegalArgumentException{
		checkForDups(email, customers);
		ServicePlan sPlan = parseAndValidateServicePlan(plan);
		LocalDate sDob=parseDate(dob);
		LocalDate rDate= parseDate(regDate);
		
		regiAmtValidate(regamt, sPlan);
		return new Customer(  firstname, lastname, sDob, email,  password, regamt, sPlan,rDate);
}
}

