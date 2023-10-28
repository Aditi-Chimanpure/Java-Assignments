package com.core.app;

public class Cricketer {
	private String name;
	private int age;
	private String email_id;
	String Phoneno;
	private int rating;
	

	public Cricketer(String name, int age, String email_id, String phoneno, int rating) {
		super();
		this.name = name;
		this.age = age;
		this.email_id = email_id;
		Phoneno = phoneno;
		this.rating = rating;
	}
	
	
	@Override
	public String toString() {
		return "Cricketer [name=" + name + ", age=" + age + ", email_id=" + email_id + ", Phoneno=" + Phoneno
				+ ", rating=" + rating + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPhoneno() {
		return Phoneno;
	}

	public void setPhoneno(String phoneno) {
		Phoneno = phoneno;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}


}
