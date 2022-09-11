package code.microsystem.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import code.microsystem.entity.UserDoc;

public interface DocRepository extends JpaRepository<UserDoc, Long>{
	Optional<UserDoc> findByName(String fileName);

}
