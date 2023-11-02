package utils;

import static com.core.app.PenBrand.CELLO;
import static com.core.app.PenBrand.PARKER;
import static com.core.app.PenBrand.REYNOLDS;
import static com.core.app.PenMaterial.ALLOYSTEEL;
import static com.core.app.PenMaterial.METAL;
import static com.core.app.PenMaterial.PLASTIC;
import static  java.time.LocalDate.parse;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;

import com.core.app.Pen;

import CustomeException.PenHandlingException;

public class Penutils {
	public static Pen findPenById(int penId, Map<Integer,Pen> pensMap)throws PenHandlingException
	{
		if(pensMap.containsKey(penId))
			return pensMap.get(penId);
		else
			throw new PenHandlingException("PenId not valid");
	}


public static void changeStock(int penId,Map<Integer,Pen> pensMap, int stockupdate,String stockUpdateDate)throws PenHandlingException
{
	Pen p = findPenById(penId,pensMap);
	p.setStock(stockupdate);
	System.out.println("Enter the date ");
    p.setStockUpdateDate(LocalDate.parse(stockUpdateDate));
    System.out.println("Pen stocks after updation : "+p.getStock());
	
}
public static void changePrice (LocalDate stockUpdateDate, int discount,Pen p1)
{
	Period p = Period.between(stockUpdateDate, LocalDate.now());
	int months = p.getMonths();
			
	if(months>3)
	{
		p1.setPrice(p1.getPrice()*(80/100));
	}
}

public static Map<Integer,Pen>  populatedList(Map<Integer,Pen> pensMap)
{//int penId, PenBrand brand, String color, String inkColor, PenMaterial pMate, int stock,
	//LocalDate stockListingDate, int discount
	//CELLO(10),PARKER(50),REYNOLDS(70)
	//PLASTIC(10),ALLOYSTEEL(20),METAL(30);
	pensMap.put(1, new Pen(1,CELLO,"blue","blue",METAL,30,parse("2023-01-01"),0));
	pensMap.put(3, new Pen(3,REYNOLDS,"black","grey",PLASTIC,30,parse("2023-01-01"),0));
	pensMap.put(5, new Pen(5,PARKER,"yellow","black",ALLOYSTEEL,30,parse("2023-01-01"),0));
	pensMap.put(2, new Pen(2,CELLO,"black","black",METAL,30,parse("2023-01-01"),0));
	pensMap.put(4, new Pen(4,PARKER,"pink","black",PLASTIC,30,parse("2023-01-01"),0));
	return pensMap;
	
}
}
