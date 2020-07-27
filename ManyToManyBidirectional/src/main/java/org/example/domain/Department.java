package org.example.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.TableGenerator;
import java.util.List;

@Setter
@Getter
@Entity
public class Department {

	@Id
	@GeneratedValue(generator = "Department_Gen")
	@TableGenerator(name = "Department_Gen",
			table = "many_to_many_id_gen_bi",
			pkColumnName = "GEN_NAME",
			valueColumnName = "GEN_VALUE"
	)
	@Column(name = "departmentId")
	private Integer departmentId;

	private String departmentName;

	private String departmentCode;

	@ManyToMany(mappedBy = "departments")
	private List<Employee> employees;

	@Override
	public String toString() {
		return "Department{" +
				"departmentId=" + departmentId +
				", departmentName='" + departmentName + '\'' +
				", departmentCode='" + departmentCode + '\'' +
//				", employees=" + employees +
				'}';
	}
}
