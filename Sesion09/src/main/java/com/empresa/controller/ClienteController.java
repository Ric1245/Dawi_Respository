package com.empresa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Cliente;
import com.empresa.service.ClienteService;

@RestController
@RequestMapping("/rest/Cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Cliente>>lista(){
		return ResponseEntity.ok(service.listaCliente());
		
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Cliente>eliminarPorId(@PathVariable("id") int Cliente){
		Optional<Cliente> optCliente = service.ObtieneporID(Cliente);
		if(optCliente.isPresent()) {
			service.EliminaCliente(Cliente);
			return ResponseEntity.ok(optCliente.get());
		}else {
			
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Cliente>listaPorId(@PathVariable("id")int IdCliente){
		
		Optional<Cliente> optCliente= service.ObtieneporID(IdCliente);
		
		if (optCliente.isPresent()) {
			return ResponseEntity.ok(optCliente.get());
		} else {
			return ResponseEntity.notFound().build();

		}
		}
		
	@PostMapping
	@ResponseBody
	public ResponseEntity<Cliente>registra(@RequestBody Cliente obj){
		return ResponseEntity.ok(service.insertaActualizaCliente(obj));
		
	}
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<Cliente>Actualiza(@RequestBody Cliente obj){
		return ResponseEntity.ok(service.insertaActualizaCliente(obj));
		
	}
		
	
	
	

}
