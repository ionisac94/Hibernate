package model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
@Data
public class Phone {

	@Id
	@TableGenerator(name = "PHONE_GEN",
			table = "ID_GEN",
			pkColumnName = "GEN_NAME",
			valueColumnName = "GEN_VALUE")
	@GeneratedValue(generator = "PHONE_GEN")
	private Integer id;

	private String phoneNumber;

	public Phone(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
