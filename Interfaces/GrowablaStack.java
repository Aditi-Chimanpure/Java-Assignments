package Interfaces;

public class GrowablaStack implements Stack {

	int STACK_SIZE = 2;
	Customer[] c1 = new Customer[STACK_SIZE];
	static int top = -1;

	public void push(Customer cust) {

		if (top == c1.length - 1) {
			int new_STACK_SIZE = c1.length * 2;
			Customer[] c2 = new Customer[new_STACK_SIZE];
			System.arraycopy(c1, 0, c2, 0, STACK_SIZE);
			c1 = c2;
		}
		else  {
			c1[++top] = cust;
		}
	}

	
	public boolean isStackFull() {
		return true;
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
