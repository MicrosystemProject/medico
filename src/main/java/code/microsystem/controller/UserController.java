package code.microsystem.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import code.microsystem.entity.Ngo;
import code.microsystem.entity.User;
import code.microsystem.exeption.ResourceNotFoundException;
import code.microsystem.service.StorageService;
import code.microsystem.service.UserService;

@RestController
@RequestMapping("/user/api")
public class UserController {

	@Autowired
	public UserService userService;

	@Autowired
	private StorageService service;

	@PostMapping("/doc")

	public ResponseEntity<?> uploadImage(@RequestParam("doc") MultipartFile file) throws IOException {
		String uploadImage = service.uploadImage(file);
		return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
	}

	@GetMapping("/{fileName}")
	public ResponseEntity<?> downloadImage(@PathVariable String fileName) {
		byte[] imageData = service.downloadImage(fileName);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("plane/text")).body(imageData);

	}

	@PostMapping("/newUser")
	public User saveNewUSer(@RequestBody User user) {
		return userService.addNewUser(user);

	}
//	@PutMapping("/newUser")
//	public User updateNewUSer(@RequestBody User  user) {
//		return userService.save(user);
//		
//	}
//	@RequestMapping("/newUser")
//	public List<User> getAlluser(){
//		return userService.getAllUser();
//		
//		
//	}
//	@PatchMapping("/newUser/{uid}/{password}")
//	public ResponseEntity<User> updateUserPartially(@PathVariable int uid, @PathVariable String password ){
//		return userService.updateUserPartially(uid,password);
//		
//	}
//	@DeleteMapping("/newUser/{uid}")
//	public int delete(@PathVariable int uid) {
//		return userService.deleteById(uid);

	@PatchMapping("/updateUser/{id}/{status}")
	public ResponseEntity<User> newupdateUserPartially(@PathVariable int id, @PathVariable String status) {
		Optional<ResponseEntity<User>> user = Optional.of(userService.newupdateUserPartially(id, status));

		return user.orElseThrow(() -> new ResourceNotFoundException("User information  :" + id, status));

	}

}
