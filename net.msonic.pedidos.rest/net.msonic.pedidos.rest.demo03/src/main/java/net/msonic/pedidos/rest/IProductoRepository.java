package net.msonic.pedidos.rest;

import java.util.List;

public interface IProductoRepository {
	
	List<Producto> listar(long id);
	Producto queryById(long id);

}
