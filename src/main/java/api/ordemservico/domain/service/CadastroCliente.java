package api.ordemservico.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.ordemservico.domain.exception.NegocioException;
import api.ordemservico.domain.model.Cliente;
import api.ordemservico.domain.repository.ClienteRepository;

@Service
public class CadastroCliente {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente salvar(Cliente cliente) {
		Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());
		
		if (clienteExistente != null && !clienteExistente.equals(cliente)) {
			throw new NegocioException("Já existe um cliente cadastrado com este e-mail.");
	}
	
	return clienteRepository.save(cliente);
	
	}

	public void excluir(Long clienteId) {
		clienteRepository.deleteById(clienteId);;
	}

}
