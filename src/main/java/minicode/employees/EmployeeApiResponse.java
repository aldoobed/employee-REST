package minicode.employees;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class EmployeeApiResponse {
	
	private HttpStatus status;
	private String code;
	private String message;
	private Employee employee;

	public EmployeeApiResponse(Employee employee, HttpStatus status){
		this.status=status;
		this.employee=employee;
		this.code="SUCESS";
	}

	public EmployeeApiResponse(Exception ex, HttpStatus status){
		this.status=status;
		this.code="ERROR";
		this.message=ex.getMessage();
	}

}