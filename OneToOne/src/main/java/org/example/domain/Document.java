package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Document {

	@Id
	@TableGenerator(name = "Document_Gen",
			table = "ONE_TO_ONE_ID_GEN",
			pkColumnName = "GEN_NAME",
			valueColumnName = "GEN_VALUE")
	@GeneratedValue(generator = "Document_Gen")
	private Integer documentId;

	private String serialNumber;

//	Bidirectional relationship, only from jpa perspective you will see information about inverse side of relationship is you do find by Document
	@OneToOne(mappedBy = "document", cascade = CascadeType.ALL)
	private Person person;
}
