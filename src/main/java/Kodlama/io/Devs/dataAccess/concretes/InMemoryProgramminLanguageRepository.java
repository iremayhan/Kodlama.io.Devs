package Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Repository
public class InMemoryProgramminLanguageRepository implements ProgrammingLanguageRepository{
	
	List<ProgrammingLanguage> programmingLanguages;
	
	public InMemoryProgramminLanguageRepository() {
		programmingLanguages = new ArrayList<ProgrammingLanguage>();
		
		programmingLanguages.add(new ProgrammingLanguage(1, "C#"));
		programmingLanguages.add(new ProgrammingLanguage(2, "Java"));
		programmingLanguages.add(new ProgrammingLanguage(3, "Python"));
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) {
		int lastId = programmingLanguages.get(programmingLanguages.size()-1).getId();
		programmingLanguage.setId(lastId + 1);
		programmingLanguages.add(programmingLanguage);
		
	}

	@Override
	public void delete(int id) {
		ProgrammingLanguage toDelete = getById(id);
		if(toDelete != null) {
			programmingLanguages.remove(toDelete);
			return;
		}	
		
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) {
		for(ProgrammingLanguage language : programmingLanguages) {
			if(language.getId() == programmingLanguage.getId()) {
				language.setLanguageName(programmingLanguage.getLanguageName());
				break;
			}
		}
		programmingLanguages.get(programmingLanguage.getId());
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguages;
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		return programmingLanguages.get(id);
	}

}
