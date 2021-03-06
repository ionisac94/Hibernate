package org.example.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.TableGenerator;
import java.util.List;

@Data
@Entity
public class Department {

	@Id
	@GeneratedValue(generator = "Department_Gen")
	@TableGenerator(name = "Department_Gen",
			table = "many_to_many_id_gen",
			pkColumnName = "GEN_NAME",
			valueColumnName = "GEN_VALUE"
	)
	@Column(name = "departmentId")
	private Integer departmentId;

	private String departmentName;

	private String departmentCode;

	@ManyToMany(mappedBy = "departments")
	private List<Employee> employees;
}
