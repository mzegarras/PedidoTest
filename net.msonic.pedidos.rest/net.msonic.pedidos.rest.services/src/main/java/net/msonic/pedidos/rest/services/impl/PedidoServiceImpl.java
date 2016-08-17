package net.msonic.pedidos.rest.services.impl;


import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.msonic.pedidos.rest.common.MontoMinimoException;
import net.msonic.pedidos.rest.common.StockException;
import net.msonic.pedidos.rest.dao.IProductoRepository;
import net.msonic.pedidos.rest.model.Pedido;
import net.msonic.pedidos.rest.model.PedidoItem;
import net.msonic.pedidos.rest.model.Producto;
import net.msonic.pedidos.rest.services.IPedidoService;

@Service
public class PedidoServiceImpl implements IPedidoService {
	
	
	@Autowired
	private IProductoRepository productoRepository;
	
	public void guardarPedido(Pedido pedido) throws MontoMinimoException,StockException {
		
		
		
		for (PedidoItem pedidoItem:pedido.getDetalle()) {
			
			Producto producto = productoRepository.productoById(pedidoItem.getProducto().getId());
			
			if(producto.getStock()<=0){
				throw new StockException();
			}
			
		}
		
		double total = calcularTotal(pedido);
		
		if(pedido.getCliente().getSegmento().compareTo("AAA")==0){
			if(total<2500){
				throw new MontoMinimoException();
			}
		}else if(pedido.getCliente().getSegmento().compareTo("BBB")==0){
			if(total<1000){
				throw new MontoMinimoException();
			}
		}else if(pedido.getCliente().getSegmento().compareTo("CCC")==0){
			if(total<800){
				throw new MontoMinimoException();
			}
		}
		
	}

	public double calcularTotal(Pedido pedido) {
		
		double total = 0;
		
		for (int i = 0; i < pedido.getDetalle().size(); i++) {
			
			PedidoItem pedidoItem = pedido.getDetalle().get(i);
			
			Producto producto = productoRepository.productoById(pedidoItem.getProducto().getId());
			
			
			total += producto.getPrecioVenta() * pedidoItem.getCantidad();
			
		}
		
		if(pedido.getDescuento()>0){
			total = total * (1-pedido.getDescuento());
		}
		return total;
		
	}

}
