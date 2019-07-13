package minicode.employees;

import java.util.Date;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;

@Data
@Entity
public class Employee{
	
	@GeneratedValue
	@Id
	private Long id;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="MIDL_INIT")
	private String middleInitial;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="BIRTH_DATE")
	private Date dateOfBirth;
	@Column(name="EMPL_DATE")
	private Date dateOfEmployment;
	@Column(name="STATUS")
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