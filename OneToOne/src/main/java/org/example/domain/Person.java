package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;
import java.time.LocalDate;


@Builder
//@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {

	@Id
	@TableGenerator(name = "Person_Gen",
			table = "ONE_TO_ONE_ID_GEN",
			pkColumnName = "GEN_NAME",
			valueColumnName = "GEN_VALUE")
	@GeneratedValue(generator = "Person_Gen")
	private Integer personId;

	private String firstName;

	private String lastName;

	private LocalDate dateOfBirth;

	@Enumerated(EnumType.STRING)
	private Nationalitty nationalitty;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "documentId", referencedColumnName = "documentId")
	private Document document;

	@Override
	public String toString() {
		return "Person{" +
				"personId=" + personId +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", dateOfBirth=" + dateOfBirth +
				", nationalitty=" + nationalitty +
				'}';
	}
}

