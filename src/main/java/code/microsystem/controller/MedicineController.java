package code.microsystem.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import code.microsystem.entity.Medicine;
import code.microsystem.entity.Ngo;
import code.microsystem.exeption.ResourceNotFoundException;
import code.microsystem.service.MedicineService;

@RestController
@RequestMapping("/api/v1")
public class MedicineController {

	@Autowired
	public MedicineService medicineService;

	@PostMapping("/newmedicine")
	public ResponseEntity<Medicine> saveNewMedicine(@RequestBody Medicine medicine) {
		Optional<Medicine> med = Optional.ofNullable(Optional.of(medicineService.save(medicine))
				.orElseThrow(() -> new ResourceNotFoundException("Medicine not found with this name :" + medicine)));

		return ResponseEntity.ok().body(medicine);

	}

	@GetMapping("/newmedicinename")
	public ResponseEntity<Medicine> searchNewMedicine(@RequestParam String medicineName) {
		Optional<Medicine> med = Optional.ofNullable(Optional.of(medicineService.search(medicineName)).orElseThrow(
				() -> new ResourceNotFoundException("Medicine not found with this name :" + medicineName)));
		return ResponseEntity.ok().build();

	}

	@GetMapping("/newmanufacturename")
	public Medicine searchNewMedicinemanufacture(@RequestParam String manufactureName) {

		Optional<Medicine> med = Optional.of(medicineService.searchmanufacturename(manufactureName));
		// return medicineService.searchmanufacturename(manufactureName)
		return med.orElseThrow(
				() -> new ResourceNotFoundException("Medicine not found with this name :" + manufactureName));

	}

	@GetMapping("/newmedicineid")
	public ResponseEntity<Medicine> searchNewMedicineid(@RequestParam int mid) {
		Optional<Medicine> med = Optional.ofNullable(Optional.of(medicineService.searchmedicineid(mid))
				.orElseThrow(() -> new ResourceNotFoundException("Medicine not found with id :" + mid)));
		return ResponseEntity.ok().build();

	}

	@GetMapping("/newmedicinetype")
	public ResponseEntity<Medicine> searchNewMedicinetype(@RequestParam String medicineType) {
		Optional<Medicine> med = Optional.ofNullable(Optional.of(medicineService.searchmedicinetype(medicineType))
				.orElseThrow(() -> new ResourceNotFoundException("Medicine not found with Type :" + medicineType)));
		return ResponseEntity.ok().build();

	}



}
