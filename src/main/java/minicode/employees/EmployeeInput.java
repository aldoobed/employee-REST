package minicode.employees;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeInput {
	@NotNull
	@NotBlank
	private String firstName;
	@Size(max = 1)
	private String middleInitial;
	@NotNull
	@Size(min = 1, max = 100)
    private String lastName;
	@NotNull
	@Past
    private LocalDate dateOfBirth;
	@NotNull
	@Past
    private LocalDate dateOfEmployment;
}
