package minicode.employee.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import minicode.employee.model.Employee;

@RestController
public class EmployeeController {

    @RequestMapping(value="/employee/{id}",method=RequestMethod.GET)
    public Employee[] getEmployee(@PathVariable String id) {
    	if("all".equals(id)) {
    		return new Employee[] {new Employee(1, "Aldo", "get"),new Employee(2, "Aldo", "all")};
    	}else {
    		return new Employee[] {new Employee(1, "Aldo", "Perez")};
    	}
    }
    
    @RequestMapping(value="/employee",method=RequestMethod.POST)
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