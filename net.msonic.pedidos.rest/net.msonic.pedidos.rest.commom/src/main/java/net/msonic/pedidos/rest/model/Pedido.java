package net.msonic.pedidos.rest.model;

import java.util.Date;
import java.util.List;

public class Pedido {
	
	private Cliente cliente;
	private Empleado empleado;
	private Date fechaPedido;
	private List<PedidoItem> detalle;
	
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
	public void setDetalle(List<PedidoItem> detalle) {
		this.detalle = detalle;
	}
	
	
	

}
