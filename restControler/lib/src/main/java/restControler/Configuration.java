package restControler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@org.springframework.context.annotation.Configuration
public class Configuration {

	@Bean("one")
	public List<Employee> listEmployees() {
		List<Employee> employeeList = new ArrayList<>();
		Employee boss = new Employee("neo", "developer");
    	Employee developer = new Employee("aloy", "QA");
    	employeeList.add(boss);
    	employeeList.add(developer);
		return employeeList;
	}
}
