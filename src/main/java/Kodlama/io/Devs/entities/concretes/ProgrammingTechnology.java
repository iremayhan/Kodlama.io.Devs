package Kodlama.io.Devs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="programmingTechnologies")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammingTechnology {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="programmingTechnologiesId")
	private int id;
	
	@Column(name="programmingTechnologiesName")
	private String name;
	
	@ManyToOne()
	@JoinColumn(name="programmingLanguageId")
	private ProgrammingLanguage programmingLanguage;
	

}
