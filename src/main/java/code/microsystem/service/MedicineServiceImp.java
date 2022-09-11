package code.microsystem.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import code.microsystem.dao.MedicineRepository;

import code.microsystem.entity.Medicine;

@Service
public class MedicineServiceImp implements MedicineService {

	@Autowired
	private MedicineRepository medicineRepository;

	private final static Logger logger = LoggerFactory.getLogger(MedicineServiceImp.class);

	@Override
	@Transactional
	public Medicine save(Medicine medicine) {
		logger.info("call method donatemedicineImp:save medicine");
		logger.info(" End method medicineServiceImpl:");
		return medicineRepository.save(medicine);

	}

	@Override
	@Transactional
	public Medicine search(String medicinename) {
		Medicine med = medicineRepository.search(medicinename);
		logger.info("Medicinf Details :" + med);
		return med;
	}

	@Override
	@Transactional
	public Medicine searchmanufacturename(String manufacturename) {
		Medicine med = medicineRepository.searchmanufacturename(manufacturename);
		logger.info("Medicine Details:" + med);

		return med;
	}

	@Override
	@Transactional
	public Medicine searchmedicineid(int mid) {
		Medicine med = medicineRepository.searchmedicineid(mid);
		logger.info("Medicine Details:" + med);

		return med;
	}

	@Override
	@Transactional
	public Medicine searchmedicinetype(String medicineType) {
		Medicine med = medicineRepository.searchmedicinetype(medicineType);
		logger.info("Medicine Detail:" + med);
		return med;
	}

	@Override
	public Optional<Medicine> findNewMed(int mid) {

		return medicineRepository.findById(mid);
	}

	
}
