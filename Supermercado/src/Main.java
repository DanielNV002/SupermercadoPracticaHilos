/*Se pide emular un supermercado trabajando con hilos.

Se dispondrá de dos personas en caja que cobrarán a cinco clientes diferentes.
Cada uno de esos clientes, tendrá un carrito de la compra donde tendrá máximo, cinco productos.
Cuando los clientes vayan pasando por las cajas, debemos de conocer el nombre de ese cliente, el producto que está pasando y en qué caja se encuentra.
En la salida, tiene que aparecer el tiempo que está procesando un cliente y un producto. Para ello, se utilizarán las funciones:

        System.currentTimeMillis() - this.initialTime*/


import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear productos
        Producto p1 = new Producto("Leche");
        Producto p2 = new Producto("Pan");
        Producto p3 = new Producto("Arroz");
        Producto p4 = new Producto("Fruta");
        Producto p5 = new Producto("Carne");

        // Crear clientes
        List<Producto> carritoCliente1 = Arrays.asList(p1, p2, p3);
        List<Producto> carritoCliente2 = Arrays.asList(p4, p5);
        List<Producto> carritoCliente3 = Arrays.asList(p1, p3, p5);
        List<Producto> carritoCliente4 = Arrays.asList(p2, p4);
        List<Producto> carritoCliente5 = Arrays.asList(p3, p5);

        Cliente cliente1 = new Cliente("Paco", carritoCliente1);
        Cliente cliente2 = new Cliente("Romero", carritoCliente2);
        Cliente cliente3 = new Cliente("Alicia", carritoCliente3);
        Cliente cliente4 = new Cliente("Juan", carritoCliente4);
        Cliente cliente5 = new Cliente("Maria", carritoCliente5);

        // Crear cajeros
        Cajero cajero1 = new Cajero("Manolo");
        Cajero cajero2 = new Cajero("Carmela");

        // Asignar cajeros a clientes
        cliente1.setCajero(cajero1);
        cliente2.setCajero(cajero1);
        cliente3.setCajero(cajero2);
        cliente4.setCajero(cajero2);
        cliente5.setCajero(cajero1);

        // Crear hilos para los clientes
        Thread t1 = new Thread(cliente1);
        Thread t2 = new Thread(cliente2);
        Thread t3 = new Thread(cliente3);
        Thread t4 = new Thread(cliente4);
        Thread t5 = new Thread(cliente5);

        // Iniciar hilos
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}