
package com.bazarpractica.bazar.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Venta {
    @Id
    @GeneratedValue (strategy=GenerationType.SEQUENCE)
    private Long codigo_venta;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate fecha_venta;
    private Double total;
    @OneToMany
    //con lo siguiente puedo especificar  el nombre de la tabla intermedia y ademas el nombre de cada uno de los campos que representaran el id
    @JoinTable(name="Relacion_venta_productos")
    private List<Producto> listaProductos;
    @OneToOne
    //asocio el nombre de la nueva columna creada en esta tabla con el nombre del atributo a asociar: ej:
    @JoinColumn(name="un_cliente_id_cliente", referencedColumnName="id_cliente")
    private Cliente unCliente;
  
    
    public Venta (){}

    public Venta(Long codigo_venta, LocalDate fecha_venta, Double total, List<Producto> listaProductos, Cliente unCliente) {
        this.codigo_venta = codigo_venta;
        this.fecha_venta = fecha_venta;
        this.total = total;
        this.listaProductos = listaProductos;
        this.unCliente = unCliente;
    }
  
}
