package dev.abidmahdi.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.abidmahdi.pma.services.EmployeeService;
import dev.abidmahdi.pma.services.ProjectService;

@Controller
public class HomeController {

	@Autowired
	ProjectService proService;
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping("/")
	public String displayTable(Model model) throws JsonProcessingException {
		model.addAttribute("projects", proService.getAll());
		model.addAttribute("employees", empService.getEmployeeProjects());
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(proService.getStatuses());
		model.addAttribute("projectStatusCount", jsonString);
		
		return "main/home";
	}
}
