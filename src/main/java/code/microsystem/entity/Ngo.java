package code.microsystem.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "NGO_INFO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ngo {
	@Id
	@GeneratedValue
	private int id;
	private String ngoName;
	private String ngoEmail;
	private String ngoContactNo;
	private String ngoAddress;
	private String password;
	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "MM-dd-yyyy")
	private Date ngoCreatedDt;

	

}
