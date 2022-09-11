package code.microsystem.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import code.microsystem.entity.Ngo;
import code.microsystem.entity.User;

public interface UserService {
	
	public User addNewUser(User user);

	public Optional<User> findUserId(int id);

	public Object save(Optional<User> user);

	public Object findById(int id);
	public ResponseEntity<User> newupdateUserPartially(int id,String status);

	
	
//	public User update(User user);
//	
//	public int deleteById(int uid);
//	
//	public List<User> getAllUser();
//	
//	public ResponseEntity<User> updateUserPartially(int uid, String password);
//	
	
	

}
