package code.microsystem.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import code.microsystem.dao.NgoRepository;
import code.microsystem.entity.Ngo;

@Service
public class NgoServiceImp implements NgoService {

	@Autowired
	private NgoRepository ngoRepository;

	private final static Logger logger = LoggerFactory.getLogger(NgoServiceImp.class);

	@Override
	@Transactional
	public Ngo save(Ngo ngo) {

		return ngoRepository.save(ngo);
	}

//	@Override
//	@Transactional
//	public Ngo update(Ngo ngo) {
//
//		return ngoRepository.save(ngo);
//	}

	@Override
	public List<Ngo> getAllNgo() {

		return ngoRepository.findAll();
	}

	public ResponseEntity<Ngo> updateNgoPartially(int id, String password) {
		logger.info(" Call method NgoServiceImpl:updateNgoPartially");
		try {
			Ngo ngo = ngoRepository.findById(id).get();
			ngo.setPassword(password);
			logger.info(" End method NgoServiceImpl:updateNgoPartially");
			return new ResponseEntity<Ngo>(ngoRepository.save(ngo), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	@Transactional
	public int deleteById(int nid) {
		ngoRepository.deleteById(nid);
		return nid;

	}

	@Override
	public Optional<Ngo> findMedId(int id) {

		return ngoRepository.findById(id);
	}

	@Override
	public ResponseEntity<Ngo> updateNewNgo(Ngo ngo) {

		return new ResponseEntity<Ngo>(ngoRepository.save(ngo), HttpStatus.OK);
	}

}
