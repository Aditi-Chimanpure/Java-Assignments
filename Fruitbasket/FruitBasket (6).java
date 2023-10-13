//4.7 Add all of above classes under the package "com.app.fruits"
//4.8 Create java application FruitBasket , with main method , as a tester
//4.9 Prompt user for the basket size n create suitable data structure
//
//4.10 Supply options
//1. Add Mango
//2. Add Orange
//3. Add Apple
//NOTE : You will be ALWAYS adding a fresh fruit in the basket , in all of above options.
//
//4. Display names of all fruits in the basket.
//
//5. Display name,color,weight , taste of all fresh fruits , in the basket.
//
//
//6. Mark a fruit in a basket , as stale(=not fresh)
//i/p : index 
//o/p : error message (in case of invalid index) or mark it stale
//
//7. Mark all sour fruits stale 
//Hint : Use equals() method of the String class.
//
//8. Invoke fruit specific functionality (pulp / juice / jam)
//i/p : index
//Invoke correct functionality (pulp / juice / jam)
//
//9. Exit 
package Fruit_Basket;

import java.util.Scanner;

public class FruitBasket {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of basket : ");
		int size = sc.nextInt();
		Fruits[] arr = new Fruits[size];

		boolean flag = false;
		int index = 0;
		while (!flag) {
			System.out.println(
					"Enter the choice \n 1.Add Mango 2.Add Orange 3.Add Apple 4.display all names  5.Display Fresh fruits 6.Mark Fruit Stale 7.Mark Sour fruit stale 8.Fruit specific method 9.Exit ");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				if (index < arr.length) {
					System.out.println("Ente color,name,weight,fresh : ");
					arr[index] = new Mango(sc.next(), sc.next(), sc.nextDouble(), sc.nextBoolean());
					index++;
					System.out.println("Mango added");
				} else {
					System.out.println("Basket is full");
					// System.exit(1);
				}

				break;

			case 2:
				if (index < arr.length) {
					System.out.println("Ente color,name,weight,fresh : ");
					arr[index] = new Orange(sc.next(), sc.next(), sc.nextDouble(), sc.nextBoolean());
					index++;
				} else {
					System.out.println("Basket is full");
					// System.exit(1);
				}
				break;

			case 3:
				if (index < arr.length) {
					System.out.println("Ente color,name,weight,fresh : ");
					arr[index] = new Apple(sc.next(), sc.next(), sc.nextDouble(), sc.nextBoolean());
					;
					index++;
				} else {
					System.out.println("Basket is full");
					// System.exit(1);
				}
				break;

			case 9:
				System.out.println("Exit from basket ");
				flag = true;

				break;

			case 4:
				for (Fruits f : arr) {
					System.out.println(f.getName());
				}
				break;

			case 5:

				for (Fruits f : arr)

				{
					if (f.isFresh() == true) {
						if (f instanceof Mango)
							System.out.println(f.toString() + " " +  f.taste());
						else if (f instanceof Orange)
							System.out.println(f.toString() + " " +  f.taste());
						else
							System.out.println(f.toString() + " " +  f.taste());

					}

				}

				break;

			case 6:
				System.out.println("Enter the index of fruit : ");
				int num = sc.nextInt();
				if( num<arr.length && num>0) {
				Fruits fs = arr[num - 1];
				fs.setStale();
				System.out.println("Fruit is marked as : " + fs.isFresh());
				}
				else {
					System.out.println("invalid index");
				}

				break;
			
			case 7:
				
				for(int i = 0;i<arr.length;i++)
				{
					Fruits fs2 =arr[i];
					System.out.println(fs2.isFresh());
					if (fs2.taste().equals("sour"))
					{
						fs2.setStale();
						System.out.println(fs2.isFresh());
					}
						
				}
				break;
				
			case 8:
				System.out.println("Enter the index of fruit : ");
				int num1 = sc.nextInt();
				Fruits fs3 =arr[num1-1];
				if (fs3 instanceof Mango)
					((Mango)fs3).pulp();
				else if (fs3 instanceof Orange)
					((Orange)fs3).juice();
				else
					((Apple)fs3).jam();
				
				break;
				

			default:
				System.out.println("invalid choice");
				break;
			}
		}

		sc.close();

	}

}
