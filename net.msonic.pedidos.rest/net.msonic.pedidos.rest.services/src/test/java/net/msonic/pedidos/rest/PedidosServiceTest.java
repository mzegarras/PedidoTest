package net.msonic.pedidos.rest;



import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.msonic.pedidos.rest.common.MontoMinimoException;
import net.msonic.pedidos.rest.common.ProductoException;
import net.msonic.pedidos.rest.common.StockException;
import net.msonic.pedidos.rest.dao.IProductoRepository;
import net.msonic.pedidos.rest.model.Pedido;
import net.msonic.pedidos.rest.model.PedidoItem;
import net.msonic.pedidos.rest.model.Producto;
import net.msonic.pedidos.rest.services.IPedidoService;



import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/test/resources/spring/PedidosService-context-test.xml" })
public class PedidosServiceTest {
	
	@Autowired
	private IPedidoService pedidoService;
	
	@Autowired
	private IProductoRepository productoRepository;
	
	
	@Test(expected=MontoMinimoException.class)
	@Ignore
	public void savePedidoClienteSegmentoATest() throws Exception{
		
		doThrow(new MontoMinimoException()).when(pedidoService).guardarPedido(isA(Pedido.class));
		pedidoService.guardarPedido(new Pedido());
		
	}

	
	@Test
	public void sanity() {		
		assertThat(pedidoService, is(not(nullValue())));
		assertThat(productoRepository, is(not(nullValue())));
	}
	
	@Test
	public void calcularTotalPedidoSinDescuentoTest(){
		
		Producto p1 = new Producto();
		p1.precioVenta=10;
		
		Producto p2 = new Producto();
		p2.precioVenta=20;
		
		when(productoRepository.productoById(1L)).thenReturn(p1);
		when(productoRepository.productoById(2L)).thenReturn(p2);
		
		
		Pedido pedido = new Pedido();
		
		Producto pp1 = new Producto();
		pp1.setId(1L);
		PedidoItem pedidoItem1 = new PedidoItem();
		pedidoItem1.setProducto(pp1);
		pedidoItem1.setCantidad(5);
		pedido.getDetalle().add(pedidoItem1);
		
		Producto pp2 = new Producto();
		pp2.setId(2L);
		PedidoItem pedidoItem2 = new PedidoItem();
		pedidoItem2.setProducto(pp2);
		pedidoItem2.setCantidad(20);
		pedido.getDetalle().add(pedidoItem2);
			
		pedido.setDescuento(0.0);
		
		double total = pedidoService.calcularTotal(pedido);
		
		assertThat(total, is(450d));
		
		//verify(productoRepository,times(1)).productoById(1L);
		//verify(productoRepository,times(1)).productoById(2L);
		
		verify(productoRepository,times(2)).productoById(anyLong());
		
		
	}
	
	
	@Test
	public void calcularTotalPedidoConDescuentoTest(){
		
		Producto p1 = new Producto();
		p1.precioVenta=10;
		
		Producto p2 = new Producto();
		p2.precioVenta=20;
		
		when(productoRepository.productoById(1L)).thenReturn(p1);
		when(productoRepository.productoById(2L)).thenReturn(p2);
		
		
		Pedido pedido = new Pedido();
		
		Producto pp1 = new Producto();
		pp1.setId(1L);
		PedidoItem pedidoItem1 = new PedidoItem();
		pedidoItem1.setProducto(pp1);
		pedidoItem1.setCantidad(5);
		pedido.getDetalle().add(pedidoItem1);
		
		Producto pp2 = new Producto();
		pp2.setId(2L);
		PedidoItem pedidoItem2 = new PedidoItem();
		pedidoItem2.setProducto(pp2);
		pedidoItem2.setCantidad(20);
		pedido.getDetalle().add(pedidoItem2);
			
		pedido.setDescuento(0.1);
		
		double total = pedidoService.calcularTotal(pedido);
		
		assertThat(total, is(405d));
		
		//verify(productoRepository,times(1)).productoById(1L);
		//verify(productoRepository,times(1)).productoById(2L);
		
		verify(productoRepository,times(2)).productoById(anyLong());
		
		
	}
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Test()
	public void savePedidoProductoStockCeroTest() throws MontoMinimoException, StockException, ProductoException {
		
		
		//test type
        thrown.expect(StockException.class);

        
		Producto p1 = new Producto();
		p1.stock=10;
		
		Producto p2 = new Producto();
		p2.stock=0;
		
		when(productoRepository.productoById(1L)).thenReturn(p1);
		when(productoRepository.productoById(2L)).thenReturn(p2);
		
		
		Pedido pedido = new Pedido();
		
		Producto pp1 = new Producto();
		pp1.setId(1L);
		PedidoItem pedidoItem1 = new PedidoItem();
		pedidoItem1.setProducto(pp1);
		pedido.getDetalle().add(pedidoItem1);
		
		Producto pp2 = new Producto();
		pp2.setId(2L);
		PedidoItem pedidoItem2 = new PedidoItem();
		pedidoItem2.setProducto(pp2);
		pedido.getDetalle().add(pedidoItem2);
		
		
		pedidoService.guardarPedido(pedido);
		

		
	}
	
	
	
	@Before
	public void setUp(){
		
		reset(productoRepository);
		
	}
	
	
}
