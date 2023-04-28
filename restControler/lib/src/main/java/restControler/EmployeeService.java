package restControler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Transactional
	public Employee saveEmployee(Employee employee) {
		EmployeeEntity employeeEntity = new EmployeeEntity(employee);
		employeeRepository.save(employeeEntity);
		return employee;
	}
	
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll()
				.stream().map(entity -> new Employee(entity)).toList();
	}

	public Employee findById(Long id) {
		 Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
		 if(employeeEntity.isPresent()) {
			 return new Employee(employeeEntity.get());
		 } 
		 return null;
	}

	@Transactional
	public Employee updateEmployee(Employee newEmployee, Long id) {
		Optional<EmployeeEntity> employeeEntityOptional = employeeRepository.findById(id);
		if(employeeEntityOptional.isPresent()) {
			EmployeeEntity employeeEntity = employeeEntityOptional.get();
			employeeEntity.setName(newEmployee.getName());
			employeeEntity.setRole(newEmployee.getRole());
			employeeRepository.save(employeeEntity);
			return newEmployee;
		}
		return null;
		
	}

	public Employee deleteEmployee(Long id) {
		Optional<EmployeeEntity> employeeEntityOptional = employeeRepository.findById(id);
		if(employeeEntityOptional.isPresent()) {
			EmployeeEntity employeeEntity = employeeEntityOptional.get();
			employeeRepository.delete(employeeEntity);
			return new Employee(employeeEntity);
		}
		return null;
	}
}
