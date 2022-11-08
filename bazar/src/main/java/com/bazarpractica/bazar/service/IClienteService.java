
package com.bazarpractica.bazar.service;

import com.bazarpractica.bazar.model.Cliente;
import java.util.List;


public interface IClienteService {
    public void crear_cliente(Cliente clie);
    public List<Cliente> lista_cliente();
    public Cliente traer_cliente(Long codigo_cliente);
    public void eliminar_cliente(Long codigo_cliente);
    //En caso que el Id sea modificable, se utiliza el siguiente metodo:
    public void editar_cliente(Long codigo_cliente, Long nuevo_codigo_cliente,String nuevo_nombre, String nuevo_apellido, String nuevo_dni);
    //metodo sencillo para editar 
    public void editar_cliente(Cliente clie);
}
