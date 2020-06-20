package api.ordemservico.domain.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.ordemservico.domain.model.OrdemServico;
import api.ordemservico.domain.model.StatusOrdemServico;
import api.ordemservico.domain.repository.OrdemServicoRepository;

@Service
public class GestaoOrdemServico {
	
	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	public OrdemServico criar(OrdemServico ordemServico) {
		ordemServico.setStatus(StatusOrdemServico.ABERTA);
		ordemServico.setDataAbertura(LocalDateTime.now());
				
		return ordemServicoRepository.save(ordemServico);
		
	}
}
