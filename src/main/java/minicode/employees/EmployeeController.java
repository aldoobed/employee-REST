package minicode.employees;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.annotations.ApiParam;

@RestController
public class EmployeeController {

    private final static Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value="/employees",method=RequestMethod.GET)
    public List<Employee> getAll() {
        logger.info("getting ACTIVE employees");
                
        return repository.findAll()
        		.stream()	// Java 8: The Stream API. It helps to support functional style coding like filter, map and reduce. 
        		.filter(employee -> Status.ACTIVE.toString().equals(employee.getStatus())) //Java 8: Lambda expressions, it let us usa an anonymous function as a method argument
        		.collect(Collectors.toList());
	}

    @RequestMapping(value="/employees/{id}",method=RequestMethod.GET)
    public Employee getEmployee(
        @ApiParam("Employee Id number to fetch")
        @Valid @Positive @PathVariable Long id) {

        logger.info("getting employee with id:"+id);

        try{
            return repository.findById(id)
            .filter(employee -> Status.ACTIVE.toString().equals(employee.getStatus()))
            .orElseThrow(()-> new EmployeeNotFoundException(id));    // Java 8: Optional<T>, this functionallity is a container that may or may not a non null, this class implements de method orElseThrow, which in case of null value will throw an exception of th type that we supplied

        }catch(EmployeeNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee Not Found");
        }
       
    }
    
    @RequestMapping(value="/employees",method=RequestMethod.POST)
    public Employee createEmployee(
    		@ApiParam("Info to create a new employee")
    		@RequestBody @Valid EmployeeInput newEmployee) {

    	logger.info("creating new employee");
        
        Employee employee = new Employee(
        		null,newEmployee.getFirstName(),newEmployee.getMiddleInitial(),
        		newEmployee.getLastName(),newEmployee.getDateOfBirth(),
        		newEmployee.getDateOfEmployment(),Status.ACTIVE.toString());
        
        return repository.save(employee);
    }
    
    @RequestMapping(value="/employees/{id}",method=RequestMethod.PUT)
    public Optional<Employee> updateEmployee(
    		@ApiParam("Employee info to update")
    		@RequestBody @Valid EmployeeInput employeeToUpdate,
    		@ApiParam("Employee Id number to deactivate")
   	     	@Valid @Positive @PathVariable Long id) {

    	logger.info("updating employee with id:"+id);

        return repository.findById(id)
            .map(employee -> {  //Java 8: Optional<T> map method, it applies the provides function, in this case for updating the employee, and resturns an Optional<T> of the result
                employee.setFirstName(employeeToUpdate.getFirstName());
                employee.setMiddleInitial(employeeToUpdate.getMiddleInitial());
                employee.setLastName(employeeToUpdate.getLastName());
                employee.setDateOfBirth(employeeToUpdate.getDateOfBirth());
                employee.setDateOfEmployment(employeeToUpdate.getDateOfEmployment());
                return repository.save(employee);
            });

    }
    
    @RequestMapping(value="/employees/{id}",method=RequestMethod.DELETE)
    public Employee deactivateEmployee(
    		@ApiParam("DELETE operation needs Authorization credentials, for testing use YWRtaW46YWRtaW4=")
    		@RequestHeader(value="Authorization") String authorization,
    		@ApiParam("Employee Id number to deactivate")
    	    @Valid @Positive @PathVariable Long id) {

        logger.info("deactivating employee with id:"+id);
      try{  
    	return repository.findById(id).map(employee -> {
            employee.setStatus(Status.INACTIVE.toString());
            return repository.save(employee);
        }).orElseThrow(()-> new EmployeeNotFoundException(id));
      }catch(EmployeeNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee Not Found");
        }
    }
}