package Validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import com.core.app.Grocary;

import CustomException.GrocaryHandlingException;

public class GrocaryValidation {
	public static void checkforDups(String name,Map<String,Grocary> Grocaries)throws GrocaryHandlingException {
		if(Grocaries.containsKey(name)) {
			throw new GrocaryHandlingException("Grocary Already added");
			}
			
		}
		
	public static LocalDate parseAndValidate(String stockUpdateDate) {
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		return  LocalDate.parse(stockUpdateDate);
	}
		
	
	public static Grocary validateAllInput(String name, double price, int quantity, String stockUpdateDate,Map<String,Grocary> Grocaries)throws GrocaryHandlingException {
		checkforDups( name,Grocaries);
		LocalDate vstockUpdateDate= parseAndValidate(stockUpdateDate);
		return new Grocary(name, price, quantity,vstockUpdateDate);
	}
	}


