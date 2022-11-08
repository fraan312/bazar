
package com.bazarpractica.bazar.repository;

import com.bazarpractica.bazar.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto,Long>{
    
}
