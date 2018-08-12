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
public class Lacteo extends Producto implements Unidad {

    private String unidad;
    private boolean solido;

    public Lacteo(String codigo, String descripcion, float precio, int cantidad, boolean solido, float precioC) {
        super(codigo, descripcion, precio, cantidad, precioC);
        this.solido = solido;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public boolean isSolido() {
        return solido;
    }

    public void setSolido(boolean solido) {
        this.solido = solido;
    }

}
