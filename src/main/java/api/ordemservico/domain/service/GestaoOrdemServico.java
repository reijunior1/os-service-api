package api.ordemservico.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.ordemservico.domain.exception.NegocioException;
import api.ordemservico.domain.model.Cliente;
import api.ordemservico.domain.model.OrdemServico;
import api.ordemservico.domain.model.StatusOrdemServico;
import api.ordemservico.domain.repository.ClienteRepository;
import api.ordemservico.domain.repository.OrdemServicoRepository;

@Service
public class GestaoOrdemServico {
	
	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public OrdemServico criar(OrdemServico ordemServico) {
		Cliente cliente = clienteRepository.findById(ordemServico.getCliente().getId())
				.orElseThrow(() -> new NegocioException("Cliente não encontrado"));
		
		ordemServico.setCliente(cliente);
		ordemServico.setStatus(StatusOrdemServico.ABERTA);
		ordemServico.setDataAbertura(OffsetDateTime.now());
				
		return ordemServicoRepository.save(ordemServico);
		
	}
}
