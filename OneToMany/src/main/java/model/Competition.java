package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Competition {

	@Id
	@TableGenerator(name = "Competition_Gen",
			table = "one_to_many_id_gen",
			pkColumnName = "GEN_NAME",
			valueColumnName = "GEN_VALUE")
	@GeneratedValue(generator = "Competition_Gen")
	@Column(name = "competitionId")
	private Integer competitionId;

	private String competitionName;

	@Column
	private String competitionDescription;
}
