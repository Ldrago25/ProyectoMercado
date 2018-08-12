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
public class Carne extends Producto implements Unidad {

    private String unidad;

    public Carne(String codigo, String descripcion, float precio, int cantidad, float precioC) {
        super(codigo, descripcion, precio, cantidad, precioC);
        unidad = KILOGRAMO;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

}
