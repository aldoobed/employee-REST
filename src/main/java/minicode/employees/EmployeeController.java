package minicode.employees;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        		.stream()
        		.filter(employee -> Status.ACTIVE.toString().equals(employee.getStatus()))
        		.collect(Collectors.toList());
	}

    @RequestMapping(value="/employees/{id}",method=RequestMethod.GET)
    public Optional<Employee> getEmployee(@PathVariable Long id) {
        logger.info("getting employee with id:"+id);
        return repository.findById(id).filter(employee -> Status.ACTIVE.toString().equals(employee.getStatus()));
    }
    
    @RequestMapping(value="/employees",method=RequestMethod.POST)
    public Employee craeateEmployee(@RequestBody Employee newEmployee) {
        logger.info("creating new employee");
        newEmployee.setStatus(Status.ACTIVE.toString());
        return repository.save(newEmployee);
    }
    
    @RequestMapping(value="/employees",method=RequestMethod.PUT)
    public Optional<Employee> updateEmployee(@RequestBody Employee employeeToUpdate) {
    	logger.info("updating employee with id:"+employeeToUpdate.getId());
        return repository.findById(employeeToUpdate.getId()).map(employee -> {
            employee.setFirstName(employeeToUpdate.getFirstName());
            employee.setMiddleInitial(employeeToUpdate.getMiddleInitial());
            employee.setDateOfBirth(employeeToUpdate.getDateOfBirth());
            employee.setDateOfEmployment(employeeToUpdate.getDateOfEmployment());
            return repository.save(employee);
        });
    }
    
    @RequestMapping(value="/employees/{id}",method=RequestMethod.DELETE)
    public Optional<Employee> deactivateEmployee(@PathVariable Long id) {
        logger.info("deactivating employee with id:"+id);
    	return repository.findById(id).map(employee -> {
            employee.setStatus(Status.INACTIVE.toString());
            return repository.save(employee);
        });
    }
}