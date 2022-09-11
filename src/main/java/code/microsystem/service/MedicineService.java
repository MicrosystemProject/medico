package code.microsystem.service;


import java.util.Optional;

import code.microsystem.entity.Medicine;

public interface MedicineService {
	
	public Medicine save(Medicine medicine);
	
	public Medicine search(String medicinename);
	
	public Medicine searchmanufacturename(String manufacturename);
	
	public Medicine searchmedicineid(int mid);
	
	public Medicine searchmedicinetype(String medicineType);

	public Optional<Medicine> findNewMed(int mid);
	
	



}
