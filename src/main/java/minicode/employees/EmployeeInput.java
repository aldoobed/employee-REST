package minicode.employees;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	@NotBlank
    private String lastName;
	@NotNull
	@Past
	@JsonFormat(pattern = "YYYY-MM-dd")
    private LocalDate dateOfBirth;
	@NotNull
	@Past
	@JsonFormat(pattern = "YYYY-MM-dd")
    private LocalDate dateOfEmployment;
}
