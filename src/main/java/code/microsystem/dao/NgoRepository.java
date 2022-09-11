package code.microsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import code.microsystem.entity.Ngo;

public interface NgoRepository extends JpaRepository<Ngo, Integer> {

}
