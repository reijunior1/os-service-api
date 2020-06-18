package api.ordemservico.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import api.ordemservico.domain.model.Cliente;

@RestController
public class ClienteController {
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		var cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("Reinaldo Couto");
		cliente1.setTelefone("199999999");
		cliente1.setEmail("reijunior1@hotmail.com");
		
		
		var cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("Reinaldo");
		cliente2.setTelefone("19-99998888");
		cliente2.setEmail("reijunior1@hotmail.com");
		
		return Arrays.asList(cliente1, cliente2);
	}

}
