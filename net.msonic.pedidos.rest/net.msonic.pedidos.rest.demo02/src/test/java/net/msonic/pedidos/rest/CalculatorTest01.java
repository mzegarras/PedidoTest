package net.msonic.pedidos.rest;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;

public class CalculatorTest01 {

	@Test()
	public void test01() {
		//assertThat(Object object,Matcher matcher)
		//matcher .- es una implemtación de org.hamcrest.Matcher
		int edad = 5;
		
		assertThat(edad, is(5));
		assertThat(edad, equalTo(5));
		assertThat(edad, not(equalTo(15)));
		assertThat(edad, is(not(15)));
		
	}
	
	
	@Test()
	public void test02() {
		int edad = 10;		
		assertThat(edad, either(is(5)).or(is(10)));
		assertThat(edad, both(not(is(15))).and(not(is(20))));
		assertThat(edad, anyOf(is(15),is(10),is(25)));
	}
	
	
	@Test()
	public void test03ListTest() {
		List<Double> salario=Arrays.asList(50.0,20.0,500.0);
		
		assertThat(salario, hasItem(50.0));
		assertThat(salario, hasItems(50.0,20.0));
		assertThat(salario, not(hasItem(80.0)));
		
	}

	@Test()
	public void test04StringTest() {
		String name="Moises Android ios";
		
		assertThat(name, startsWith("Moises"));
		assertThat(name, endsWith("ios"));
		assertThat(name, containsString("Android"));
		
	}
	
}
