package net.msonic.pedidos.rest;

public class Calculator {
	
	
	private int numero1;
	private int numero2;
	
	public int getNumero1() {
		return numero1;
	}
	public void setNumero1(int numero1) {
		this.numero1 = numero1;
	}
	public int getNumero2() {
		return numero2;
	}
	public void setNumero2(int numero2) {
		this.numero2 = numero2;
	}
	
	
	
	public int sumar(){
		
		if(numero1>100 ||numero2>=100)
			throw new IllegalArgumentException();
		
		return numero1 + numero2;
	}
	
	public int restar(){
		
		if(numero1>100 ||numero2>=100)
			throw new IllegalArgumentException();
		
		return numero1 - numero2;
	}
	
	public int producto(){
		if(numero1>100 ||numero2>=100)
			throw new IllegalArgumentException();
		return numero1 * numero2;
	}

	public int division(){
		if(numero1>100 ||numero2>=100)
			throw new IllegalArgumentException();
		return numero1 / numero2;
	}

	
}
