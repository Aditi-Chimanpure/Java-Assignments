



//4.1 Can you arrange Fruit,Apple,Orange,Mango in inheritance hierarchy ?
//Use tight encapsulation.
//
//4.2 Properties (instance variables)  : color : String , weight : double , name:String, fresh : boolean
//
//4.3 Add suitable constructor
//
//4.4 Override  toString correctly to return state of all fruits (return only  : name ,color , weight )
//
//4.5 Add a taste() method : public String taste()
//
//For Fruit : Can you identify taste of any general fruit ? NO
//So add a taste() with this definition : returns "no specific taste" 
//
//Apple : should return  "sweet n sour"
//Mango : should return  "sweet"
//Orange : should return  "sour"
package Fruit_Basket;
public class Fruits {
	private String colour;
	private double weight;
	private String name;
	private boolean fresh;

	public Fruits(String c,String n, double w,boolean f) {
				
		System.out.println("in fruits constructor");
		
		colour=c;
		weight = w;
		name=n;
		fresh=f;

	}
	public Fruits()
	{}
	
	

	public String taste() {
		return "no specific taste";
	}
	
	public String toString() {
		return "Name : "+name +" Color : "+colour+" weight : "+weight;
	}
	
	public String getName()
	{
		return name;
	}
	public String getColor()
	{
		return colour;
	}
	public double getWeight()
	{
		return weight;
	}
	public boolean isFresh()
	{
		return fresh;
	}
	public void setStale()
	{
		fresh = false;
	}
	
}

class Mango extends Fruits {
	public Mango( String colour, String name,double weight,boolean fresh) 
	{
		super(colour,name,weight,fresh);
		
		System.out.println("in Mango constructor");
	}
	@Override
	public String taste()
	{
		return "Sweet";
	}
//	public String toString() {
//		return super.toString();
//	}
	
	public void  pulp()
	{
		System.out.println(super.getName()+" "+super.getColor()+" "+ " creating pulp");
	}
}

class Apple extends Fruits {
	public Apple(String colour, String name,double weight,boolean fresh) {
		super(colour,name,weight,fresh);
		System.out.println("in Apple constructor");
	}
	@Override
	public String taste()
	{
		return "Sweet n sour";
	}
	
	public String toString() {
		return super.toString();
	}
	
	public void jam()
	{
		System.out.println(super.getName()+ " " +" creating jam");
	}
	
}

class Orange extends Fruits {
	public Orange()
	{ }
	
	public Orange(String colour, String name,double weight,boolean fresh) {
		super(colour,name,weight,fresh);
		System.out.println("in Orange constructor");
	}
	
	@Override
	public String taste()
	{
		return "sour";
	}
	
	public String toString() {
		return super.toString();
	}
		
	public void juice()
	{
		System.out.println(super.getName()+" "+super.getWeight()+" "+ " creating juice");
	}
	
}