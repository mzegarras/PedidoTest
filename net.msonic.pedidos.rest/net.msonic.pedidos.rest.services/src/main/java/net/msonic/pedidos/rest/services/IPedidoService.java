package net.msonic.pedidos.rest.services;

import net.msonic.pedidos.rest.common.MontoMinimoException;
import net.msonic.pedidos.rest.common.ProductoException;
import net.msonic.pedidos.rest.common.StockException;
import net.msonic.pedidos.rest.model.Pedido;

public interface IPedidoService {
	
	
	public void guardarPedido(Pedido pedido) throws MontoMinimoException,StockException,ProductoException;
	public double calcularTotal(Pedido pedido);

}
