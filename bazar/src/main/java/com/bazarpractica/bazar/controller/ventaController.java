
package com.bazarpractica.bazar.controller;

import com.bazarpractica.bazar.dto.Venta_clienteDTO;
import com.bazarpractica.bazar.model.Cliente;
import com.bazarpractica.bazar.model.Producto;
import com.bazarpractica.bazar.model.Venta;
import com.bazarpractica.bazar.service.IVentaService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ventaController {
    
    @Autowired
    private IVentaService ventaser;
    
    @PostMapping("/ventas/crear")
    public String crear_venta(@RequestBody Venta ven){
            ventaser.crear_venta(ven);
            return "La venta ha sido creada correctamente.";
    
    }
    
    @GetMapping("/ventas")
    public List<Venta> lista_venta(){
            return ventaser.lista_venta();
            
    }
    
    @GetMapping("/venta/{codigo_venta}")
    public Venta traer_venta(@PathVariable Long codigo_venta){
        return ventaser.traer_venta(codigo_venta);
    }
    
    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public String eliminar_venta(@PathVariable Long codigo_venta){
            ventaser.eliminar_venta(codigo_venta);
            return "La venta a sido eliminada con exito.";
    }
    
    @PutMapping("ventas/editar/{codigo_venta}")
    public Venta editar_venta(@PathVariable Long codigo_venta, @RequestParam(required=false, name="nuevo_codigo_venta") Long nuevo_codigo_venta,
                                                               @RequestParam(required=false, name="nueva_fecha_venta") LocalDate nueva_fecha_venta,
                                                               @RequestParam(required=false, name="nuevo_total")Double nuevo_total,
                                                               @RequestParam(required=false, name="nueva_lista_productos")List<Producto> nueva_listaProductos,
                                                               @RequestParam(required=false, name="nuevo_unCliente") Cliente nuevo_unCliente){
    ventaser.editar_venta(codigo_venta, nuevo_codigo_venta, nueva_fecha_venta, nuevo_total, nueva_listaProductos, nuevo_unCliente);
    Venta ven=ventaser.traer_venta(nuevo_codigo_venta);
    return ven;
    }
    
    @PutMapping("/ventas/editar")
    public Venta editar_venta(@RequestBody Venta ven){
     ventaser.editar_venta(ven);
     return ventaser.traer_venta(ven.getCodigo_venta());
    }
    
    @GetMapping("/ventas/productos/{codigo_venta}")
    public List<Producto> lista_productos(@PathVariable Long codigo_venta){
            return ventaser.lista_productos(codigo_venta);
    }
    
    @GetMapping("/ventas/{fecha_venta}")
    public String fecha_venta(@PathVariable LocalDate fecha_venta){
            List<String> ventas_dia=ventaser.fecha_venta(fecha_venta);
            return "Total de ventas: "+ventas_dia.get(0).toString()+" monto total: "+ventas_dia.get(1).toString();        
      
    }
    
    @GetMapping("/ventas/mayor_venta")
    public Venta_clienteDTO mayor_venta(){
            return ventaser.venta_clienteDTO();
    }
}