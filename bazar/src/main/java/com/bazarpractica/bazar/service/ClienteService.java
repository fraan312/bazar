/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bazarpractica.bazar.service;

import com.bazarpractica.bazar.model.Cliente;
import com.bazarpractica.bazar.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService{
    
    @Autowired
    private IClienteRepository clienterepo;

    @Override
    public void crear_cliente(Cliente clie) {
            clienterepo.save(clie);
    }

    @Override
    public List<Cliente> lista_cliente() {
            List<Cliente>lista_cliente=clienterepo.findAll();
            return lista_cliente;
    }

    @Override
    public Cliente traer_cliente(Long codigo_cliente) {
            Cliente clie=clienterepo.findById(codigo_cliente).orElse(null);
            return clie;
    }

    @Override
    public void eliminar_cliente(Long codigo_cliente) {
            clienterepo.deleteById(codigo_cliente);
    }

    @Override
    public void editar_cliente(Long codigo_cliente, Long nuevo_codigo_cliente,String nuevo_nombre, String nuevo_apellido, String nuevo_dni) {
            Cliente clie=this.traer_cliente(codigo_cliente);
            clie.setId_cliente(nuevo_codigo_cliente);
            clie.setNombre(nuevo_nombre);
            clie.setApellido(nuevo_apellido);
            clie.setDni(nuevo_dni);
            
            this.crear_cliente(clie);
    }

    @Override
    public void editar_cliente(Cliente clie) {
            this.crear_cliente(clie);
    }
    
}
