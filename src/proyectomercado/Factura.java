/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomercado;

/**
 *
 * @author Alex
 */
public class Factura {

    private String cedula;
    private Producto productos[];
    private float total_s_iva;
    private float total_c_iva;
    private float total;
    private float total_iva;

    public Factura(String cedula, int cantidad) {

        this.cedula = cedula;
        productos = new Producto[cantidad];
    }

    public void nuevaFactura() {
        System.out.println("Ingrese su nombre cliente bueno no, la verdad no me interesa su nombre");
        //leer cantidad de productos
    }

    public void agregarProducto(Producto p, int i) {
        productos[i] = p;
    }

    public void getTotal() {
        
        for (int i = 0; i < productos.length; i++) {
            if (productos[i] instanceof Carne || productos[i] instanceof Lacteo) {
                total_s_iva += productos[i].getPrecio() * productos[i].getCantidad();
            } else if (productos[i] instanceof Enlatado || productos[i] instanceof Viveres) {
                total_c_iva += productos[i].getPrecio() * productos[i].getCantidad();
                total_c_iva += total_c_iva * 0.12;
                total_iva = (float) (productos[i].getPrecio() * productos[i].getCantidad() *0.12);
            }
        }
        this.total = total_s_iva + total_c_iva;
        total=this.total;
    }

    /*public boolean comprobacion(int cant) {

        for (int i = 0; i < cant; i++) {

            if (productos[i] != null) {
                return true;
            }
        }
        return false;
    }*/

    public void mostrarTotales() {
        System.out.println("Total de productos con iva = "+this.total_c_iva);
        System.out.println("Total de productos sin iva = "+this.total_s_iva);
        System.out.println("Total a pagar = " + this.total);
        System.out.println("El iva total aplicado a la venta = "+this.total_iva);
    }
    
    public float Ganancia(){
        return this.total;
    }
}
