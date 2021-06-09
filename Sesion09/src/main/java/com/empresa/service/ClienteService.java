package com.empresa.service;

import java.util.List;
import java.util.Optional;
import com.empresa.entity.Cliente;

public interface ClienteService {
	
	public abstract List<Cliente>listaCliente();
	public abstract Cliente insertaActualizaCliente(Cliente obj);
	public abstract Optional<Cliente>ObtieneporID(int IdCliente);
	public abstract void EliminaCliente(int id);
	public abstract List<Cliente>listaClientePorNombreLike(String filtro);
	public abstract List<Cliente>listaPorDni(String dni);
	public abstract List<Cliente>listaPorDni(String dni, int IdCliente);
	

}
