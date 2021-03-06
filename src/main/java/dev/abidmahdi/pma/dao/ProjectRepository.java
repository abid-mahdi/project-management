package dev.abidmahdi.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import dev.abidmahdi.pma.dto.ProjectStatus;
import dev.abidmahdi.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {

	@Override
	public List<Project> findAll();

	@Query(nativeQuery=true, value="SELECT stage as label, COUNT(stage) as value "
			+ "FROM project "
			+ "GROUP BY stage")
	public List<ProjectStatus> projectStatuses();
	
}
