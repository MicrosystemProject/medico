package code.microsystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "FEEDBACK_INFORMATION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
	@Id
	@GeneratedValue
	private int fid;
	private String feedbackName;
	private String feedbackEmail;
	private String feedbackContactNo;
	private String feedbackSuggesation;

}
