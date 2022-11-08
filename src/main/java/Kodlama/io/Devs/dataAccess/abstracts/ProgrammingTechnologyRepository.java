package Kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import Kodlama.io.Devs.business.requests.programmingLanguageRequest.UpdateProgrammingLanguageRequest;
import Kodlama.io.Devs.business.requests.programmingTechnologyRequest.CreateProgrammingTechnologyRequest;
import Kodlama.io.Devs.business.requests.programmingTechnologyRequest.DeleteProgrammingTechnologyRequest;
import Kodlama.io.Devs.business.responses.programmingTechnologyResponse.GetAllProgrammingTechnologyResponse;
import Kodlama.io.Devs.entities.concretes.ProgrammingTechnology;

public interface ProgrammingTechnologyRepository extends JpaRepository<ProgrammingTechnology, Integer> {
	List<ProgrammingTechnology> findAllById(int id);

	List<ProgrammingTechnology> findAllByName(String name);

	ProgrammingTechnology findById(int id);

	ProgrammingTechnology findByName(String name);

	List<ProgrammingTechnology> findAllByProgrammingLanguage_Name(@Param("name") String name);

	ProgrammingTechnology findByProgrammingLanguage_Name(@Param("name") String name);

}
