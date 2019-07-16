package minicode.employees.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name="seq", initialValue=6)
public class Employee{
	
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@Id
	private Long id;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="MIDL_INIT")
	private String middleInitial;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="BIRTH_DATE")
	private LocalDate dateOfBirth;
	@Column(name="EMPL_DATE")
	private LocalDate dateOfEmployment;
	@Column(name="STATUS")
	private String status;

}