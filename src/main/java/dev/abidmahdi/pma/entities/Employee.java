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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="employee_generator")
	@SequenceGenerator(name = "employee_generator", sequenceName = "employee_seq", allocationSize = 1)
	private long employeeId;

	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
			fetch = FetchType.LAZY)
	@JoinTable(name="project_employee",
	joinColumns = @JoinColumn(name="employee_id"),
	inverseJoinColumns = @JoinColumn(name="project_id"))
	private List<Project> projects;

	@NonNull
	@NotBlank(message="You must give a first name")
	@Size(min=2, max=50)
	private String firstName;
	
	@NonNull
	@NotBlank(message="You must give a last name")
	@Size(min=1, max=50)
	private String lastName;
	
	@NonNull
	@NotBlank
	@Email(message="You must be a valid email address")
	private String email;
	
}
