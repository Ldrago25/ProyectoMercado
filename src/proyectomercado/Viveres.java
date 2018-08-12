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
public class Viveres extends Producto{
    
    
    private String marca;
    
    public Viveres(String codigo, String descripcion, float precio, int cantidad, float precioC) {
        super(codigo, descripcion, precio, cantidad,precioC);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

}
