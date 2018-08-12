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
public class Producto implements Comparable<Producto>{

    private String codigo;
    private String descripcion;
    private float precio;
    private float precioC;
    private int cantidad;
    private int cant_B;
    private int vendido;

    public Producto(String codigo, String descripcion, float precio, int cantidad, float precioC) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        cant_B = cantidad;
        this.precioC = precioC;
        vendido = 0;
    }

    public int getVendido() {
        return vendido;
    }

    public void setVendido(int vendido) {
        this.vendido = vendido;
    }

    public float getPrecioC() {
        return precioC;
    }

    public void setPrecioC(float precioC) {
        this.precioC = precioC;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", precio=" + precio + ", cantidad=" + cantidad + '}';
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public void quitar(int cant){
        cantidad -= cant;
        vendido +=cant;
    }

    @Override
    public int compareTo(Producto o) {
        if (vendido > o.vendido) {
                return -1;
            }
            if (vendido < o.vendido) {
                return 1;
            }
            return 0;
    }
    
    public void imprimirVendido(){
        System.out.println("se vendieron : " + vendido  + " unidades de " + descripcion);
    }
}
