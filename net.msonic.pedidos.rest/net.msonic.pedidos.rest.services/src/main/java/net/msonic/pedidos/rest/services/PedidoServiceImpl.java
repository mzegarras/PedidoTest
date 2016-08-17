package net.msonic.pedidos.rest.services;


import net.msonic.pedidos.rest.IPedidoService;
import net.msonic.pedidos.rest.common.MontoMinimoException;
import net.msonic.pedidos.rest.model.Pedido;

public class PedidoServiceImpl implements IPedidoService {

	public void guardarPedido(Pedido pedido) throws MontoMinimoException {
		// TODO Auto-generated method stub
		
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
			
			total += pedido.getDetalle().get(i).getTotal();
			
		}
		
		return total;
		
	}

}
