package tester;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import static Validation.GrocaryValidation.*;
import static utils.GrocaryUtils.*;

import com.core.app.Grocary;

import CustomException.GrocaryHandlingException;

public class GrocaryTester {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in))
		{
			boolean flag = false;
			Map<String,Grocary> Grocaries = new HashMap<String,Grocary> ();
			Grocaries=populatedMap(Grocaries);
			while(!flag) {
				try {
					System.out.println("Menu : 1.Add new item\n2.update quantity\n3.Display all grocary\n4.remove empty stock\n5.stock updated product in last 3days\n0.exit");
					System.out.println("\nEnter your choice");
					switch (sc.nextInt()) {
					
					case 1:
						System.out.println("Enter the grocary details:\nname, price, quantity, stockUpdateDate");
						Grocary validatedGrocary=validateAllInput(sc.next(),sc.nextDouble(),sc.nextInt(),sc.next(),Grocaries);
						Grocaries.put(validatedGrocary.getName(), validatedGrocary);
						System.out.println("Grocary added successfully");
						
						break;
					case 2:
						System.out.println("Enter grocary name and quantity to be changed and Date for stockupdate(today's date)");
						Grocary g1 = updateQty(sc.next(),sc.nextInt(),Grocaries);
						System.out.println("Enter stock update date");
						setStockupdateDate(g1,sc.next());
						System.out.println("Qty updated for below groacry item"+g1);
						System.out.println();
											
						
						break;
					case 3:
						System.out.println("All grocary item details");
						for(Grocary g : Grocaries.values()) {
							System.out.println(g);
						}
						System.out.println("\n");
	
						break;
					case 4:
						removeEmptyStock(Grocaries);
						
						break;
					case 5:
						isStockupdatein3days(Grocaries);
						
						break;
						
					case 0:
						flag=true;
						break;
	

					default:
						System.out.println("Invalid Choice...please enter again");
						break;
					}
				}catch(Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}
			}
			
			
		}
	

	}

}
