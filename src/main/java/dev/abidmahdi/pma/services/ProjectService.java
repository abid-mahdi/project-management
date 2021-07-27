package dev.abidmahdi.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.abidmahdi.pma.dao.ProjectRepository;
import dev.abidmahdi.pma.dto.ProjectStatus;
import dev.abidmahdi.pma.entities.Project;

@Service
public class ProjectService {

	@Autowired
	ProjectRepository proRepo;
	
	public List<Project> getAll() {
		return proRepo.findAll();
	}
	
	public void save(Project project) {
		proRepo.save(project);
	}

	public List<ProjectStatus> getStatuses() {
		return proRepo.projectStatuses();
	}

}
