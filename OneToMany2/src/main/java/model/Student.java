package model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;
import java.util.Set;

@Entity
@Data
public class Student {

	@Id
	@TableGenerator(name = "STUD_GEN",
			table = "ID_GEN",
			pkColumnName = "GEN_NAME",
			valueColumnName = "GEN_VALUE")
	@GeneratedValue(generator = "STUD_GEN")
	private Integer id;

	private String firstName;

	private String lastName;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "student_phone",
			joinColumns = @JoinColumn(name = "student_id"),
			inverseJoinColumns = @JoinColumn(name = "phone_id"))
	private Set<Phone> phones;

	public Student(String firstName, String lastName, Set<Phone> phones) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phones = phones;
	}

	public Student(Set<Phone> phones) {
		this.phones = phones;
	}
}
