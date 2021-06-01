
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
import co.edu.usbbog.bdd.model.Auditoria;
import co.edu.usbbog.bdd.repo.AuditoriaRepository;


@RestController
@RequestMapping("/auditoria")
public class AuditoriaController {
	@Autowired
	private AuditoriaRepository cmet;

	@PostMapping("/create") 
	public String insertAuditoria(@RequestBody Auditoria c) {
		try {
			if (cmet.existsById(c.getId())) {
				return "Ya se encuentra registrada Auditoria";
			} else {
				cmet.save(c);
				return "Tipo Auditoria se Registro exitosamente";
			}
		} catch (IllegalArgumentException e) {
			return "No se guardo: " + e.getMessage();
		}
	}
	
	
	@GetMapping("/all")
	public List<Auditoria>findAllAuditoria() {
		List<Auditoria> l = cmet.findAll();
		if (l.isEmpty() || l.equals(null)) {
			throw new RuntimeException("No hay Auditoria");
		} else {
			return l;
		}
	}
	
	@GetMapping("/find/{id}")
	public Optional<Auditoria> findAuditoria(@PathVariable("id") Long id) {
		Optional<Auditoria> cu =  cmet.findById(id);
		if (!cu.equals(null)) {
			return cu;
		} else {
            throw new RuntimeException(" no encontrado");
		}	
	}
	
	@GetMapping("/count")
	public long contarAuditoria() {
		long c =  cmet.count();
		try {
		if (c != 0) {
			return c;
		} else {
            throw new RuntimeException("No hay  registradas");
			}
		} catch (IllegalArgumentException e) {
			return c;
		}
	}
	@DeleteMapping("/eliminar")
	public String eliminarAuditoria(@RequestBody Auditoria cuenta) {
		try {
			if (cmet.existsById(cuenta.getId())) {
				cmet.deleteById(cuenta.getId());
				return "Se ha eliminado correctamente";
			} else {
				return "Auditoria no se encuentra registrada";
			}
		} catch (IllegalArgumentException e) {
			return "No se elimino la Auditoria: " + e.getMessage();
		}
	}
	
	@PutMapping("/update")
	public String updateAuditoria(@RequestBody Auditoria c) {
		Optional<Auditoria> ci = cmet.findById(c.getId());
		if (ci.equals(null)) {
            throw new RuntimeException("Auditoria no encontrada");
		} else {
			cmet.save(c);
			return "la Auditoria se actualizo";

		}
		
	}
}
