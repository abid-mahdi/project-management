package dev.abidmahdi.pma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dev.abidmahdi.pma.dao.EmployeeRepository;
import dev.abidmahdi.pma.dao.ProjectRepository;

@SpringBootApplication
public class ProjectManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}

}
