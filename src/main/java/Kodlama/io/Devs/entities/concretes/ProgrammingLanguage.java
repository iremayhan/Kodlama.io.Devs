package Kodlama.io.Devs.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="programmingLanguages")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammingLanguage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="programmingLanugageId")
	int id;
	
	@Column(name="programmingLanguageName")
	String name;
	
	@OneToMany(mappedBy="programmingLanguage",  fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	List<ProgrammingTechnology> programmingTechnologies;

	
}
