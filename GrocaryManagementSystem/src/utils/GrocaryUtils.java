package utils;
import static Validation.GrocaryValidation.*;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Map;
import static  java.time.LocalDateTime.parse;

import java.time.LocalDate;

import com.core.app.Grocary;

import CustomException.GrocaryHandlingException;

public class GrocaryUtils {
	public static Grocary updateQty(String name,int qty,Map<String,Grocary> Grocaries ) throws GrocaryHandlingException
	{
		Grocary g1 = Grocaries.get(name.toUpperCase());
		if(g1==null)
		{
			throw new GrocaryHandlingException("Invalid Grocary name");
		}
		else {
			g1.setQuantity(qty);
			
			return g1;
		}
	}
	public static void setStockupdateDate(Grocary g1,String schangeDate) {
		 LocalDate vStockchangeDate=parseAndValidate(schangeDate);
		g1.setstockUpdateDate(vStockchangeDate);
		
	}
	public static void removeEmptyStock(Map<String,Grocary> Grocaries) {
//		for(Grocary g :Grocaries.values() ) {
//			if(g.getQuantity()==0) {
//				Grocary g1 = Grocaries.remove(g.getName());
//				
		Iterator <Grocary>itr = Grocaries.values().iterator();
		while(itr.hasNext()) {
			Grocary g1 = itr.next();
			if(g1.getQuantity()==0)
			{
				itr.remove();
				System.out.println("Grocary deleted from list "+g1);
			}
		
	 
			
		}
	}
	public static Map<String,Grocary> populatedMap(Map<String,Grocary> gmap){
		//String name, double price, int quantity, LocalDateTime stockListedDate
		gmap.put("BREAD",new Grocary("BREAD",20,10,parseAndValidate("2023-10-01")));
		gmap.put("EGGS",new Grocary("EGGS",5,50,parseAndValidate("2023-10-10")));
		gmap.put("OIL",new Grocary("OIL",10,120,parseAndValidate("2023-10-05")));
		gmap.put("SOAP",new Grocary("SOAP",30,50,parseAndValidate("2023-10-10")));
		gmap.put("SALT",new Grocary("SALT",18,15,parseAndValidate("2023-10-12")));
		return gmap;
		
	}
	public static void isStockupdatein3days(Map<String,Grocary> Grocaries) {
		boolean flag=false;
		for(Grocary g : Grocaries.values()) {
			if(!g.getStockListedDate().isEqual(g.getstockUpdateDate())) {
				LocalDate threedayago = LocalDate.now().minusDays(3);
				if(g.getstockUpdateDate().isBefore(threedayago))
				{
					System.out.println(g);
					flag=true;
					
				}
				
			}
			
		}
		if(!flag){
		{
			System.out.println("No stockchange in last three days");
		}
		}
		
		 
	 }
				
	

}
