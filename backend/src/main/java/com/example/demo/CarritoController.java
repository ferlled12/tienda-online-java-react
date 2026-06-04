package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carrito")
@CrossOrigin(origins = "*") // <- ESTA LÍNEA ES VITAL
public class CarritoController {
    // ... resto de tu código

    // instanciamos nuestro carrito. En una aplicación real, esto iría en una capa de Servicio.
    private Carrito miCarrito = new Carrito();

    // método GET para obtener los datos del carrito
    // se accederá a él entrando en: http://localhost:8080/api/carrito
    @GetMapping
    public Carrito verCarrito() {
        // Spring Boot convierte automáticamente nuestro objeto Carrito a formato JSON
        return miCarrito;
    }

    // método POST para añadir un producto al carrito
    // se accederá a él enviando datos a: http://localhost:8080/api/carrito/agregar
    @PostMapping("/agregar")
    public String agregarProducto(@RequestBody Producto producto) {
        // Añadimos el producto que nos llega desde el cliente. Asumimos cantidad 1 por defecto.
        miCarrito.agregarProducto(producto, 1);
        return "Producto añadido correctamente al carrito";
    }
    
    // método GET para obtener el total a pagar
    @GetMapping("/total")
    public double obtenerTotal() {
        return miCarrito.calcularTotal();
    }
// usamos @DeleteMapping porque la acción consiste en borrar datos
    @DeleteMapping("/limpiar")
    public String limpiarCarrito() {
        miCarrito.vaciarCarrito();
        return "El carrito se ha vaciado correctamente";
    }
}