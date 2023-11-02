package Validation;

import java.time.LocalDate;
import java.util.Map;

import com.core.app.Pen;
import com.core.app.PenBrand;
import com.core.app.PenMaterial;

import CustomeException.PenHandlingException;

public class PenValidation {
	public static int checkforPenDups(int penId,Map<Integer,Pen> pensMap) throws PenHandlingException
	
	{
		if(pensMap.containsKey(penId))
			throw new PenHandlingException("penID already exists");
		else
			return penId;
			
		
	}
	
	public static PenBrand validateBrand(String brand)throws IllegalArgumentException
	{
		return PenBrand.valueOf(brand.toUpperCase());
	}
	
	public static PenMaterial validateMaterial(String pMate) throws IllegalArgumentException
	{
		return PenMaterial.valueOf(pMate.toUpperCase());
	}
	
	public static LocalDate parseAndValidateDate(String stockListingDate)
	{
		return LocalDate.parse(stockListingDate);
	}
	
	public static Pen validateALL(int penId, String brand, String color, String inkColor, String pMate, int stock,
		String stockListingDate,  int discount,Map<Integer,Pen> pensMap)throws IllegalArgumentException, PenHandlingException
	{
		PenBrand vBrand = validateBrand(brand);
		PenMaterial vMate = validateMaterial(pMate);
		LocalDate vstockListingDate = parseAndValidateDate(stockListingDate);
		
		
		
		
		
		return new Pen(penId,vBrand,color,inkColor,vMate,stock,vstockListingDate,discount);
	}
	

}
