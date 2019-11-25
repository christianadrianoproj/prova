package senac.org.prova_backend.controller;

import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

import senac.org.prova_backend.domain.Projeto;
import senac.org.prova_backend.repository.ProjetoRepository;

/**
*
* @author Christian
*/

@RestController
@RequestMapping("/projeto")
@CrossOrigin(origins="*")
public class ProjetoController {
	@Autowired
	private ProjetoRepository repository;
	
	@GetMapping
	public Page<Projeto> findAll() {
		PageRequest page = PageRequest.of(0, 20, Sort.by("nome"));
		return repository.findAll(page);
	}
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody @Valid Projeto proj) {
		if ((proj.getOrcamento() >= proj.getArea().getOrcamentoMinimo()) && (proj.getOrcamento() <= proj.getArea().getOrcamentoMaximo()))
			return ResponseEntity.ok(repository.save(proj));
		return 
			ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
			.body(String.format(
					"Projeto %s não respeitando os valores de orçamento mínimo/máximo!", proj.getNome()));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable("id") Integer id) {
		Optional<Projeto> proj = repository.findById(id);
		if (proj.isPresent()) {
			return ResponseEntity.ok(proj.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		repository.deleteById(id);
	}
}
