package senac.org.prova_backend.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import senac.org.prova_backend.vo.AreaTotal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import senac.org.prova_backend.repository.AreaRepository;
import senac.org.prova_backend.domain.Area;

/**
*
* @author Christian
*/

@RestController
@RequestMapping("/area")
@CrossOrigin(origins="*")
public class AreaController {
	@Autowired
	private AreaRepository repository;
	
	@GetMapping
	public List<Area> findAll() {
		return repository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody @Valid Area area) {
		if ((area.getOrcamentoMinimo() > 0) && (area.getOrcamentoMaximo() > 0))
			return ResponseEntity.ok(repository.save(area));
		return 
			ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
			.body(String.format(
					"Área %s faltando valor para orçamento mínimo/máximo!", area.getNome()));		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable("id") Integer id) {
		Optional<Area> area = repository.findById(id);
		if (area.isPresent()) {
			return ResponseEntity.ok(area.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/totais")
	public List<AreaTotal> findMarcaTotal() {
		return repository.findAreaTotal();
	}
		
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		repository.deleteById(id);
	}	
}
