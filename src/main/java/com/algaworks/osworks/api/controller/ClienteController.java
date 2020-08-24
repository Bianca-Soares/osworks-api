package com.algaworks.osworks.api.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.osworks.domain.model.Cliente;
import com.algaworks.osworks.domain.repository.ClienteRepository;


@RestController
public class ClienteController {

	//interface para operacoes nas entidades
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
    @GetMapping("/clientes")	 //Método para receber requisições na uri /clientes
	public List<Cliente> listar() {// GET/clientes chama e recebe o return
		
		
    //return clienteRepository.findAll();
    //return clienteRepository.findByNomeContaining("Ma");
    	return clienteRepository.findByNome("Maria");
    
    	
    }
    
  //implementar outros endpoints
    
    @GetMapping("/clientes/{clienteId}")
    public Cliente buscar(@PathVariable Long clienteId) {
    	Optional<Cliente> cliente = clienteRepository.findById(clienteId);
    	return cliente.orElse(null);
    }
}
