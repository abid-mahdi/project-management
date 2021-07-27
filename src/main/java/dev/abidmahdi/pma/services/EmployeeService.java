package dev.abidmahdi.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.abidmahdi.pma.dao.EmployeeRepository;
import dev.abidmahdi.pma.dto.EmployeeProject;
import dev.abidmahdi.pma.entities.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository empRepo;
	
	public List<Employee> getAll() {
		return empRepo.findAll();
	}
	
	public void save(Employee emp) {
		empRepo.save(emp);
	}
	
	public List<EmployeeProject> getEmployeeProjects() {
		return empRepo.employeeProjects();
	}

	public Employee findByEmployeeId(long employeeId) {
		return empRepo.findByEmployeeId(employeeId);
	}

	public void delete(Employee employee) {
		empRepo.delete(employee);
	}

}
