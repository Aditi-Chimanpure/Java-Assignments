package Interfaces;

public class FixedStack implements Stack {
	int STACK_SIZE = 2;
	Customer[] c1 = new Customer[STACK_SIZE];
	static int top = -1;

	public void push(Customer cust) {
		if (top < STACK_SIZE - 1) {
			c1[++top] = cust;
		} else {
			System.out.println("Stack is full");
		}
	}

	public boolean isStackFull() {
		if (top < STACK_SIZE - 1)
			return true;
		else
			return false;
	}

	public void display() {
		System.out.println("Fixed stack elements are :");
		for (Customer a : c1) {
			if (a != null)
				System.out.println(a.toString());
		}
	}

	int lastIndex = STACK_SIZE;

	public void pop() {

		if (top > -1) {
			System.out.println("details of stack element being popped is : ");
			System.out.println(c1[top].toString());
			c1[top] = null;
			top--;
			System.out.println("customer details popped");
		} else {
			System.out.println("Stack is empty");
		}

	}

}
