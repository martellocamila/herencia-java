package modelo;

public abstract class Producto {
	protected int idProducto;
	protected int codigo;
	protected String nombre;
	protected float precio;
	protected Categoria categoria;
	protected int cantidadDisponible;
	
	public Producto(int idProducto, int codigo, String nombre, float precio, Categoria categoria,
			int cantidadDisponible) {
		super();
		this.idProducto = idProducto;
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
		this.cantidadDisponible = cantidadDisponible;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getCantidadDisponible() {
		return cantidadDisponible;
	}

	public void setCantidadDisponible(int cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}

	@Override
	public String toString() {
		return "\nProducto [idProducto=" + idProducto + ", codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio
				+ ", categoria=" + categoria + ", cantidadDisponible=" + cantidadDisponible + "]";
	}
	
	public abstract boolean esNecesarioReabastecer();
	
}
