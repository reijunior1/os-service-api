package api.ordemservico.domain.service;

import org.springframework.beans.factory.annotation.Autowired;

import api.ordemservico.domain.model.Cliente;
import api.ordemservico.domain.repository.ClienteRepository;

public class CadastroCliente {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

}
