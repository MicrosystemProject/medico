package code.microsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import code.microsystem.entity.Ngo;


public interface NgoService {
	
	
	public ResponseEntity<Ngo> updateNewNgo(Ngo ngo);

	
	public int deleteById(int nid);
	
	public List<Ngo> getAllNgo();

	public ResponseEntity<Ngo> updateNgoPartially(int nid, String password);

	public Optional<Ngo> findMedId(int id);


	public Object save(Ngo ngo);


	



	
	
	
	

}
