
package com.bazarpractica.bazar.service;

import com.bazarpractica.bazar.dto.Venta_clienteDTO;
import com.bazarpractica.bazar.model.Cliente;
import com.bazarpractica.bazar.model.Producto;
import com.bazarpractica.bazar.model.Venta;
import java.time.LocalDate;
import java.util.List;




public interface IVentaService {
    
    public void crear_venta(Venta ven);
    public List<Venta> lista_venta();
    public Venta traer_venta(Long codigo_venta);
    public void eliminar_venta(Long codigo_venta);
    //En caso que el Id sea modificable, se utiliza el siguiente metodo:
    public void editar_venta(Long codigo_venta, Long nuevo_codigo_venta, LocalDate nueva_fecha_venta, Double nuevo_total, List<Producto> nueva_listaProductos, Cliente nuevo_unCliente); 
    //metodo sencillo para editar 
    public void editar_venta(Venta ven);
    public List<Producto>lista_productos(Long codigo_venta);
    public List<String>fecha_venta(LocalDate fecha_venta);
    public Venta_clienteDTO venta_clienteDTO();
           
}
