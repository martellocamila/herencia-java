package modelo;

import java.time.LocalDate;

public class MovimientoInventario {
	private int idMovimientoInventario;
	private Producto producto;
	private LocalDate fecha;
	private int cantidad;
	
	public MovimientoInventario(int idMovimientoInventario, Producto producto, LocalDate fecha, int cantidad) throws Exception {
		this.idMovimientoInventario = idMovimientoInventario;
		this.producto = producto;
		this.fecha = fecha;
		this.setCantidad(cantidad);
	}

	public int getIdMovimientoInventario() {
		return idMovimientoInventario;
	}

	public void setIdMovimientoInventario(int idMovimientoInventario) {
		this.idMovimientoInventario = idMovimientoInventario;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) throws Exception {
		if(cantidad + this.producto.getCantidadDisponible() < 0) {
			throw new Exception("ERROR: No se puede restar una cantidad inferior a la disponible");
		}
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "\nMovimientoInventario [idMovimientoInventario=" + idMovimientoInventario + ", producto=" + producto
				+ ", fecha=" + fecha + ", cantidad=" + cantidad + "]";
	}
	
	
}
