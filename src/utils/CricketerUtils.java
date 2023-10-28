package utils;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.core.app.Cricketer;

import CustomException.CricketerHandlingException;

public class CricketerUtils {
	public static List<Cricketer> populatedList(){
		List<Cricketer> cList =  new ArrayList<Cricketer>();
		//String name, int age, String email_id, String phoneno, int rating
		cList.add(new Cricketer("Virat",30,"v@gmail.com","8486989752",5));
		cList.add(new Cricketer("Mahendra",37,"m@gmail.com","8811225054",4));
		cList.add(new Cricketer("KLRahul",28,"k@gmail.com","9867589752",3));
		cList.add(new Cricketer("Chahal",25,"c@gmail.com","9876989752",4));
		cList.add(new Cricketer("Surya",29,"s@gmail.com","9897654231",3));
		return cList;
		
	}
	public static Map<String,Cricketer>  populatedMap(List<Cricketer> cList){
		
		Map<String,Cricketer> cMap = new HashMap<String,Cricketer>();
		for(Cricketer c : cList)
		{
			cMap.put(c.getEmail_id(), c);
		}
		return cMap;
		
	}
	public static Cricketer searchByName(String name,Map<String,Cricketer> cMap) {
		for(Cricketer c : cMap.values())
		{
			if (c.getName().equalsIgnoreCase(name)) {
				return c;
			}
		}
		return null;
	}
	
	public static Cricketer searchByEmail(String email,Map<String,Cricketer> cMap) {
		for(Cricketer c : cMap.values())
		{
			System.out.println("email is: " + c.getEmail_id());
			if (c.getEmail_id().equals(email)) {
				return c;
			}
		}
		return null;
	}
	
	public static void changeRating(String email,int rating,Map<String,Cricketer> cMap) throws CricketerHandlingException
	{
		Cricketer c = searchByEmail(email,cMap);
		System.out.println(c);
		if(c==null)
		{
			throw new CricketerHandlingException("Invalid EmailID");
			
		}
		else
		{
			c.setRating(rating);
			System.out.println(c);
		}
	}

}
