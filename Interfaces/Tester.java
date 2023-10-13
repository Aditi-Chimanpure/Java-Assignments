package Interfaces;
//Create Java application for fixed stack & growable stack based on Stack i/f , for storing customer details
//
//Customer has : id(int), name (string) , address(string)
//Provide suitable constructor n toString
//
//Steps
//3.1  Create Customer class
//3.2 Stack interface -- push & pop functionality for Customer refs. & declare STACK_SIZE as a constant. 
//3.3 Create implementation class of Stack i/f -- FixedStack (array based)
//3.4 Create another implementation class of Stack i/f-- GrowableStack (array based)
//
//3.5 
//Create Tester class ()
//Display Menu
//Note : Must use 1 switch-case only . You won't need any complex nested control structure
//Once user selects either fixed or growable stack , user shouldn't be allowed to change the selection of the stack.
//
//1 -- Choose Fixed Stack
//
//2 -- Choose Growable Stack
//
//3 -- Push data 
//I/P : Accept customer details & store these details in the earlier chosen stack or give error mesg : NO stack chosen !!!
//In case user has chosen fixed stack , n stack is full give err mesg. 
//In case of growable stack , should be able to save customer details w/o getting err.
//
//4 --- Pop data & display the same (from the earlier chosen stack or give error mesg : NO stack chosen !!!)
//No inputs are required : pop customer details from the top of the stack
//
//5 -- Exit
import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Stack st=null; 
		boolean flag = false;
		while(true) {
		System.out.println("Menu\n 1.Fixed stack \n 2.Growable Stack \n 3. Push\n 4. Pop \n 5.exit\n 6.display ");
		System.out.println("enter your choice");
		int choice = sc.nextInt();
		
		switch (choice) {
		case 1:
			if(!flag)
			{
				st= new FixedStack();
				System.out.println("Fixed stack choosen");
				flag=true;
			}
			else
			{
				System.out.println("Stack already choosen");
			}
            
			break;

		case 2:
			if(!flag)
			{ 
				st= new  GrowablaStack();
				System.out.println("growable stack choosen");
				
				
				flag=true;
			}
			else
			{
				System.out.println("Stack already choosen");
			}
            

			break;
		case 3:
			if(flag)
			{
				if( st.isStackFull()) {
				System.out.println("enter customer details : ");
				System.out.println("Enter the customer ID : ");
				int custId= sc.nextInt();
				System.out.println("Enter name : ");
				String name=sc.next();
				System.out.println("Enter address : ");
				String address=sc.next();
				Customer cust1 = new Customer (custId,name,address);
				st.push(cust1);
				}
				else
					System.out.println("stack is full ");
				
				
			}
		
			
			

			break;
		case 6:
		      st.display();
		      break;
		case 4:
			if(flag) {
				st.pop();
			}

			break;
		case 5:
			System.exit(0);
				
			break;

		default:
			break;
		}
	}

}
}