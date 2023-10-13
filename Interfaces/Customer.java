//4.
//Hands on 
//(Main objective :Run time polymorphism achieved using interfaces)


package Interfaces;

public class Customer {
	private int id;
	private String name;
	private String address;
	public Customer(int id,String name,String address){
		this.id=id;
		this.name=name;
		this.address=address;
		
	}
    
	public String toString() {
		return "id : "+id+" name : "+name+" Address : "+address;
	}
}
