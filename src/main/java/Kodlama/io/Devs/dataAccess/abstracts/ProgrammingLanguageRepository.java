package Kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlama.io.Devs.business.requests.programmingLanguageRequest.CreateProgrammingLanguageRequest;
import Kodlama.io.Devs.business.requests.programmingLanguageRequest.DeleteProgrammingLanguageRequest;
import Kodlama.io.Devs.business.requests.programmingLanguageRequest.UpdateProgrammingLanguageRequest;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Integer> {
	List<ProgrammingLanguage> findAllById(int id);

	List<ProgrammingLanguage> findAllByName(String name);

	ProgrammingLanguage findById(int id);

	ProgrammingLanguage findByName(String name);

}
