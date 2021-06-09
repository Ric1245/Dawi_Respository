package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.empresa.entity.Cliente;
import com.empresa.repository.ClienteRepository;

@Service
public class ClienteServicelmpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	
	@Override
	public List<Cliente> listaCliente() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Cliente insertaActualizaCliente(Cliente obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public Optional<Cliente> ObtieneporID(int IdCliente) {
		// TODO Auto-generated method stub
		return repository.findById(IdCliente);
	}

	@Override
	public void EliminaCliente(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

	@Override
	public List<Cliente> listaClientePorNombreLike(String filtro) {
		// TODO Auto-generated method stub
		return repository.listaClientePorNombreLike(filtro);
	}

	@Override
	public List<Cliente> listaPorDni(String dni) {
		// TODO Auto-generated method stub
		return repository.findByDni(dni);
	}

	@Override
	public List<Cliente> listaPorDni(String dni, int IdCliente) {
		// TODO Auto-generated method stub
		return repository.findByDniAndIdClienteNot(dni, IdCliente);
	}

}
