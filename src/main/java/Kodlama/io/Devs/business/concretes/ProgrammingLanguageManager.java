package Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepository programmingLanguageRepository;

	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) {

		if (programmingLanguage.getLanguageName().isBlank() || programmingLanguage.getLanguageName().isEmpty()) {
			System.out.println("Program isimleri en az bir karakter içermek zorundadır.");
		} else {
			for (ProgrammingLanguage _programmingLanguage : programmingLanguageRepository.getAll()) {

				if (_programmingLanguage.getLanguageName().equalsIgnoreCase(programmingLanguage.getLanguageName())) {
					System.out.println(" Aynı isimde başka bir program mevcut, ekleme yapılamıyor. "
							+ programmingLanguage.getLanguageName());
				}
			}
		}

		programmingLanguageRepository.add(programmingLanguage);
		System.out.println("Program ekleme başarılı: " + programmingLanguage.getLanguageName());
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) {

		if (programmingLanguage.getLanguageName().isBlank() || programmingLanguage.getLanguageName().isEmpty()) {
			System.out.println("Program isimleri en az bir karakter içermek zorundadır.");
		} else {
			for (ProgrammingLanguage _programmingLanguage : programmingLanguageRepository.getAll()) {

				if (_programmingLanguage.getLanguageName().equalsIgnoreCase(programmingLanguage.getLanguageName())) {
					System.out.println(" Bu isimde bir program zaten var: " + programmingLanguage.getLanguageName());
				}
			}
		}

		programmingLanguageRepository.update(programmingLanguage);
		System.out.println("Güncelleme başarılı! Güncellenmiş isim: " + programmingLanguage.getLanguageName());
	}

	@Override
	public void delete(int id) {
		programmingLanguageRepository.delete(id);
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguageRepository.getAll();
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		return programmingLanguageRepository.getById(id);
	}

}
