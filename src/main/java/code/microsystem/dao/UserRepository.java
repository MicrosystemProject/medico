package code.microsystem.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import code.microsystem.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	

}
