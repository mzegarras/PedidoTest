package net.msonic.pedidos.rest.dao;


import net.msonic.pedidos.rest.model.Producto;

public interface IProductoRepository {
	
	 Producto productoById(long id);

}
