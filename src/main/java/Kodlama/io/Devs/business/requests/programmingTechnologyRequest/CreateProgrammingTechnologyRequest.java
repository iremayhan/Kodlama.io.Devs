package Kodlama.io.Devs.business.requests.programmingTechnologyRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProgrammingTechnologyRequest {
	private String name;
	private int programmingLanguageId;
}
