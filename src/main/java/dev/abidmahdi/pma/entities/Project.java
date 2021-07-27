package dev.abidmahdi.pma.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Project {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="project_generator")
	@SequenceGenerator(name = "project_generator", sequenceName = "project_seq", allocationSize = 1)
	private long projectId;

	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
			fetch = FetchType.LAZY)
	@JoinTable(name="project_employee",
				joinColumns = @JoinColumn(name="project_id"),
				inverseJoinColumns = @JoinColumn(name="employee_id")
	)
	private List<Employee> employees;
	
	@NonNull
	private String name;
	
	@NonNull
	private String stage;
	
	@NonNull
	private String description;

}
