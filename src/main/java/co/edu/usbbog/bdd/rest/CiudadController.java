package co.edu.usbbog.bdd.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.usbbog.bdd.model.Ciudad;
import co.edu.usbbog.bdd.repo.CiudadRepository;



@RestController
@RequestMapping("/ciudad")
public class CiudadController {

	@Autowired
	private CiudadRepository ic;
	

	@PostMapping("/create")
	public void insertCiudad(@RequestBody Ciudad c) {
		ic.save(c);
	}
	
	@GetMapping("/all")
	public List<Ciudad>findAllCiudades() {
		List<Ciudad> l = ic.findAll();
		if (l.isEmpty() || l.equals(null)) {
			throw new RuntimeException("No hay ciudades registradas");
		} else {
			return l;
		}
	}
	
	@GetMapping("/find/{id}")
	public Optional<Ciudad> findCiudad(@PathVariable("id") long id) {
		Optional<Ciudad> ci =  ic.findById(id);
		if (!ci.equals(null)) {
			return ci;
		} else {
			throw new RuntimeException("Ciudad identificada con el ID: "+id+" no encontrado");
		}
	}
	
	@GetMapping("/count")
	public long coundCiudades() {
		long c = ic.count();
		if (c != 0) {
			return c;
		} else {
            throw new RuntimeException("No hay ciudades registradas");
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteCiudad(@PathVariable("id") long id) {
		Optional<Ciudad> c = ic.findById(id);
		if (c.equals(null)) {
            throw new RuntimeException("Ciudad identificada con el ID: "+id+" no encontrado");
		} else {
			ic.deleteById(id);
		}
		
	}
	
	@PutMapping("/update")
	public void updateCiudad(@RequestBody Ciudad c) {
		Optional<Ciudad> ci = ic.findById(c.getId());
		if (ci.equals(null)) {
            throw new RuntimeException("Ciudad identificada con el ID: "+c.getId()+" no encontrado");
		} else {
			ic.save(c);
		}
		
	}
}