package restControler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;

@RestController
public class EmployeeController {

	
	@Autowired
	private EmployeeService employeeService;


	@GetMapping("/employees")
	ResponseEntity<List<Employee>> all() {
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}

	@PostMapping("/employees")
	public ResponseEntity<Employee> newEmployee(@RequestBody Employee newEmployee) {
		validateEmployee(newEmployee);
		employeeService.saveEmployee(newEmployee);
		return ResponseEntity.ok(newEmployee);
	}

	private void validateEmployee(Employee newEmployee) {
		if (newEmployee.getName() == null) {
			throw new IllegalArgumentException("Employee without name");
		} else if (newEmployee.getRole() == null) {
			throw new IllegalArgumentException("Employee without role");
		}

	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> one(@PathVariable Long id) {
		return ResponseEntity.ofNullable(employeeService.findById(id));
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
		Employee employeeUpdated = employeeService.updateEmployee(newEmployee,id);
		return ResponseEntity.ofNullable(employeeUpdated);
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id) {
		return ResponseEntity.ofNullable(employeeService.deleteEmployee(id));
	}
}
