
package com.bazarpractica.bazar.service;

import com.bazarpractica.bazar.model.Producto;
import java.util.List;


public interface IProductoService {
    
    public void crear_producto(Producto pro);
    public List<Producto> lista_producto();
    public Producto traer_producto(Long codigo_producto);
    public void eliminar_producto(Long codigo_producto);
    //En caso que el Id sea modificable, se utiliza el siguiente metodo:
    public void editar_producto(Long codigo_producto, Long nuevo_codigo_producto, String nuevo_nombre, String nuevo_marca, Double nuevo_costo, Double nuevo_cantidad_disponible);
    //metodo sencillo para editar 
    public void editar_producto(Producto pro);
    public List<Producto> cantidad_disponible();
}
