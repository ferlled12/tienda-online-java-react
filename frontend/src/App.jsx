import { useState, useEffect } from 'react';

function App() {
  // variables de estado
  // guardamos los datos del carrito que nos devuelva el servidor
  const [carrito, setCarrito] = useState({ items: [] });
  // guardamos el total a pagar
  const [total, setTotal] = useState(0);

  // lista de productos simulada para que el usuario pueda elegir
  const productosDisponibles = [
    { id: "P01", nombre: "Teclado mecánico", precio: 45.50 },
    { id: "P02", nombre: "Ratón inalámbrico", precio: 25.00 },
    { id: "P03", nombre: "Monitor 24 pulgadas", precio: 120.00 }
  ];

  // función para leer el carrito (petición GET)
  const cargarCarrito = async () => {
    try {
      // hacemos la petición a nuestro servidor Java
      const respuesta = await fetch('http://localhost:8080/api/carrito');
      const datos = await respuesta.json();
      setCarrito(datos); // Actualizamos el estado con los datos del servidor
      
      // cargamos también el total
      const respuestaTotal = await fetch('http://localhost:8080/api/carrito/total');
      const datosTotal = await respuestaTotal.json();
      setTotal(datosTotal);
    } catch (error) {
      console.error("Error al cargar el carrito:", error);
    }
  };

  // función para añadir poroductos (petición POST)
  const agregarAlCarrito = async (producto) => {
    try {
      // configuramos la petición para enviar datos
      await fetch('http://localhost:8080/api/carrito/agregar', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json', // indicamos que enviamos JSON
        },
        body: JSON.stringify(producto), // convertimos el objeto del producto a texto JSON
      });
      
      // una vez añadido en el servidor, volvemos a cargar el carrito para ver los cambios
      cargarCarrito();
    } catch (error) {
      console.error("Error al añadir el producto:", error);
    }
  };

// función para vaciar el carrito (petición DELETE)
  const vaciarCarrito = async () => {
    try {
      await fetch('http://localhost:8080/api/carrito/limpiar', {
        method: 'DELETE',
      });
      // una vez borrado en el servidor, recargamos para que la pantalla se actualice (y el total vuelva a 0)
      cargarCarrito();
    } catch (error) {
      console.error("Error al vaciar el carrito:", error);
    }
  };

  // useEffect: Se ejecuta una sola vez al cargar la página para mostrar el carrito inicial
  useEffect(() => {
    cargarCarrito();
  }, []);

  // interfaz de usuario (HTML/JSX)
  return (
    <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
      <h1>Mi tienda online</h1>
      
      {/* Sección del catálogo */}
      <h2>Catálogo de productos</h2>
      <div style={{ display: 'flex', gap: '10px' }}>
        {productosDisponibles.map((prod) => (
          <div key={prod.id} style={{ border: '1px solid #ccc', padding: '10px', borderRadius: '5px' }}>
            <h3>{prod.nombre}</h3>
            <p>Precio: {prod.precio}€</p>
            <button onClick={() => agregarAlCarrito(prod)}>Añadir al carrito</button>
          </div>
        ))}
      </div>

      <hr style={{ margin: '30px 0' }} />

 {/* Sección del carrito */}
      <div style={{ display: 'flex', alignItems: 'center', gap: '20px' }}>
        <h2>Tu carrito</h2>
        <button 
          onClick={vaciarCarrito} 
          style={{ backgroundColor: '#ff4c4c', color: 'white', border: 'none', padding: '5px 10px', borderRadius: '5px', cursor: 'pointer' }}
        >
          🗑️ Vaciar carrito
        </button>
      </div>
      
      {carrito.items && carrito.items.length === 0 ? (
        <p>El carrito está vacío.</p>
      ) : (
        <ul>
          {carrito.items.map((item, index) => (
            <li key={index}>
              {item.producto.nombre} - Cantidad: {item.cantidad} - Subtotal: {item.subtotal}€
            </li>
          ))}
        </ul>
      )}
      
      <h3>Total a pagar: {total}€</h3>
    </div>
  );
}

export default App;