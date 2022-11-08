
package com.bazarpractica.bazar.controller;

import com.bazarpractica.bazar.model.Cliente;
import com.bazarpractica.bazar.service.IClienteService;
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
public class clienteController {
    
    @Autowired
    private IClienteService interclie;
    
    @PostMapping("/clientes/crear")
    public String crear_cliente(@RequestBody Cliente clie){
            interclie.crear_cliente(clie);
            return "El cliente ha sido creado con exito";
    }
    
    @GetMapping("/clientes")
    public List<Cliente>lista_clientes(){
            return interclie.lista_cliente();
    }
    
    
    @GetMapping("/clientes/{id_cliente}")
    public Cliente traer_cliente(@PathVariable Long id_cliente){
            return interclie.traer_cliente(id_cliente);
    }
    
    @DeleteMapping("clientes/eliminar/{id_cliente}")
    public String eliminar_cliente(@PathVariable Long id_cliente){
            interclie.eliminar_cliente(id_cliente);
            return "El cliente ha sido eliminado con exito";
    }
    
    @PutMapping("/clientes/editar/{id_cliente}")
   public Cliente editar_cliente(@PathVariable Long id_cliente,
                                  @RequestParam (required=false, name="nuevo_id_cliente") Long nuevo_id_cliente,
                                  @RequestParam (required=false, name="nuevo_nombre") String nuevo_nombre,
                                  @RequestParam (required=false, name="nuevo_apellido")String nuevo_apellido,
                                  @RequestParam (required=false, name="nuevo_dni")String nuevo_dni){
            interclie.editar_cliente(id_cliente, nuevo_id_cliente, nuevo_nombre, nuevo_apellido, nuevo_dni);
            Cliente clie=interclie.traer_cliente(nuevo_id_cliente);
            return clie;
     }
   
    @PutMapping("/clientes/editar")
    public Cliente editar_cliente(@RequestBody Cliente clie){
            interclie.crear_cliente(clie);
            return interclie.traer_cliente(clie.getId_cliente());
    }
}