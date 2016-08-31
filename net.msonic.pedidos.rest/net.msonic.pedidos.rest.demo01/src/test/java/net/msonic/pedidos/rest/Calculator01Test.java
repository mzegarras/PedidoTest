package net.msonic.pedidos.rest;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Calculator01Test {
	
	@BeforeClass
	public static void inicio(){
		System.out.println("inicio");
	}
	
	@Before
	public void antesTest(){
		System.out.println("antes test");
	}
	
	
	
	@Test()
	public void test01(){
		assertTrue(1==1);
	}
	
	@Test()
	public void test02(){
		assertFalse(1!=1);
	}
	
	@Test()
	public void test03(){
		assertFalse(1!=1);
	}
	
	@Test()
	public void test04(){
		String cadena=null;
		assertNull(cadena);
	}
	
	
	@Test()
	public void test05(){
		String cadena="123";
		assertNotNull(cadena);
	}
	
	
	@Test()
	public void test06(){
		Integer x = new Integer(5);
		assertSame(x, x);
	}
	
	@Test()
	public void test07(){
		Integer x = new Integer(5);
		Integer y = new Integer(5);
		assertNotSame(x, y);
	}
	
	@Test(expected=ArithmeticException.class)
	public void test08(){
		int x = 6;
		int y = 0;
		int rp = 6 / 0;
	}
	
	
	@After
	public void despuesTest(){
		System.out.println("despues test");
	}
	

	
	@AfterClass
	public static void fin(){
		System.out.println("fin");
	}
	
	
	@Test()
	public void testSuma(){
		Calculator c = new Calculator();
		c.setNumero1(2);
		c.setNumero2(5);
		
		assertSame(7, c.sumar());
		
	}
	

	@Test(expected=IllegalArgumentException.class)
	public void givenN1Mayor100WhenSumaThenException(){
		int x = 101;
		int y = 10;
		Calculator c = new Calculator();
		c.setNumero1(x);
		c.setNumero2(y);
		
		c.sumar();
	}
	

	@Test(expected=IllegalArgumentException.class)
	public void givenN2Mayor100WhenSumaThenException(){
		int x = 10;
		int y = 101;
		Calculator c = new Calculator();
		c.setNumero1(x);
		c.setNumero2(y);
		
		c.sumar();
	}
	
	@Test()
	public void testResta(){
		Calculator c = new Calculator();
		c.setNumero1(2);
		c.setNumero2(5);
		
		assertSame(-3, c.restar());
		
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void givenN1Mayor100WhenRestaThenException(){
		int x = 101;
		int y = 10;
		Calculator c = new Calculator();
		c.setNumero1(x);
		c.setNumero2(y);
		
		c.restar();
	}
	

	@Test(expected=IllegalArgumentException.class)
	public void givenN2Mayor100WhenRestaThenException(){
		int x = 10;
		int y = 101;
		Calculator c = new Calculator();
		c.setNumero1(x);
		c.setNumero2(y);
		
		c.restar();
	}
	
	@Test()
	public void testProducto(){
		Calculator c = new Calculator();
		c.setNumero1(2);
		c.setNumero2(5);
		
		assertSame(10, c.producto());
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void givenN1Mayor100WhenProductoThenException(){
		int x = 101;
		int y = 101;
		Calculator c = new Calculator();
		c.setNumero1(x);
		c.setNumero2(y);
		
		assertSame(2, c.producto());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void givenN2Mayor100WhenProductoThenException(){
		int x = 10;
		int y = 101;
		Calculator c = new Calculator();
		c.setNumero1(x);
		c.setNumero2(y);
		
		assertSame(2, c.producto());
	}
	
	
	@Test()
	public void testDivision(){
		Calculator c = new Calculator();
		c.setNumero1(4);
		c.setNumero2(2);
		
		assertSame(2, c.division());
		
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void givenN1Mayor100WhenDivisionThenException(){
		int x = 101;
		int y = 101;
		Calculator c = new Calculator();
		c.setNumero1(x);
		c.setNumero2(y);
		
		assertSame(2, c.division());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void givenN2Mayor100WhenDivisionThenException(){
		int x = 10;
		int y = 101;
		Calculator c = new Calculator();
		c.setNumero1(x);
		c.setNumero2(y);
		
		assertSame(2, c.division());
	}
	
	
	
	@Test()
	public void givenN1ThenGetX1ThenN1(){
		Calculator c = new Calculator();
		c.setNumero1(2);
		
		assertSame(2, c.getNumero1());
		
	}
	
	@Test()
	public void givenN2ThenGetX2ThenN2(){
		Calculator c = new Calculator();
		c.setNumero2(2);
		
		assertSame(2, c.getNumero2());
		
	}
	
}
