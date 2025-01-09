package modelo;

public class ProductoNoPerecedero extends Producto {
	private int mesesGarantia;
	private int cantidadMinima;
	
	public ProductoNoPerecedero(int idProducto, int codigo, String nombre, float precio, Categoria categoria,
			int cantidadDisponible, int mesesGarantia, int cantidadMinima) {
		super(idProducto, codigo, nombre, precio, categoria, cantidadDisponible);
		this.mesesGarantia = mesesGarantia;
		this.cantidadMinima = cantidadMinima;
	}

	public int getMesesGarantia() {
		return mesesGarantia;
	}

	public void setMesesGarantia(int mesesGarantia) {
		this.mesesGarantia = mesesGarantia;
	}

	public int getCantidadMinima() {
		return cantidadMinima;
	}

	public void setCantidadMinima(int cantidadMinima) {
		this.cantidadMinima = cantidadMinima;
	}

	@Override
	public String toString() {
		return super.toString() + "ProductoNoPerecedero [mesesGarantia=" + mesesGarantia + ", cantidadMinima=" + cantidadMinima + "]";
	}	
	
	public boolean esNecesarioReabastecer() {
		boolean reabastecer = false;
		
		if(this.cantidadDisponible < this.cantidadMinima) {
			reabastecer = true;
		}
		
		return reabastecer;
	}
	
}
