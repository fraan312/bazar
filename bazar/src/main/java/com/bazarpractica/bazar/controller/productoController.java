
package com.bazarpractica.bazar.controller;

import com.bazarpractica.bazar.model.Producto;
import com.bazarpractica.bazar.service.IProductoService;
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
public class productoController {
    @Autowired
    private IProductoService interpro;
    
    @PostMapping("/productos/crear")
    public String crear_producto(@RequestBody Producto pro){
            interpro.crear_producto(pro);
            return "El producto ha sido creado correctamente.";
    }
    
    @GetMapping("/productos")
    public List<Producto> lista_producto(){
        return interpro.lista_producto();
        
    }
    
    @GetMapping("productos/{codigo_producto}")
    public Producto traer_producto(@PathVariable Long codigo_producto ){
       return interpro.traer_producto(codigo_producto);
    
    }
   
    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public String eliminar_producto(@PathVariable Long codigo_producto){
        interpro.eliminar_producto(codigo_producto);
        return "El producto ha sido eliminado correctamente.";
        
    }
    
    @PutMapping("productos/editar/{codigo_producto}")
    public Producto editar_producto(@PathVariable Long codigo_producto,@RequestParam (required=false, name="nuevo_codigo_producto")Long nuevo_codigo_producto,
                                                                       @RequestParam (required=false, name="nuevo_nombre")String nuevo_nombre,
                                                                       @RequestParam (required=false, name="nuevo_marca")String nueva_marca,
                                                                       @RequestParam (required=false, name="nuevo_costo")Double nuevo_costo,
                                                                       @RequestParam (required=false, name="nuevo_cantidad_disponible")Double nuevo_cantidad_disponible){
        //envio id original, luego los otros atributos como esta requesteado en el metodo.
        interpro.editar_producto(codigo_producto, nuevo_codigo_producto, nuevo_nombre, nueva_marca, nuevo_costo, nuevo_cantidad_disponible);
        //busco la persona editada para mostrarla en la response
        Producto pro=interpro.traer_producto(nuevo_codigo_producto);
        return pro;
        
    }
    
    @PutMapping("productos/editar")
    public Producto editar_producto(@RequestBody Producto pro){
            interpro.editar_producto(pro);
            return interpro.traer_producto(pro.getCodigo_producto());
    }
    
    @GetMapping("/productos/falta_stock")
    public List<Producto>falta_stock(){
            return interpro.cantidad_disponible();
    }
}
