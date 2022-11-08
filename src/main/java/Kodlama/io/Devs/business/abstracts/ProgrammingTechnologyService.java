package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.business.requests.programmingTechnologyRequest.CreateProgrammingTechnologyRequest;
import Kodlama.io.Devs.business.requests.programmingTechnologyRequest.DeleteProgrammingTechnologyRequest;
import Kodlama.io.Devs.business.requests.programmingTechnologyRequest.UpdateProgrammingTechnologyRequest;
import Kodlama.io.Devs.business.responses.programmingTechnologyResponse.GetAllProgrammingTechnologyResponse;
import Kodlama.io.Devs.business.responses.programmingTechnologyResponse.GetByIdProgrammingTechnologyResponse;

public interface ProgrammingTechnologyService {
	void add(CreateProgrammingTechnologyRequest createProgrammingTechnologyRequest);
	void delete(DeleteProgrammingTechnologyRequest deleteProgrammingTechnologyRequest);
	void update(UpdateProgrammingTechnologyRequest updateProgrammingTechnologyRequest);
	
	List<GetAllProgrammingTechnologyResponse> getAll();
	GetByIdProgrammingTechnologyResponse getById(int id);
}
