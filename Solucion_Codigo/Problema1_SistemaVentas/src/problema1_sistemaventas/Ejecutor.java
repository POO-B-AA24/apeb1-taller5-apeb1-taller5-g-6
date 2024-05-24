package problema1_sistemaventas;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class Ejecutor {
    public static void main(String[] args) {
        int numeroCompra = 1;
        int continuar;
        Scanner tc = new Scanner(System.in);

        do {

            ArrayList<Producto> producto = new ArrayList<>();
            CarritoDeCompras carrito = new CarritoDeCompras();
            System.out.println("Ingrese el numero de productos que va a comprar");
            int nProductos = tc.nextInt();
            for (int i = 0; i < nProductos; i++) {
                producto.add(new Producto(productosAleat(), precioAleat(), unidadesAleat()));
                carrito.agregarProducto(producto.get(i));
            }
            System.out.println(carrito.mostrarDetalleCompra());
            carrito.calcularTotal();
            System.out.println("SU TOTAL ES: " + carrito.getTotal() + "\nCUANTO VA A PAGAR? ");
            double pago = tc.nextDouble();
            System.out.println(carrito.realizarPago(pago));
            System.out.println("QUIERE SEGUIR COMPRANDO? [1]SI / [2]NO");
            continuar = tc.nextInt();
            if (continuar == 1) {
                numeroCompra++;
            }
        } while (continuar == 1);
    }
    public static String productosAleat() {
        Random aleatorio = new Random();
        int indiceAleatorio = aleatorio.nextInt((9 - 0) + 1) + 0;
        String productos[] = {"lapicez", "borradores", "esferos", "hojas", "grapas", "sacapuntas", "gomas", "tijeras", "notas", "reglas"};
        return productos[indiceAleatorio];
    }
    public static int unidadesAleat() {
        Random aleatorio = new Random();
        int numero = aleatorio.nextInt((10 - 1) + 1) + 1;
        return numero;
    }
    public static double precioAleat() {
        Random aleatorio = new Random();
        double numero = 1 + (10 - 1) * aleatorio.nextDouble();
        return numero;
    }
}






class Producto {
    public String nombre;
    public double precio;
    public int cantidad;
    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    public String getNombre() {
        return nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}




class CarritoDeCompras {
    public ArrayList<Producto> productos;
    public double total;
    public CarritoDeCompras() {
        productos = new ArrayList<>();
    }
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }
    public void calcularTotal() {
        for (int i = 0; i < productos.size(); i++) {
            this.total += productos.get(i).getPrecio() * productos.get(i).getCantidad();
        }
    }
    public String realizarPago(double montoPagado) {
        if (this.total >= 1000) {
            this.total = this.total * 0.9;
            return "APLICA DESCUENTO DEL 10% AL SUPERAR LOS 1000$\n" + "TOTAL: " + this.total;

        }
        if (montoPagado >= total) {
            return "PAGO ACEPTADO\n" + "VUELTO: " + (montoPagado - this.total);

        } else {
            return "FALTAN: " + (this.total - montoPagado);

        }
    }
    public String mostrarDetalleCompra() {
        String mostrarMensaje = "FACTURA: ";
        for (int i = 0; i < productos.size(); i++) {
            mostrarMensaje += "\nNombre del producto: " + productos.get(i).getNombre() + "   -   Numero de unidades: "
                    + productos.get(i).getCantidad() + "   -   Precio por unidad: " + productos.get(i).getPrecio();
        }
        return mostrarMensaje;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
}
