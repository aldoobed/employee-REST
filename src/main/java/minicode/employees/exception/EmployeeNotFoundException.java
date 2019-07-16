package minicode.employees.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Employee not found")
public class EmployeeNotFoundException extends Exception {

private static final long serialVersionUID = 1L;

public EmployeeNotFoundException(Long id) {
    super("Could not find employee " + id);
  }
}