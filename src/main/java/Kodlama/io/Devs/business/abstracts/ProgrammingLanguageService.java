package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {

	void add(ProgrammingLanguage programmingLanguage);

	void update(ProgrammingLanguage programmingLanguage);

	void delete(int id);

	List<ProgrammingLanguage> getAll();

	ProgrammingLanguage getById(int id);
}
