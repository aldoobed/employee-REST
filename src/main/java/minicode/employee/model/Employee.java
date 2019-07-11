package minicode.employee.model;

import java.util.Date;

public class Employee{
	
	private int id;
	private String firstName;
	private String middleInitial;
	private String lastName;
	private Date dateOfBirth;
	private Date dateOfEmployment;
	private String status;

	public Employee(int id, String firstName, String middleInitial, String lastName, 
		Date dateOfBirth, Date dateOfEmployment, String status){

		this.id = id;
		this.firstName = firstName;
		this.middleInitial = middleInitial;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.dateOfEmployment = dateOfEmployment;
		this.status = status;

	}

		public Employee(int id, String firstName, String middleInitial){

		this.id = id;
		this.firstName = firstName;
		this.middleInitial = middleInitial;

	}

	public int getId(){
		return this.id;
	}

	public String getFirstName(){
		return this.firstName;
	}

	public String getMiddleInitial(){
		return this.middleInitial;
	}

}