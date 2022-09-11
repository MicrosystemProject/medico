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
@Table(name = "Medicine_Info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medicine {
	@Id
	@GeneratedValue
	private int mid;
	private String medicineName;
	private String manufactureName;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
	private Date ManufactureDt;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
	private Date ExpiryDt;

	private int medicineRate;
	private int medicineQuntity;
	private String medicineType;
	
	

}
