package dev.abidmahdi.pma.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dev.abidmahdi.pma.entities.Employee;
import dev.abidmahdi.pma.services.EmployeeService;

@Controller
@RequestMapping("/employees")
@Validated
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping
	public String displayEmployees(Model model) {
		model.addAttribute("employees", empService.getAll());
		return "employees/list-employees";
	}

	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "employees/new-employee";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@Valid Employee employee) {
		empService.save(employee);
		return "redirect:/employees/new";
	}
	
	@GetMapping("/update")
	public String displayEmployeeUpdateForm(@RequestParam("id") long employeeId, Model model) {
		model.addAttribute("employee", empService.findByEmployeeId(employeeId));
		return "employees/new-employee";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("id") long employeeId) {
		empService.delete(empService.findByEmployeeId(employeeId));
		return "redirect:/employees";
	}
	
}