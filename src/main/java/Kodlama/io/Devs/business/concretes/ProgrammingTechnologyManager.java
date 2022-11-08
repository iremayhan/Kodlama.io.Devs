package Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.ProgrammingTechnologyService;
import Kodlama.io.Devs.business.requests.programmingTechnologyRequest.CreateProgrammingTechnologyRequest;
import Kodlama.io.Devs.business.requests.programmingTechnologyRequest.DeleteProgrammingTechnologyRequest;
import Kodlama.io.Devs.business.requests.programmingTechnologyRequest.UpdateProgrammingTechnologyRequest;
import Kodlama.io.Devs.business.responses.programmingLanguageResponse.GetAllProgrammingLanguageResponse;
import Kodlama.io.Devs.business.responses.programmingLanguageResponse.GetByIdProgrammingLanguageResponse;
import Kodlama.io.Devs.business.responses.programmingTechnologyResponse.GetAllProgrammingTechnologyResponse;
import Kodlama.io.Devs.business.responses.programmingTechnologyResponse.GetByIdProgrammingTechnologyResponse;
import Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.dataAccess.abstracts.ProgrammingTechnologyRepository;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import Kodlama.io.Devs.entities.concretes.ProgrammingTechnology;

@Service
public class ProgrammingTechnologyManager implements ProgrammingTechnologyService {
	@Autowired
	private ProgrammingTechnologyRepository programmingTechnologyRepository;
	@Autowired
	private ProgrammingLanguageRepository programmingLanguageRepository;
	
	@Autowired
	public ProgrammingTechnologyManager(ProgrammingTechnologyRepository programmingTechnologyRepository, ProgrammingLanguageRepository programmingLanguageRepository) {
		super();
		this.programmingTechnologyRepository = programmingTechnologyRepository;
		this.programmingLanguageRepository=programmingLanguageRepository;
	}

	@Override
	public void add(CreateProgrammingTechnologyRequest createProgrammingTechnologyRequest) {
		if (createProgrammingTechnologyRequest.getName().isBlank() || createProgrammingTechnologyRequest.getName().isEmpty()) {
			System.out.println("Teknoloji isimleri en az bir karakter içermek zorundadır.");
		} else {
			for (ProgrammingTechnology _programmingTechnology : programmingTechnologyRepository.findAll()) {

				if (_programmingTechnology.getName().equalsIgnoreCase(createProgrammingTechnologyRequest.getName())) {
					System.out.println(" Aynı isimde başka bir teknoloji mevcut, ekleme yapılamıyor. "
							+ createProgrammingTechnologyRequest.getName());
				}
			}
		}
		ProgrammingTechnology programmingTechnology = new ProgrammingTechnology();
		ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(createProgrammingTechnologyRequest.getProgrammingLanguageId());
		programmingTechnology.setName(createProgrammingTechnologyRequest.getName());
		programmingTechnology.setProgrammingLanguage(programmingLanguage);
		
		this.programmingTechnologyRepository.save(programmingTechnology);
		System.out.println("Teknoloji ekleme başarılı: " + createProgrammingTechnologyRequest.getName());		
	}

	@Override
	public void delete(DeleteProgrammingTechnologyRequest deleteProgrammingTechnologyRequest) {
		for(ProgrammingTechnology programmingTechnology : programmingTechnologyRepository.findAll()) {
			if(programmingTechnology.getName() != deleteProgrammingTechnologyRequest.getName()) {
				System.out.println("Bu isimde bir teknoloji bulunmuyor.");
			}
		}
		
		ProgrammingTechnology programmingTechnology = new ProgrammingTechnology();
		programmingTechnology.setName(deleteProgrammingTechnologyRequest.getName());
		
		programmingTechnologyRepository.delete(programmingTechnology);		
	}

	@Override
	public void update(UpdateProgrammingTechnologyRequest updateProgrammingTechnologyRequest) {
		if (updateProgrammingTechnologyRequest.getName().isBlank() || updateProgrammingTechnologyRequest.getName().isEmpty()) {
			System.out.println("Teknoloji isimleri en az bir karakter içermek zorundadır.");
		} else {
			for (ProgrammingTechnology _programmingTechnology : programmingTechnologyRepository.findAll()) {

				if (_programmingTechnology.getName().equalsIgnoreCase(updateProgrammingTechnologyRequest.getName())) {
					System.out.println(" Bu isimde bir teknoloji zaten var: " + updateProgrammingTechnologyRequest.getName());
				}
			}
		}

		ProgrammingTechnology programmingTechnology = new ProgrammingTechnology();
		ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(updateProgrammingTechnologyRequest.getProgrammingLanguageId());
		programmingTechnology.setName(updateProgrammingTechnologyRequest.getName());
		programmingTechnology.setId(updateProgrammingTechnologyRequest.getId());
		programmingTechnology.setProgrammingLanguage(programmingLanguage);
		
		
		this.programmingTechnologyRepository.save(programmingTechnology);
		System.out.println("Güncelleme başarılı! Güncellenmiş isim: " + updateProgrammingTechnologyRequest.getName());
	}
		

	@Override
	public List<GetAllProgrammingTechnologyResponse> getAll() {
		List<ProgrammingTechnology> programmingTechnologies = programmingTechnologyRepository.findAll();
		List<GetAllProgrammingTechnologyResponse> programmingTechnologiesResponse = new ArrayList<GetAllProgrammingTechnologyResponse>();
		
		for (ProgrammingTechnology programmingTechnology : programmingTechnologies) {
			GetAllProgrammingTechnologyResponse responseItem = new GetAllProgrammingTechnologyResponse();
			responseItem.setId(programmingTechnology.getId());
			responseItem.setName(programmingTechnology.getName());
			responseItem.setProgrammingLanguageId(programmingTechnology.getProgrammingLanguage().getId());
			responseItem.setProgrammingLanguageName(programmingTechnology.getProgrammingLanguage().getName());
			
			programmingTechnologiesResponse.add(responseItem);
			
		}
		return programmingTechnologiesResponse;		
	}

	@Override
	public GetByIdProgrammingTechnologyResponse getById(int id) {
		
		ProgrammingTechnology programmingTechnology= programmingTechnologyRepository.findById(id);
		GetByIdProgrammingTechnologyResponse getByIdProgrammingTechnologyResponse = new GetByIdProgrammingTechnologyResponse();
		
		getByIdProgrammingTechnologyResponse.setId(programmingTechnology.getId());
		getByIdProgrammingTechnologyResponse.setName(programmingTechnology.getName());
		getByIdProgrammingTechnologyResponse.setProgrammingLanguageId(programmingTechnology.getProgrammingLanguage().getId());
		getByIdProgrammingTechnologyResponse.setProgrammingLanguageName(programmingTechnology.getProgrammingLanguage().getName());
		
		return getByIdProgrammingTechnologyResponse;
	}
	
	
}
