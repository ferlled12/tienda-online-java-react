package com.example.demo;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
    // usamos una lista para guardar todos los artículos del carrito
    private List<ItemCarrito> items;

    public Carrito() {
        this.items = new ArrayList<>();
    }

    // método para añadir un producto al carrito
    public void agregarProducto(Producto producto, int cantidad) {
        // primero, comprobamos si el producto ya está en el carrito
        for (ItemCarrito item : items) {
            if (item.getProducto().getId().equals(producto.getId())) {
                // si ya existe, simplemente sumamos la nueva cantidad
                item.setCantidad(item.getCantidad() + cantidad);
                return; // Salimos del método
            }
        }
        // si el bucle termina y no estaba, lo añadimos como un artículo nuevo
        items.add(new ItemCarrito(producto, cantidad));
    }

    // método que recorre la lista sumando los subtotales para obtener el precio final
    public double calcularTotal() {
        double total = 0;
        for (ItemCarrito item : items) {
            total += item.getSubtotal();
        }
        return total;
    }
    
    // muestra un recibo sencillo por la consola
    public void mostrarCarrito() {
        System.out.println("--- Tu Carrito de la Compra ---");
        for (ItemCarrito item : items) {
            System.out.println(item.getProducto().getNombre() +
                               " x" + item.getCantidad() +
                               " - Subtotal: " + item.getSubtotal() + "€");
        }
        System.out.println("Total a pagar: " + calcularTotal() + "€");
        System.out.println("-------------------------------");
    }

// método Getter necesario para que Spring Boot exporte la lista a formato JSON
    public List<ItemCarrito> getItems() {
        return items;
    }
// método para vaciar la lista por completo
    public void vaciarCarrito() {
        items.clear(); // función para vaciar una lista
    }
}