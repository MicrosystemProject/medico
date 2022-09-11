package code.microsystem.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import code.microsystem.dao.UserRepository;
import code.microsystem.entity.Ngo;
import code.microsystem.entity.User;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public User addNewUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public Optional<User> findUserId(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Object save(Optional<User> user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<User> newupdateUserPartially(int id, String status) {
//		logger.info(" Call method NgoServiceImpl:updateNgoPartially");
		try {
			User user = userRepository.findById(id).get();
			user.setStatus(status);
//			logger.info(" End method NgoServiceImpl:updateNgoPartially");
			return new ResponseEntity<User>(userRepository.save(user), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}

	
	
		

	

}
