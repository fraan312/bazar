
 
package com.bazarpractica.bazar.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Venta_clienteDTO {
    Long codigo_venta;
    Double total;
    int cantidad_productos;
    String nombre_cliente;
    String apellido_cliente;

    public Venta_clienteDTO(Long codigo_venta, Double total, int cantidad_productos, String nombre_cliente, String apellido_cliente) {
        this.codigo_venta = codigo_venta;
        this.total = total;
        this.cantidad_productos = cantidad_productos;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
    }
    
    public Venta_clienteDTO(){};
}
