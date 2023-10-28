package Validation;

import java.util.Map;

import com.core.app.Cricketer;

import CustomException.CricketerHandlingException;

public class CricketerValidation {
	
	public static void validateEmail(String email_id,Map<String,Cricketer> CricketersMap) throws CricketerHandlingException {
		if( CricketersMap.containsKey(email_id))
		{
			throw new CricketerHandlingException("Cricketer EmailID Already exists..");
		}
		
	}
	
	public static void validatePhoneNo(String phoneno,Map<String,Cricketer> CricketersMap)  throws CricketerHandlingException{
		for(Cricketer c : CricketersMap.values())
		{
			if(c.getPhoneno().equals(phoneno))
			{
				throw new CricketerHandlingException("Duplicate Phone number");
			}
		}
	}
public static Cricketer validateAll(String name, int age, String email_id, String phoneno, int rating,Map<String,Cricketer> CricketersMap)throws CricketerHandlingException {
	validateEmail(email_id,CricketersMap);
	validatePhoneNo( phoneno,CricketersMap);
	return new Cricketer(name,age,email_id,phoneno,rating);
	
}
}
