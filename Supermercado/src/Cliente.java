import java.util.List;

public class Cliente implements Runnable{
    private String nombre;
    private List<Producto> compra;
    private Cajero cajero;

    public Cliente(String nombre, List<Producto> compra){
        this.nombre = nombre;
        this.compra = compra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Producto> getCompra() {
        return compra;
    }

    public void setCompra(List<Producto> compra) {
        this.compra = compra;
    }

    public Cajero getCajero() {
        return cajero;
    }

    public void setCajero(Cajero cajero) {
        this.cajero = cajero;
    }


    @Override
    public void run() {
        try {
            cajero.pasarPorCaja(this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
