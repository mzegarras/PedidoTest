package net.msonic.pedidos.rest.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
	
	public Pedido(){
		detalle = new ArrayList<PedidoItem>();
	}
	private Cliente cliente;
	private Empleado empleado;
	private Date fechaPedido;
	private List<PedidoItem> detalle;
	private double descuento;
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public Date getFechaPedido() {
		return fechaPedido;
	}
	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	public List<PedidoItem> getDetalle() {
		return detalle;
	}
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	
	

}
