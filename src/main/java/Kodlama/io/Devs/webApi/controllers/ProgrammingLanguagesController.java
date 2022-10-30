package Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programminglanguages")
public class ProgrammingLanguagesController {
	private ProgrammingLanguageService programmingLanguageService;

	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}

	@PostMapping("/add")
	public void add(@RequestBody ProgrammingLanguage programmingLanguage) {
		programmingLanguageService.add(programmingLanguage);
	}

	@DeleteMapping("/delete")
	public void delete(int id) {
		programmingLanguageService.delete(id);
	}

	@PutMapping("/update")
	public void update(@RequestBody ProgrammingLanguage programmingLanguage) {
		programmingLanguageService.update(programmingLanguage);
	}

	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguageService.getAll();

	}

	@GetMapping("/getbyid")
	public ProgrammingLanguage getById(int id) {
		return programmingLanguageService.getById(id);
	}

}
