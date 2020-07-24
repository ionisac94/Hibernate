package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
//@Data
@Builder
@Entity(name = "User")
public class User {

	@Id
	@TableGenerator(name = "User_Gen",
			table = "one_to_many2_id_gen",
			pkColumnName = "GEN_NAME",
			valueColumnName = "GEN_VALUE")
	@GeneratedValue(generator = "User_Gen")
	private Integer userId;

	@Column(columnDefinition = "VARCHAR(30)")
	private String firstName;

	@Column
	private String lastName;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "user")
//	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private List<UserCompetition> userCompetitions;

	@Override
	public String toString() {
		return "User{" +
				"userId=" + userId +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				'}';
	}
}
