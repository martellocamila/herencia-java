package test;

import java.time.LocalDate;

import modelo.Sistema;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sistema sistema = new Sistema();
		
		sistema.agregarCategoria("Bebidas");
		sistema.agregarCategoria("Almacen");
		sistema.agregarCategoria("Decoracion");
		
		System.out.println("1) " + sistema.getLstCategorias());
		
		try {
			sistema.agregarProductoPerecedero(1001, "Yogurt", 900, sistema.traerCategoria("Bebidas"), LocalDate.of(2024, 10, 20), true);
			sistema.agregarProductoPerecedero(1002, "Agua", 1000, sistema.traerCategoria("Bebidas"), LocalDate.of(2024, 11, 20), false);
			sistema.agregarProductoPerecedero(2001, "Arroz", 1000, sistema.traerCategoria("Almacen"), LocalDate.of(2025, 1, 1), false);
			sistema.agregarProductoPerecedero(3001, "Pegamento", 8000, sistema.traerCategoria("Decoracion"), LocalDate.of(2024, 10, 18), false);
			sistema.agregarProductoNoPerecedero(3002, "Lija", 250, sistema.traerCategoria("Decoracion"), 5, 10);
			sistema.agregarProductoNoPerecedero(3003, "Martillo", 600, sistema.traerCategoria("Decoracion"), 12, 5);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("2) " + sistema.getLstProductos());
		
		try {
			sistema.agregarMovimientoInventario(sistema.traerProducto(1001), LocalDate.of(2024, 10, 10), 50);
			sistema.agregarMovimientoInventario(sistema.traerProducto(1002), LocalDate.of(2024, 10, 10), 30);
			sistema.agregarMovimientoInventario(sistema.traerProducto(2001), LocalDate.of(2024, 10, 10), 80);
			sistema.agregarMovimientoInventario(sistema.traerProducto(3001), LocalDate.of(2024, 10, 10), 40);
			sistema.agregarMovimientoInventario(sistema.traerProducto(3002), LocalDate.of(2024, 10, 10), 11);
			sistema.agregarMovimientoInventario(sistema.traerProducto(3003), LocalDate.of(2024, 10, 10), 40);
			sistema.agregarMovimientoInventario(sistema.traerProducto(1001), LocalDate.of(2024, 10, 13), -10);
			sistema.agregarMovimientoInventario(sistema.traerProducto(1002), LocalDate.of(2024, 10, 13), -4);
			sistema.agregarMovimientoInventario(sistema.traerProducto(3002), LocalDate.of(2024, 10, 13), -3);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("3) " + sistema.getLstMovimientos());
		
		System.out.println("4)" + sistema.traerVentasDeProducosRefrigerados(LocalDate.of(2024, 10, 13)));
		
		System.out.println("5) " + sistema.traerProductosAReabastecer(sistema.traerCategoria("Decoracion")));
		
		try {
			sistema.agregarProductoPerecedero(1001, "Yogurt", 900, sistema.traerCategoria("Bebidas"), LocalDate.of(2024, 10, 20), true);
		} catch(Exception e) {
			System.out.println("6) " + e.getMessage());
		}
		
		try {
			sistema.agregarMovimientoInventario(sistema.traerProducto(3003), LocalDate.of(2024, 10, 13), -50);
		} catch(Exception e) {
			System.out.println("7) " + e.getMessage());
		}
	}

}
