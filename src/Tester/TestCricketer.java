package Tester;

import static Validation.CricketerValidation.validateAll;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.core.app.Cricketer;

import CustomException.CricketerHandlingException;
import CustomOrdering.CompareByRating;

import static utils.CricketerUtils.*;

public class TestCricketer {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			Map<String, Cricketer> CricketersMap = new HashMap<String, Cricketer>();
			List<Cricketer> cList = populatedList();
			CricketersMap = populatedMap(cList);
			boolean flag = false;
			while (!flag) {
				try {
					System.out.println("Menu : 1.Accept minimum 5 Cricketers in the collection.\r\n" + "\r\n"
							+ "2.Modify Cricketer's rating\r\n" + "\r\n" + "3.Search Cricketer by name\r\n" + "\r\n"
							+ "4. Display all Cricketers added in collection.\r\n" + "\r\n"
							+ "5.Display All Cricketers in sorted form by rating\n6.exit");
					System.out.println("Enter Your Choice : ");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter Cricketer's details ");
						// validateAll(String name, int age, String email_id, String phoneno, int
						// rating,Map<String,Cricketer> CricketersMap)
						Cricketer vCricketer = validateAll(sc.next(), sc.nextInt(), sc.next(), sc.next(), sc.nextInt(),
								CricketersMap);
						CricketersMap.put(vCricketer.getEmail_id(), vCricketer);
						System.out.println("Cricketer added to the system Successfully");

						break;
					case 2:
						System.out.println("Enter the cricketers EmailId and Rating to be changed");
						changeRating(sc.next(), sc.nextInt(), CricketersMap);

						break;

					case 3:
						System.out.println("Enter the cricketers name");
						Cricketer c = searchByName(sc.next(), CricketersMap);
						if (c == null) {
							throw new CricketerHandlingException("Cricketer not found in the list");

						} else {
							System.out.println(c);
						}
						break;

					case 4:
						if (CricketersMap.size() != 0) {
							System.out.println("All cricketer details : ");
							for (Cricketer c1 : CricketersMap.values()) {
								System.out.println(c1);
							}
						} else
							System.out.println("empty Map !!");
						break;
					case 5:
						List<Cricketer> cList1 = new ArrayList<Cricketer>(CricketersMap.values());
						System.out.println("Sorted List As below");
						Collections.sort(cList1, new CompareByRating());
						for (Cricketer c2 : cList1) {
							System.out.println(c2);
						}
						break;
					case 6:
						flag = true;

					default:
						System.out.println("Invalid Choice");
						break;
					}

				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}
			}
		}

	}

}
