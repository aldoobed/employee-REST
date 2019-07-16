package minicode.employees;

import java.time.LocalDate;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	@JsonFormat(pattern = "YYYY-MM-dd")
    private LocalDate dateOfBirth;
	@Past
	@JsonFormat(pattern = "YYYY-MM-dd")
    private LocalDate dateOfEmployment;
}