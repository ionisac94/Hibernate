package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "UserCompetition")
public class UserCompetition {

	@Id
	@TableGenerator(name = "Competition_Gen",
			table = "one_to_many2_id_gen",
			pkColumnName = "GEN_NAME",
			valueColumnName = "GEN_VALUE")
	@GeneratedValue(generator = "Competition_Gen")
	@Column(name = "competitionId")
	private Integer competitionId;

	private String competitionName;

	@Column
	private String competitionDescription;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
}
