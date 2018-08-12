/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomercado;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */
public class Almacen {

    public static int N = 100;
    private Producto productos[];
    private int i;
    private int iva;
    BufferedReader entrada;

    public Almacen() {
        entrada = new BufferedReader(new InputStreamReader(System.in));
        productos = new Producto[N];
        i = 0;
    }

    public void addProduct(Producto p) {
        try {
            productos[i] = p;
            i++;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Ay se bugeo v:");
            System.err.println("" + e.getMessage());
        }
    }

    public boolean checklist(String codigo) {

        if (productos.length > 0) {

            for (int i = 0; i < productos.length; i++) {

                if (productos[i] != null) {
                    if (productos[i].getCodigo().equals(codigo)) {
                        System.err.println("Error, hay un producto con ese mismo codigo");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean modificacion(String codigo) {

        String numero = "0";

        for (int i = 0; i < productos.length; i++) {

            if (productos[i] != null) {
                if (productos[i].getCodigo().equals(codigo)) {

                    System.out.println("Ingrese la cantidad nueva a agregar");
                    try {
                        numero = entrada.readLine();
                    } catch (IOException ex) {
                        Logger.getLogger(Almacen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    numero += productos[i].getCantidad();
                    productos[i].setCantidad(Integer.parseInt(numero));
                    productos[i].toString();
                    return true;
                }
            }
        }
        return false;

    }

    public boolean revision(int n, String codigo, int i) {
        System.out.println("comparando: " + n + " con " + productos[i].getCantidad());
        if (productos[i].getCodigo().equals(codigo) && n > productos[i].getCantidad()) {
            System.err.println("No hay tantos productos de esa categoría");
            return false;
        }
        return true;
    }

    public Producto buscar(String codigo, int cant) {

        for (int j = 0; j < productos.length; j++) {
            if (productos[j] != null) {
                if (productos[j].getCodigo().equals(codigo) && revision(cant, codigo, j)) {
                    productos[j].quitar(cant);

                    if (productos[j] instanceof Carne) {
                        return new Carne(productos[j].getCodigo(),
                                productos[j].getDescripcion(),
                                productos[j].getPrecio(),
                                cant,
                                productos[j].getPrecioC());
                    } else if (productos[j] instanceof Enlatado) {
                        return new Enlatado(productos[j].getCodigo(),
                                productos[j].getDescripcion(),
                                productos[j].getPrecio(), cant, ((Enlatado) productos[j]).getMarca(), productos[j].getPrecioC());
                    } else if (productos[j] instanceof Lacteo) {
                        return new Lacteo(productos[j].getCodigo(),
                                productos[j].getDescripcion(),
                                productos[j].getPrecio(), cant, ((Lacteo) productos[j]).isSolido(), productos[j].getPrecioC());
                    } else if (productos[j] instanceof Viveres) {
                        return new Viveres(productos[j].getCodigo(),
                                productos[j].getDescripcion(),
                                productos[j].getPrecio(), cant, productos[j].getPrecioC());
                    }
                }
            }
        }

        return null;
    }

    public void calcularCompras() {
        float total = 0;
        for (int i = 0; i < productos.length; i++) {
            total += productos[i].getPrecioC();
        }
        System.out.println("Se gastó: " + total + " en ingreso de productos");
    }

    public void egresos() {
        float egresos = 0;
        for (int j = 0; j < productos.length; j++) {
            if (productos[j] != null) {
                egresos += productos[j].getPrecioC() * productos[j].getCantidad();
            }
        }
        System.out.println("Los gastos en productos es: " + egresos);
    }

    public void top10() {
        
        int size = 0;
        
        System.out.println("Imprimiendo productos:");

        for (int j = 0; j < i; j++) {
            if (productos[j] != null) {
                System.out.println(productos[j].toString());
            }
        }
        
        for (int j = 0; j < i; j++) {
            if (productos[j] != null) {
                if ((productos[j] instanceof Carne) || (productos[j] instanceof Lacteo)) {
                    size ++;
                }
            }
        }
        
        Producto vendidos[] = new Producto[size];


        int k = 0;
        for (int j = 0; j < i; j++) {
            System.out.println("j:" + j + " i: " + i);
            if (productos[j] != null) {
                if (productos[j] instanceof Carne) {
                    vendidos[k] = new Carne(productos[j].getCodigo(),
                            productos[j].getDescripcion(),
                            productos[j].getPrecio(),
                            productos[j].getCantidad(),
                            productos[j].getPrecioC());
                    vendidos[k].setVendido(productos[j].getVendido());
                    k++;
                } else if (productos[j] instanceof Lacteo) {
                    vendidos[k] = new Lacteo(productos[j].getCodigo(),
                            productos[j].getDescripcion(),
                            productos[j].getPrecio(),
                            productos[j].getCantidad(),
                            ((Lacteo) productos[j]).isSolido(),
                            productos[j].getPrecioC());
                    vendidos[k].setVendido(productos[j].getVendido());
                    k++;
                }
            } else {
                break;
            }
        }
        
        System.out.println("Imprimiendo VENDIDOS:");

        for (int j = 0; j < size; j++) {
            if (vendidos[j] != null) {
                System.out.println(vendidos[j].toString());
            }
        }

        Arrays.sort(vendidos);
        System.out.println("Imprimiento wea");
        for (int j = 0; j < 10; j++) {
            if (j < size) {
                if (vendidos[j] != null) {
                    //if ((vendidos[j] instanceof Carne) || (vendidos[j] instanceof Lacteo)) {
                    //System.out.println(vendidos[j].toString());
                    vendidos[j].imprimirVendido();
                    //}
                }
            } else {
                System.out.println("No hay mas productos");
                break;
            }
        }
    }

    public void menos() {
        System.out.println("La lista de productos de existencia baja");
        for (int j = 0; j < productos.length; j++) {
            if (productos[i] != null) {
                if (productos[j].getCantidad() < 10) {
                    productos[j].toString();
                }
            }
        }
    }

}
