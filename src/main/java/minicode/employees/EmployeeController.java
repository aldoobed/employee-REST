package minicode.employees;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class EmployeeController {

    private final static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @RequestMapping(value="/employees",method=RequestMethod.GET)
    public Employee[] getAll() {
        logger.info("getting all employees");
		return new Employee[] {new Employee(1, "Aldo", "get"),new Employee(2, "Aldo", "all")};
    }

    @RequestMapping(value="/employees/{id}",method=RequestMethod.GET)
    public Employee[] getEmployee(@PathVariable String id) {
        logger.info("getting employee with id:"+id);
        return new Employee[] {new Employee(1, "Aldo", "Perez")};
    }
    
    @RequestMapping(value="/employees",method=RequestMethod.POST)
    public Employee craeateEmployee(@RequestParam(value="id") String id) {
    	return new Employee(1, "Aldo", "POST");
    }
    
    @RequestMapping(value="/employee",method=RequestMethod.PUT)
    public Employee updateEmployee(@RequestParam(value="id") String id) {
    	return new Employee(1, "Aldo", "PUT");
    }
    
    @RequestMapping(value="/employee",method=RequestMethod.DELETE)
    public Employee deactivateEmployee(@RequestParam(value="id") String id) {
    	return new Employee(1, "Aldo", "DELETE");
    }
}