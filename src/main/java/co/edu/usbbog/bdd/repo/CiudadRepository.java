package co.edu.usbbog.bdd.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.usbbog.bdd.model.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Long> {
	
}