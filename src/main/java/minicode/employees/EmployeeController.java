package minicode.employees;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    private final static Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value="/employees",method=RequestMethod.GET)
    public List<Employee> getAll() {
        logger.info("getting all employees");
        return repository.findAll();
		//return new Employee[] {new Employee(1L, "Aldo", "get"),new Employee(2L, "Aldo", "all")};
    }

    @RequestMapping(value="/employees/{id}",method=RequestMethod.GET)
    public Optional<Employee> getEmployee(@PathVariable Long id) {
        logger.info("getting employee with id:"+id);
        //return new Employee[] {new Employee(1L, "Aldo", "Perez")};
        return repository.findById(id);
    }
    
    @RequestMapping(value="/employees",method=RequestMethod.POST)
    public Employee craeateEmployee(@RequestBody Employee newEmployee) {
        logger.info("creating new employee");
        return repository.save(newEmployee);
    }
    
    @RequestMapping(value="/employee",method=RequestMethod.PUT)
    public Employee updateEmployee(@RequestParam(value="id") String id) {
    	return new Employee(1L, "Aldo", "PUT");
    }
    
    @RequestMapping(value="/employee",method=RequestMethod.DELETE)
    public Employee deactivateEmployee(@RequestParam(value="id") String id) {
    	return new Employee(1L, "Aldo", "DELETE");
    }
}