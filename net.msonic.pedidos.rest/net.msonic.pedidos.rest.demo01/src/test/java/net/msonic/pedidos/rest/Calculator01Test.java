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
}
