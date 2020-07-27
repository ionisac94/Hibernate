package org.example.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.TableGenerator;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
public class Employee {

	@Id
	@GeneratedValue(generator = "Employee_Gen")
	@TableGenerator(name = "Employee_Gen",
			table = "many_to_many_id_gen_bi",
			pkColumnName = "GEN_NAME",
			valueColumnName = "GEN_VALUE"
	)
	@Column(name = "employeeId")
	private Integer employeeId;

	private String firstName;

	private String lastName;

	private LocalDate dateEmployed;

	private Integer salary;

	@ManyToMany(cascade = CascadeType.ALL, targetEntity = Department.class)
	@JoinTable(name = "department_employee",
			joinColumns = @JoinColumn(name = "employeeId"),
			inverseJoinColumns = @JoinColumn(name = "departmentId"))
	private List<Department> departments;

	@Override
	public String toString() {
		return "Employee{" +
				"employeeId=" + employeeId +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", dateEmployed=" + dateEmployed +
				", salary=" + salary +
				", departments=" + departments +
				'}';
	}
}
