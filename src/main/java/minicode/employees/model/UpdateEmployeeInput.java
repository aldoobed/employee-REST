package minicode.employees.model;

import java.time.LocalDate;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeInput {
	@Size(min = 1, max = 100)
	private String firstName;
	@Size(max = 1)
	private String middleInitial;
	@Size(min = 1, max = 100)
    private String lastName;
	@Past
    private LocalDate dateOfBirth;
	@Past
    private LocalDate dateOfEmployment;
}