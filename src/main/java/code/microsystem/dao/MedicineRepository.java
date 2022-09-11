package code.microsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import code.microsystem.entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Integer> {

	@Query("SELECT m from Medicine m WHERE m.medicineName LIKE CONCAT('%',:medicinename, '%')")
	public Medicine search(String medicinename);

	@Query("SELECT m from Medicine m WHERE m.manufactureName LIKE CONCAT('%',:manufacturename, '%')")
	public Medicine searchmanufacturename(String manufacturename);

	@Query("SELECT m from Medicine m WHERE m.mid LIKE CONCAT('%',:mid, '%')")
	public Medicine searchmedicineid(int mid);
	
	@Query("SELECT m from Medicine m WHERE m.medicineType LIKE CONCAT('%',:medicineType, '%')")
	public Medicine searchmedicinetype(String medicineType);
	
	
}

