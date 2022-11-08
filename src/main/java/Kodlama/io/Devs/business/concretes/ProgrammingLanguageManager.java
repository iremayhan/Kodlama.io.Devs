package Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.business.requests.programmingLanguageRequest.CreateProgrammingLanguageRequest;
import Kodlama.io.Devs.business.requests.programmingLanguageRequest.DeleteProgrammingLanguageRequest;
import Kodlama.io.Devs.business.requests.programmingLanguageRequest.UpdateProgrammingLanguageRequest;
import Kodlama.io.Devs.business.responses.programmingLanguageResponse.GetAllProgrammingLanguageResponse;
import Kodlama.io.Devs.business.responses.programmingLanguageResponse.GetByIdProgrammingLanguageResponse;
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
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {

		if (createProgrammingLanguageRequest.getName().isBlank() || createProgrammingLanguageRequest.getName().isEmpty()) {
			System.out.println("Program isimleri en az bir karakter içermek zorundadır.");
		} else {
			for (ProgrammingLanguage _programmingLanguage : programmingLanguageRepository.findAll()) {

				if (_programmingLanguage.getName().equalsIgnoreCase(createProgrammingLanguageRequest.getName())) {
					System.out.println(" Aynı isimde başka bir program mevcut, ekleme yapılamıyor. "
							+ createProgrammingLanguageRequest.getName());
				}
			}
		}
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		programmingLanguage.setName(createProgrammingLanguageRequest.getName());
		
		this.programmingLanguageRepository.save(programmingLanguage);
		System.out.println("Program ekleme başarılı: " + createProgrammingLanguageRequest.getName());
	}

	@Override
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {

		if (updateProgrammingLanguageRequest.getName().isBlank() || updateProgrammingLanguageRequest.getName().isEmpty()) {
			System.out.println("Program isimleri en az bir karakter içermek zorundadır.");
		} else {
			for (ProgrammingLanguage _programmingLanguage : programmingLanguageRepository.findAll()) {

				if (_programmingLanguage.getName().equalsIgnoreCase(updateProgrammingLanguageRequest.getName())) {
					System.out.println(" Bu isimde bir program zaten var: " + updateProgrammingLanguageRequest.getName());
				}
			}
		}

		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		programmingLanguage.setId(updateProgrammingLanguageRequest.getId());
		programmingLanguage.setName(updateProgrammingLanguageRequest.getName());
		
		
		this.programmingLanguageRepository.save(programmingLanguage);
		System.out.println("Güncelleme başarılı! Güncellenmiş isim: " + updateProgrammingLanguageRequest.getName());
	}


	@Override
	public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) {
		for(ProgrammingLanguage programmingLanguage : programmingLanguageRepository.findAll()) {
			if(programmingLanguage.getName() != deleteProgrammingLanguageRequest.getName()) {
				System.out.println("Bu isimde bir program bulunmuyor.");
			}
		}
		
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		programmingLanguage.setName(deleteProgrammingLanguageRequest.getName());
		
		programmingLanguageRepository.delete(programmingLanguage);
	}

	@Override
	public List<GetAllProgrammingLanguageResponse> getAll() {
		List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();
		List<GetAllProgrammingLanguageResponse> programmingLanguagesResponse = new ArrayList<GetAllProgrammingLanguageResponse>();
		
		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
			GetAllProgrammingLanguageResponse responseItem = new GetAllProgrammingLanguageResponse();
			responseItem.setId(programmingLanguage.getId());
			responseItem.setName(programmingLanguage.getName());
			
			programmingLanguagesResponse.add(responseItem);
			
		}
		return programmingLanguagesResponse;
	}

	@Override
	public GetByIdProgrammingLanguageResponse getById(int id) {
		
		ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(id);
		GetByIdProgrammingLanguageResponse getByIdProgrammingLanguageResponse = new GetByIdProgrammingLanguageResponse();
		
		getByIdProgrammingLanguageResponse.setId(programmingLanguage.getId());
		getByIdProgrammingLanguageResponse.setName(programmingLanguage.getName());
		
		return getByIdProgrammingLanguageResponse;
		
	}




}
