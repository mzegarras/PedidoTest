package net.msonic.pedidos.rest.model;

public class PedidoItem {
	
	
	private Producto producto;
	private double cantidad;
	private double precio;
	
	
	public double getTotal() {
		return cantidad * precio;
	}
	
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
