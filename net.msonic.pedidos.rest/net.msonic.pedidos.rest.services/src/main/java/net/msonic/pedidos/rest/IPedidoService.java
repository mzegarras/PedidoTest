package net.msonic.pedidos.rest;

import net.msonic.pedidos.rest.common.MontoMinimoException;
import net.msonic.pedidos.rest.model.Pedido;

public interface IPedidoService {
	
	
	public void guardarPedido(Pedido pedido) throws MontoMinimoException;
	public double calcularTotal(Pedido pedido);

}
