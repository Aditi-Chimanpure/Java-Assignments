package com.app.core;

import java.util.Collections;
import static utils.Customerutils.*;
import java.util.List;
import java.util.Scanner;
import static utils.Customerutils.populateCustomer;

import Custom_Exception.CustomerHandlingException;
import utils.CustomerValidationRules;
import utils.Customerutils;
import utils.DobLastNameComparator;

public class TesterCMS {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			List<Customer> customerList = populateCustomer();
			boolean exit = false;
			while (!exit) {
				System.out.println("Options : \n1.SignUp \n2.Sign in \n" + "3.Change Password \n"
						+ "4.Unsubscribe \n5.Display all\n6.Sort by Email\n7.SortBy DOB and last name\n8.Subscription Notice\n9.Auto Unsubscribe\n0.Exit");
				System.out.println("Choose an option: ");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println(
								"Enter Customer Details: firstname, lastname,DOB(YYYY-MM-DD), email, password,regamt, plan,regDate");
						Customer validatedCust = CustomerValidationRules.validateAllInputs( sc.next(),
								sc.next(), sc.next(),sc.next(), sc.next(), sc.nextDouble(), sc.next(),sc.next(), customerList);
						customerList.add(validatedCust);
						System.out.println("New customer added to system ");
						break;
					case 2:
						System.out.println("Enter customer email and Password : ");
						
						Customer cust=Customerutils.signIn(sc.next(),sc.next(),customerList);
						System.out.println(cust);
						break;
						
					case 3:
						
						Customer cust1=Customerutils.signIn(sc.next(),sc.next(),customerList);
						System.out.println("Enter new password : ");
						Customerutils.passwordChange(cust1,sc.next());
						break;
						
					case 4:
						System.out.println("Enter email ID ");
						Customer cust2=new Customer(sc.next());
						boolean removed=customerList.remove(cust2);
						if(!removed)
							throw new CustomerHandlingException("Invalid email ID..can not be unsubscribed");
						System.out.println("Unsubscribed..");
						break;						
						
						
					case 5:
						for(Customer c :customerList)
						{
							System.out.println(c);
						}
						break;
					case 6:
						System.out.println("befor Sort");
						for(Customer c :customerList)
						{
							System.out.println(c);
						}
						Collections.sort(customerList);
						System.out.println("after Sort");
						for(Customer c :customerList)
						{
							System.out.println(c);
						}
						break;
					case 7:
						System.out.println("befor Sort");
						for(Customer c :customerList)
						{
							System.out.println(c);
						}
						Collections.sort(customerList,new DobLastNameComparator());
						System.out.println("after Sort");
						for(Customer c :customerList)
						{
							System.out.println(c);
						}
					case 8:
						
						subscrptionValidationNotice(customerList);
						break;
					
					case 9 : 
						autoUnsubscribe(customerList);
						break;
						
					case 0:
						exit=true;
						break;
						

					default:
						System.out.println("Invalid choice..enter Again..");
						break;
					}
				} catch (Exception e) { 
					//System.out.println(e);
					e.printStackTrace();
					System.out.println("Please retry");
					sc.nextLine();
				}
			}
		}

	}
//	public void hardCodedCust()
//	{//Enter Customer Details: custid  , firstname, lastname, email, password,regamt, ,plan");
//		Customer cust1=new Customer(1,"ad","cd","ad@gmail.com","a123",1000.0,SILVER);
//		customerList.add(cust1);
//	}

}
