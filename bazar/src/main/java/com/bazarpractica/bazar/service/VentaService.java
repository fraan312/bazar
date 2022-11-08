
package com.bazarpractica.bazar.service;

import com.bazarpractica.bazar.dto.Venta_clienteDTO;
import com.bazarpractica.bazar.model.Cliente;
import com.bazarpractica.bazar.model.Producto;
import com.bazarpractica.bazar.model.Venta;
import com.bazarpractica.bazar.repository.IVentaRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService{
    
    @Autowired
    private IVentaRepository ventarepo;

    @Override
    public void crear_venta(Venta ven) {
            ventarepo.save(ven);
    }

    @Override
    public List<Venta> lista_venta() {
            List<Venta> lista_venta=ventarepo.findAll();
            return lista_venta;
    }

    @Override
    public Venta traer_venta(Long codigo_venta) {
            Venta ven=ventarepo.findById(codigo_venta).orElse(null);
            return ven;
    }

    @Override
    public void eliminar_venta(Long codigo_venta) {
            ventarepo.deleteById(codigo_venta);
    }

    @Override
    public void editar_venta(Long codigo_venta, Long nuevo_codigo_venta, LocalDate nueva_fecha_venta, Double nuevo_total, List<Producto> nueva_listaProductos, Cliente nuevo_unCliente) {
            Venta ven=this.traer_venta(codigo_venta);
            ven.setCodigo_venta(nuevo_codigo_venta);
            ven.setFecha_venta(nueva_fecha_venta);
            ven.setTotal(nuevo_total);
            ven.setListaProductos(nueva_listaProductos);
            ven.setUnCliente(nuevo_unCliente);
            
            this.crear_venta(ven);
    }

    @Override
    public void editar_venta(Venta ven) {
            this.crear_venta(ven);
    }

         

    @Override
    public List<Producto> lista_productos(Long codigo_venta) {
        List<Producto> lista_productos=this.traer_venta(codigo_venta).getListaProductos();
            return lista_productos;
    }

    @Override
    public List<String> fecha_venta(LocalDate fecha_venta) {
       List<String>items=new ArrayList<String>();
       Integer contador=0;
       Double monto_total=0.0;
       List<Venta>ventas=this.lista_venta();
       for(Venta ven:ventas){
            if(ven.getFecha_venta().equals(fecha_venta)){
                contador=contador+1;
                monto_total=monto_total + ven.getTotal();
                }
            }
        items.add(contador.toString());
        items.add(monto_total.toString());
             
       return items;
       
    }

    @Override
    public Venta_clienteDTO venta_clienteDTO() {
        Venta_clienteDTO venta_cliente=new Venta_clienteDTO();
        List<Venta>lista_venta= this.lista_venta();
        Venta venta = null;
        Double total=0.0;
        for(Venta ven:lista_venta){
                if(ven.getTotal()==null){
                continue;
                }
               if(ven.getTotal() > total){
               total=ven.getTotal();
               venta=ven;
                }
            }
        
        venta_cliente.setCodigo_venta(venta.getCodigo_venta());
        venta_cliente.setTotal(venta.getTotal());
        venta_cliente.setCantidad_productos(venta.getListaProductos().size());
        venta_cliente.setNombre_cliente(venta.getUnCliente().getNombre());
        venta_cliente.setApellido_cliente(venta.getUnCliente().getApellido());
        
        return venta_cliente;
    }

    

    
        
    }

   
    

