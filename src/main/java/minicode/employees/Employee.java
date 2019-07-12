package minicode.employees;

import java.util.Date;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Employee{
	
	//private int id;
	private @GeneratedValue @Id Long id;
	private String firstName;
	private String middleInitial;
	private String lastName;
	private Date dateOfBirth;
	private Date dateOfEmployment;
	private String status;

	public Employee(){}

	public Employee(Long id, String firstName, String middleInitial, String lastName, 
		Date dateOfBirth, Date dateOfEmployment, String status){

		this.id = id;
		this.firstName = firstName;
		this.middleInitial = middleInitial;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.dateOfEmployment = dateOfEmployment;
		this.status = status;

	}

		public Employee(Long id, String firstName, String middleInitial){

		this.id = id;
		this.firstName = firstName;
		this.middleInitial = middleInitial;

	}

//	public int getId(){
//		return this.id;
//	}
//
//	public String getFirstName(){
//		return this.firstName;
//	}
//
//	public String getMiddleInitial(){
//		return this.middleInitial;
//	}

}