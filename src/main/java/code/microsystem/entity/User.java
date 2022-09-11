package code.microsystem.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.http.ResponseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USER_INFO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue
	private int id;
	private String userName;
	private String userEmail;
	private String userContactNo;
	private String userAddress;
	private String userPassword;
	private String status;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "uid")
	private List<UserDoc> doc;
	
	


}
