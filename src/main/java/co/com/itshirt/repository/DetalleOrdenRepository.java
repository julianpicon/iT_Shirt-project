package co.com.itshirt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.com.itshirt.domain.*;

public interface DetalleOrdenRepository extends CrudRepository<DetalleOrden, Long>  {
	
	public List<DetalleOrden> findByOrdenCompra(OrdenCompra orden);
	
}
