package code.microsystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import code.microsystem.dao.NgoRepository;
import code.microsystem.entity.Ngo;
import code.microsystem.exeption.ResourceNotFoundException;
import code.microsystem.service.NgoService;
import code.microsystem.service.NgoServiceImp;

@RestController
@RequestMapping("/api")
public class AdminController {
	@Autowired
	private NgoService ngoService;

//	@PostMapping("/newNgo")
//	public ResponseEntity<Ngo> saveNewNGo(@RequestBody Ngo ngo) {
//		Optional<Ngo> Ngo = Optional.ofNullable(Optional.of(ngoService.save(ngo))
//				.orElseThrow(() -> new ResourceNotFoundException("Ngo Information not Save :" + ngo)));
//		return ResponseEntity.ok().body(ngo);
//
//	}

	@PutMapping("/newNgo/{id}")
	public ResponseEntity<Ngo> updateNewNGo(@PathVariable("id")int id,@RequestBody Ngo ngo) {
		Ngo existingNewNgo = Optional.of(ngoService.findMedId(id))
				.orElseThrow(() -> new ResourceNotFoundException("Ngo not found with id :" + id)).get();
		existingNewNgo.setId(ngo.getId());
		existingNewNgo.setNgoAddress(ngo.getNgoAddress());
		existingNewNgo.setNgoContactNo(ngo.getNgoContactNo());
		existingNewNgo.setNgoCreatedDt(ngo.getNgoCreatedDt());
		existingNewNgo.setNgoEmail(ngo.getNgoEmail());
		existingNewNgo.setNgoName(ngo.getNgoName());
		existingNewNgo.setPassword(ngo.getPassword());
		ngoService.save(ngo);
		
		return ResponseEntity.ok(ngo);
		

		
		
		
	}
		
		
	
//	@PutMapping("/newNgo/{id}")
//	public Optional<Ngo> updateNewNgo(@PathVariable("id") int id, @RequestBody Ngo ngo) {
//		Ngo existingNewNgo = ngoService.findMedId(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Ngo not found with id :" + id));
//		existingNewNgo.setId(ngo.getId());
//		existingNewNgo.setNgoAddress(ngo.getNgoAddress());
//		existingNewNgo.setNgoContactNo(ngo.getNgoContactNo());
//		existingNewNgo.setNgoCreatedDt(ngo.getNgoCreatedDt());
//		existingNewNgo.setNgoEmail(ngo.getNgoEmail());
//		existingNewNgo.setNgoName(ngo.getNgoName());
//		existingNewNgo.setPassword(ngo.getPassword());
//		return Optional.ofNullable(this.ngoService.save(existingNewNgo));
//
//	}

	@RequestMapping("/newNgo")
	public List<Ngo> getAllngo() {
		return ngoService.getAllNgo();

	}

	@PatchMapping("/newNgo/{nid}/{password}")
	public ResponseEntity<Ngo> updateNgoPartially(@PathVariable int nid, @PathVariable String password) {
		Optional<ResponseEntity<Ngo>> Ngo = Optional.of(ngoService.updateNgoPartially(nid, password));

		return Ngo.orElseThrow(() -> new ResourceNotFoundException("Ngo information  :" + nid, password));

	}

	@DeleteMapping("/newNgo/{id}")
	public ResponseEntity<Ngo> deleteNgo(@PathVariable("id") int id) {
		Optional<Integer> Ngo = Optional.ofNullable(Optional.of(ngoService.deleteById(id))
				.orElseThrow(() -> new ResourceNotFoundException("Ngo Information :" + id)));
		return ResponseEntity.ok().build();

	}

}
