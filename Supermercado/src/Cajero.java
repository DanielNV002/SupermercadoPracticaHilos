import java.util.concurrent.Semaphore;

public class Cajero implements Runnable{

    private String nombre;
    private Semaphore sem;

    public Cajero(String nombre){
        this.nombre = nombre;
        this.sem = new Semaphore(1); //SOLO PASA UN CLIENTE POR CAJA
    }

    public void pasarPorCaja(Cliente c) throws InterruptedException{
        sem.acquire(); //SOLO PASA UN CLIENTE A LA VEZ

        long tempInicio = System.currentTimeMillis(); //COMIENZA TIEMPO DE ATENDER
        System.out.println("Cajero " + nombre + " empieza a atencer a " + c.getNombre());

        for (Producto p: c.getCompra()){
            long tempInicioProducto = System.currentTimeMillis(); //COMIENZA TIEMPO EN LOS PRODUCTOS
            System.out.println("Cajero " + nombre + " empieza a procesar el producto " + p.getNombre() + " de " + c.getNombre());

            Thread.sleep(500); //TIEMPO QUE SIMULA EL PRODUCTO

            System.out.println("Cajero " + nombre + " procesó  el producto " + p.getNombre() + " de " + c.getNombre());
            sem.release();
        }
    }

    @Override
    public void run() {

    }
}