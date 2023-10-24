package Tester;

import static utils.BankUtils.checkIfAccExist;
import static utils.BankUtils.populatedList;
import static validation.BankValidationRules.checkForDups;
import static validation.BankValidationRules.validateAll;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
//import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.core.app.BankAccount;

public class TestBMS_map {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			Map<Integer, BankAccount> accts = new HashMap<Integer, BankAccount>();
			accts = populatedList(accts);
			
			boolean flag = false;
			while (!flag) {
				System.out.println(
						"Menu : \n1.Create BankAcc\n2.Display Acc Details\n3.Check if acc exist\n4.Deposite Money\n5.withdrawa money\n6.Fund Transfer\n7.display acc details\n8.sort by accNo\n9.sort by balane\n10.sort by firstname");
				System.out.println("Enter your choice ");
				try {

					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter your acc No : ");
						int validatedAccNo = checkForDups(sc.nextInt(), accts);
						System.out.println(
								"Enter the acc details as below : firstName,lastName,accType, balance,acCreationDate(YYYY-MM-DD)");
						BankAccount validateAcc = validateAll(validatedAccNo, sc.next(), sc.next(), sc.next(),
								sc.nextDouble(), sc.next(), accts);
						accts.put(validatedAccNo, validateAcc);

						break;

					case 2:
						System.out.println("All Account details are as below : ");
						for (BankAccount b2 : accts.values()) {
							System.out.println(b2);
						}
						break;

					case 3:
						System.out.println("Enter acc no : ");
						BankAccount b3 = checkIfAccExist(sc.nextInt(), accts);
						System.out.println("Account exists..below are account details : \n" + b3);

						break;
					case 4:
						System.out.println("enter bank ac no and amount to be deposited");

						BankAccount b4 = checkIfAccExist(sc.nextInt(), accts);
						b4.depositeMoney(sc.nextInt());

						break;

					case 5:
						System.out.println("enter bank ac no and amount to be withdraw");

						BankAccount b5 = checkIfAccExist(sc.nextInt(), accts);
						b5.withdrawMoney(sc.nextInt());

						break;
						
					case 6:
						System.out.println("enter src acc no and destination account and amount: ");
						BankAccount bsrc=checkIfAccExist(sc.nextInt(), accts);
						BankAccount bdest=checkIfAccExist(sc.nextInt(), accts);
						bsrc.fundTransfer(bdest, sc.nextInt());
						break;

					case 7:
						System.out.println("enter acc no");
//						BankAccount b7 = checkIfAccExist(sc.nextInt(), accts);
//						System.out.println(b7);
						int accNo=sc.nextInt();
						
						if(accts.get(accNo)==null)
							System.out.println("Invalid acc no");
						else
							System.out.println(accts.get(accNo));

						break;
					case 8:
						TreeMap<Integer,BankAccount> sortedMap=new TreeMap<Integer,BankAccount>(accts);
						System.out.println(sortedMap);
						System.out.println("sorted account list by account number ");
						for(BankAccount b : sortedMap.values())
							System.out.println(b);
						
;
						break;

					case 9:
						List<BankAccount> bankList = new ArrayList<>(accts.values());
						Comparator <BankAccount> comp = (BankAccount b1 , BankAccount b2) -> Double.compare(b1.getBalance(),b2.getBalance());
						Collections.sort(bankList,comp);
						System.out.println("Sorted acc List based on balance ");
						bankList.forEach(c -> System.out.println(c));
												
						
						break;
					case 10:
						List<BankAccount> bankList2 = new ArrayList<>(accts.values());
						Comparator <BankAccount> comp2 = (BankAccount b1 , BankAccount b2) -> b1.getFirstName().compareTo(b2.getFirstName());
						Collections.sort(bankList2,comp2);
						System.out.println("Sorted acc List based on name ");
						bankList2.forEach(c -> System.out.println(c));

						break;

					default:
						System.out.println("Invalid choice..please enter again...");

					}
				} catch (Exception e) {
					// System.out.println(e);
					e.printStackTrace();
					System.out.println("Please try again!!");
					System.out.println(sc.nextLine());
				}
			}

		}

	}

}
