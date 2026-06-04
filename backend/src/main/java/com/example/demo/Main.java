package com.example.demo;
public class Main {
    public static void main(String[] args) {
        // creamos algunos productos
        Producto teclado = new Producto("P01", "Teclado mecánico", 45.50);
        Producto raton = new Producto("P02", "Ratón inalámbrico", 25.00);

        // inicializamos un carrito vacío
        Carrito miCarrito = new Carrito();

        // el usuario añade productos al carrito
        miCarrito.agregarProducto(teclado, 1);
        miCarrito.agregarProducto(raton, 2);
        
        // simulamos que el usuario vuelve a añadir otro teclado
        miCarrito.agregarProducto(teclado, 1);

        // mostramos el resultado final por pantalla
        miCarrito.mostrarCarrito();
    }
}