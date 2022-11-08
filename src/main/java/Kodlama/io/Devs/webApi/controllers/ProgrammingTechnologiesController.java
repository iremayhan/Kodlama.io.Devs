package Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import Kodlama.io.Devs.business.abstracts.ProgrammingTechnologyService;
import Kodlama.io.Devs.business.requests.programmingTechnologyRequest.CreateProgrammingTechnologyRequest;
import Kodlama.io.Devs.business.requests.programmingTechnologyRequest.DeleteProgrammingTechnologyRequest;
import Kodlama.io.Devs.business.requests.programmingTechnologyRequest.UpdateProgrammingTechnologyRequest;
import Kodlama.io.Devs.business.responses.programmingTechnologyResponse.GetAllProgrammingTechnologyResponse;
import Kodlama.io.Devs.business.responses.programmingTechnologyResponse.GetByIdProgrammingTechnologyResponse;

@RestController
@RequestMapping("/api/programmingtechnologies")
public class ProgrammingTechnologiesController {
	private ProgrammingTechnologyService programmingTechnologyService;
	
	@Autowired
	public ProgrammingTechnologiesController(ProgrammingTechnologyService programmingTechnologyService) {
		this.programmingTechnologyService = programmingTechnologyService;
	}
	
	@PostMapping("/add")
	public void add(@RequestBody CreateProgrammingTechnologyRequest createProgrammingTechnologyRequest) {
		programmingTechnologyService.add(createProgrammingTechnologyRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestBody DeleteProgrammingTechnologyRequest deleteProgrammingTechnologyRequest) {
		programmingTechnologyService.delete(deleteProgrammingTechnologyRequest);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody UpdateProgrammingTechnologyRequest updateProgrammingTechnologyRequest) {
		programmingTechnologyService.update(updateProgrammingTechnologyRequest);
	}
	
	@GetMapping("/getall")
	public List<GetAllProgrammingTechnologyResponse> getAll() {
		return programmingTechnologyService.getAll();
	}
	
	@GetMapping("/getbyid")
	public GetByIdProgrammingTechnologyResponse getById(@RequestParam int id) {
		return programmingTechnologyService.getById(id);
	}
	
}
