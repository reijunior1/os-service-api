package api.ordemservico.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import api.ordemservico.domain.model.OrdemServico;
import api.ordemservico.domain.repository.OrdemServicoRepository;
import api.ordemservico.domain.service.GestaoOrdemServico;

@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoController {
	
	@Autowired
	private GestaoOrdemServico gestaoOrdemServico;
	
	
	@Autowired
	private OrdemServicoRepository OrdemServicoRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrdemServico criar(@Valid @RequestBody OrdemServico ordemServico) {
		
		return gestaoOrdemServico.criar(ordemServico);
		
	}
	
	@GetMapping
	public List<OrdemServico> listar(){
		return OrdemServicoRepository.findAll();
	}

	@GetMapping("/{ordemServicoId}")
	public ResponseEntity<OrdemServico> buscar(@PathVariable Long ordemServicoId) {
		Optional<OrdemServico> ordemServico =  OrdemServicoRepository.findById(ordemServicoId);
		
		if (ordemServico.isPresent()) {
			return ResponseEntity.ok(ordemServico.get());
		}
		
			return ResponseEntity.notFound().build();
	}
}
