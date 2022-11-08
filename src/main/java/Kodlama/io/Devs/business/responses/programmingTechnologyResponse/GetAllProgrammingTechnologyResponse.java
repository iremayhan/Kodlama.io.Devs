package Kodlama.io.Devs.business.responses.programmingTechnologyResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProgrammingTechnologyResponse {
	private int id;
	private int programmingLanguageId;
	private String name;
	private String programmingLanguageName;
}
