
package com.bazarpractica.bazar.service;

import com.bazarpractica.bazar.model.Producto;
import com.bazarpractica.bazar.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService{
    
    @Autowired
    private IProductoRepository produrepo;

    @Override
    public void crear_producto(Producto pro) {
           produrepo.save(pro);
    }

    @Override
    public List<Producto> lista_producto() {
            List <Producto> lista_producto = produrepo.findAll();
            return lista_producto;
    }

    @Override
    public Producto traer_producto(Long codigo_producto) {
            Producto pro=produrepo.findById(codigo_producto).orElse(null);
            return pro;
    }

    @Override
    public void eliminar_producto(Long codigo_producto) {
            produrepo.deleteById(codigo_producto);
    }
//  El siguiente metodo es la implementacion de un editar si se necesita editar el ID:
    @Override
    public void editar_producto(Long codigo_producto, Long nuevo_codigo_producto, String nuevo_nombre, String nuevo_marca, Double nuevo_costo, Double nuevo_cantidad_disponible) {
            Producto pro=this.traer_producto(codigo_producto);
            pro.setCodigo_producto(nuevo_codigo_producto);
            pro.setNombre(nuevo_nombre);
            pro.setMarca(nuevo_marca);
            pro.setCosto(nuevo_costo);
            pro.setCantidad_disponible(nuevo_cantidad_disponible);
            
            this.crear_producto(pro);
    }
//metodo de edicion mas rapido y practico, en caso que el ID no se deba modificar
    @Override
    public void editar_producto(Producto pro) {
        this.crear_producto(pro);

    }

    @Override
    public List<Producto> cantidad_disponible() {
            List<Producto>stock=this.lista_producto();
            List<Producto>falta_stock= new ArrayList();
            for(Producto produ:stock){
                    if(produ.getCantidad_disponible()==null){
                        continue;
                    } 
                    if(produ.getCantidad_disponible()<5){
                        falta_stock.add(produ);
                    }
            }
            return falta_stock;     
                    }

    
    }
    

