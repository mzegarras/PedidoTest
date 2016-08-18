package net.msonic.pedidos.rest;

import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.internal.verification.Times;
import org.mockito.runners.MockitoJUnitRunner;


import static org.hamcrest.CoreMatchers.*;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.isA;



import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductoService {
	
	
	@Mock
	IProductoRepository productoRepository;
	
	@Test
	public void sanidad(){
		assertThat(productoRepository, not(nullValue()));
	}

	
	@Test
	public void test01(){
		
		Producto p1 = new Producto();
		p1.setDescripcion("001");
		
		when(productoRepository.queryById(Matchers.anyLong())).thenReturn(p1);
		//when(productoRepository.queryById(11)).thenReturn(p1);
		Producto pr = productoRepository.queryById(1L);
		
		//verify(productoRepository,atLeastOnce()).queryById(Matchers.anyLong());
		verify(productoRepository,times(1)).queryById(Matchers.anyLong());
		
		assertThat(pr,not(nullValue()));
		
	}

}
