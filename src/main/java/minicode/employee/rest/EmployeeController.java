package minicode.employee.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class EmployeeController {

    @RequestMapping(value="/getEmployee",method=RequestMethod.GET)
    public Employee getEmployee(@RequestParam(value="id") String id) {
        return new Employee(1, "Aldo", "Perez");
    }
}