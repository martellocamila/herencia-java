package modelo;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class Sistema {
	private List<Producto> lstProductos;
	private List<Categoria> lstCategorias;
	private List<MovimientoInventario> lstMovimientos;
	
	public Sistema() {
		this.lstProductos = new ArrayList<Producto>();
		this.lstCategorias = new ArrayList<Categoria>();
		this.lstMovimientos = new ArrayList<MovimientoInventario>();
	}

	public List<Producto> getLstProductos() {
		return lstProductos;
	}

	public void setLstProductos(List<Producto> lstProductos) {
		this.lstProductos = lstProductos;
	}

	public List<Categoria> getLstCategorias() {
		return lstCategorias;
	}

	public void setLstCategorias(List<Categoria> lstCategorias) {
		this.lstCategorias = lstCategorias;
	}

	public List<MovimientoInventario> getLstMovimientos() {
		return lstMovimientos;
	}

	public void setLstMovimientos(List<MovimientoInventario> lstMovimientos) {
		this.lstMovimientos = lstMovimientos;
	}

	@Override
	public String toString() {
		return "Sistema [lstProductos=" + lstProductos + ", lstCategorias=" + lstCategorias + ", lstMovimientos="
				+ lstMovimientos + "]";
	}
	
	public Categoria traerCategoria(String nombre) {
		Categoria buscado = null;
		int i = 0;
		
		while(i < this.lstCategorias.size() && buscado == null) {
			if(this.lstCategorias.get(i).getNombre().equals(nombre)) {
				buscado = this.lstCategorias.get(i);
			}
			i++;
		}
		
		return buscado;	
	}
	
	public boolean agregarCategoria(String nombre) {
		return this.lstCategorias.add(new Categoria(nombre));
	}
	
	public Producto traerProducto(int codigo) {
		Producto buscado = null;
		int i = 0;
		
		while(i < this.lstProductos.size() && buscado == null) {
			if(this.lstProductos.get(i).getCodigo() == codigo) {
				buscado = this.lstProductos.get(i);
			}
			i++;
		}
		
		return buscado;
		
	}
	
	public boolean agregarProductoNoPerecedero(int codigo, String nombre, float precio, Categoria categoria, int mesesGarantia, int cantidadMinima) throws Exception {
		if(this.traerProducto(codigo) != null) {
			throw new Exception("ERROR: Ya existe un producto con ese codigo");
		}
		
		int id = 1;
		
		if(this.lstProductos.size() > 0) {
			id = this.lstProductos.get(this.lstProductos.size() - 1).getIdProducto() + 1;
		}
		
		return this.lstProductos.add(new ProductoNoPerecedero(id, codigo, nombre, precio, categoria, 0, mesesGarantia, cantidadMinima));
	}
	
	public boolean agregarProductoPerecedero(int codigo, String nombre, float precio, Categoria categoria, LocalDate fechaVencimiento, boolean requiereRefrigeracion) throws Exception {
		if(this.traerProducto(codigo) != null) {
			throw new Exception("ERROR: Ya existe un producto con ese codigo");
		}
		
		int id = 1;
		
		if(this.lstProductos.size() > 0) {
			id = this.lstProductos.get(this.lstProductos.size() - 1).getIdProducto() + 1;
		}
		
		return this.lstProductos.add(new ProductoPerecedero(id, codigo, nombre, precio, categoria, 0, fechaVencimiento, requiereRefrigeracion));
	}
	
	public boolean agregarMovimientoInventario(Producto producto, LocalDate fecha, int cantidad) throws Exception {
		int id = 1;
		
		if(this.lstMovimientos.size() > 0) {
			id = this.lstMovimientos.get(this.lstMovimientos.size() - 1).getIdMovimientoInventario() + 1;
		}
		
		Producto buscado = this.traerProducto(producto.getCodigo());
		
		buscado.setCantidadDisponible(buscado.getCantidadDisponible() + cantidad);
		
		return this.lstMovimientos.add(new MovimientoInventario(id, producto, fecha, cantidad));
	}
	
	public List<MovimientoInventario> traerVentas(LocalDate fechaDesde, LocalDate fechaHasta) {
		List<MovimientoInventario> buscados = new ArrayList<MovimientoInventario>();
		
		for(MovimientoInventario m : this.lstMovimientos) {
			if(m.getCantidad() < 0) {
				if((m.getFecha().isAfter(fechaDesde) && m.getFecha().isBefore(fechaHasta)) || m.getFecha().equals(fechaDesde) || m.getFecha().equals(fechaHasta)) {
					buscados.add(m);
				}
			}
		}
			
		return buscados;
	}
	
	public List<MovimientoInventario> traerVentasDeProducosRefrigerados(LocalDate fecha) {
		List<MovimientoInventario> vendidos =  this.traerVentas(fecha, fecha);
		List<MovimientoInventario> buscados = new ArrayList<MovimientoInventario>();
		
		for(MovimientoInventario m : vendidos) {
			if(m.getProducto() instanceof ProductoPerecedero) {
				if(((ProductoPerecedero) m.getProducto()).isRequiereRefrigeracion()) {
					buscados.add(m);
				}
			}
		}
		
		return buscados;
	}
	
	public List<Producto> traerProductosAReabastecer(Categoria categoria) {
		List<Producto> buscados = new ArrayList<Producto>();
		
		for(Producto producto : this.lstProductos) {
			if(producto instanceof ProductoNoPerecedero) {
				if(producto.getCategoria().equals(categoria)) {
					if(((ProductoNoPerecedero)producto).esNecesarioReabastecer()) {
						buscados.add(producto);
					}
				}
			}
			
		}
		
		return buscados;
	} 
} 
