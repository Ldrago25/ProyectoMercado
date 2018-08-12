/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomercado;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import static proyectomercado.Almacen.N;

/**
 *
 * @author Alex
 */
public class Menu {

    /*variables o atributos aqui*/
    private int r = 0;
    private final Almacen bunker;
    BufferedReader entrada;
    private final Factura facturas[];

    public Menu() {
        /*definir weas aqui*/
        bunker = new Almacen();
        entrada = new BufferedReader(new InputStreamReader(System.in));
        facturas = new Factura[N];
    }

    public void Iniciar() {

        char opcion = 'X';
        String kk = "";
        do {
            do {
                System.out.println("Bienvenido al mercadito");
                System.out.println("¿que desea hacer?");
                System.out.println("A)Añadir un producto");
                System.out.println("B)Moodificar un producto");
                System.out.println("C)Facturar una venta");
                System.out.println("D)Ver los ingresos brutos");
                System.out.println("E)Ver egresos de la empresa");
                System.out.println("F)Exentos con más ventas");
                System.out.println("G)Productos escasos");
                System.out.println("X)Salir");
                try {
                    kk = entrada.readLine();
                    kk = kk.toUpperCase();
                } catch (IOException ex) {
                    System.err.println("Error al ingresar");
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (kk.equals("")) {
                    kk = "X";
                } else {
                    opcion = kk.charAt(0);
                }

            } while (opcion != 'A' && opcion != 'B' && opcion != 'B'
                    && opcion != 'C' && opcion != 'D' && opcion != 'E'
                    && opcion != 'F' && opcion != 'G' && opcion != 'X');

            switch (opcion) {
                case 'A':
                    agregarProducto();
                    break;

                case 'B':
                    modificarProducto();
                    break;
                case 'C':
                    facturarVenta();
                    break;
                case 'D':
                    verIngresos();
                    break;
                case 'E':
                    verEgresos();
                    break;
                case 'F':
                    masVentas();
                    break;
                case 'G':
                    menosProductos();
                    break;
                case 'X':
                    System.exit(0);
                    break;
            }
        } while (opcion != 'X');
    }

    public void agregarProducto() {

        Producto nuevo;
        String nombre = "";
        String codigo;
        String descrip;
        String precio;
        String precioC;
        String cantidad;
        String marca;
        String solido;
        boolean estado = false;

        try {
            System.out.println("Ingrese el tipo de producto a agregar");
            nombre = entrada.readLine();
        } catch (IOException e) {
            System.err.println("error en la entrada de datos");
        }

        nombre = nombre.toUpperCase();

        //cambiar por ifs
        if (nombre.equals("CARNE")) {
            try {
                System.out.println("Ingrese los datos de la carne");

                System.out.println("Codigo de 8 digitos");
                codigo = entrada.readLine();

                if (!bunker.checklist(codigo)) {
                    System.out.println("Descripcion del producto");
                    descrip = entrada.readLine();

                    System.out.println(" ingrese el precio de compra");
                    precioC = entrada.readLine();

                    System.out.println(" ingrese el precio de compra");
                    precio = entrada.readLine();

                    System.out.println("ingrese la cantidad");
                    cantidad = entrada.readLine();

                    nuevo = new Carne(codigo, descrip, Float.parseFloat(precio), Integer.parseInt(cantidad), Float.parseFloat(precioC));

                    bunker.addProduct(nuevo);
                }
            } catch (IOException e) {
                System.err.println("error en el ingreso de datos de carne");
            }
        } ///////////////////////////////////////////////////////////////////////////////////////
        else if (nombre.equals("ENLATADO")) {

            try {
                System.out.println("Ingrese los datos del enlatado");

                System.out.println("Codigo de 8 digitos");
                codigo = entrada.readLine();

                if (!bunker.checklist(codigo)) {
                    System.out.println("Descripcion del producto");
                    descrip = entrada.readLine();
                    System.out.println(" ingrese el precio de compra");
                    precioC = entrada.readLine();
                    System.out.println(" ingrese el precio de venta");
                    precio = entrada.readLine();
                    System.out.println(" ingrese la marca");
                    marca = entrada.readLine();
                    System.out.println("ingrese la cantidad");
                    cantidad = entrada.readLine();

                    nuevo = new Enlatado(codigo, descrip, Float.parseFloat(precio), Integer.parseInt(cantidad), marca, Float.parseFloat(precioC));

                    bunker.addProduct(nuevo);
                }
            } catch (IOException e) {
                System.err.println("error en el ingreso de datos del enlatado");
            }
        } //////////////////////////////////////////////////////////////////////////////////////    
        else if (nombre.equals("LACTEO")) {
            try {
                System.out.println("Ingrese los datos del lacteo");

                System.out.println("Codigo de 8 digitos");
                codigo = entrada.readLine();
                if (!bunker.checklist(codigo)) {
                    System.out.println("Descripcion del producto");
                    descrip = entrada.readLine();
                    System.out.println(" ingrese el precio de compra");
                    precioC = entrada.readLine();
                    System.out.println(" ingrese el precio de venta");
                    precio = entrada.readLine();
                    System.out.println("ingrese la cantidad");
                    cantidad = entrada.readLine();
                    System.out.println("ingrese el estado: Solido/Liquido");
                    solido = entrada.readLine();
                    solido = solido.toUpperCase();
                    if (solido.equals("SOLIDO")) {
                        estado = true;
                    }

                    nuevo = new Lacteo(codigo, descrip, Float.parseFloat(precio), Integer.parseInt(cantidad), estado, Float.parseFloat(precioC));

                    bunker.addProduct(nuevo);
                }
            } catch (IOException e) {
                System.err.println("error en el ingreso de datos de carne");
            }
        } //////////////////////////////////////////////////////////////////////////////////////
        else if (nombre.equals("VIVERES")) {
            try {
                System.out.println("Ingrese los datos de el viver :v");

                System.out.println("Codigo de 8 digitos");
                codigo = entrada.readLine();

                if (!bunker.checklist(codigo)) {

                    System.out.println("Descripcion del producto");
                    descrip = entrada.readLine();
                    System.out.println(" ingrese el precio de compra");
                    precioC = entrada.readLine();
                    System.out.println(" ingrese el precio de venta");
                    precio = entrada.readLine();
                    System.out.println("ingrese la cantidad");
                    cantidad = entrada.readLine();

                    nuevo = new Viveres(codigo, descrip, Float.parseFloat(precio), Integer.parseInt(cantidad), Float.parseFloat(precioC));

                    bunker.addProduct(nuevo);
                }
            } catch (IOException e) {
                System.err.println("error en el ingreso de datos de carne");
            }
        } else {
            System.out.println("No es un tipo de producto");
        }
        ////////////////////////////////////////////////////////////////////////////////////////
    }

    public void modificarProducto() {

        String codigoB = "";
        System.out.println("Ingrese el codigo del producto a modificar");

        try {
            codigoB = entrada.readLine();
        } catch (IOException ex) {
            System.err.println("error en el ingreso del nombre");
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean f = bunker.modificacion(codigoB);
        if (f) {
            System.out.println("Modificación exitosa");
        } else {
            System.err.println("El producto con ese codigo no existe en el almacen");
        }

    }

    public void facturarVenta() {

        String cedula = "";
        int cantidad = 1;
        Factura fac;

        System.out.println("Ingrese la cedula del cliente");
        try {
            cedula = entrada.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        //preguntar y leer:
        System.out.println("Cuantos productos desea llevar");
        try {
            cantidad = Integer.parseInt(entrada.readLine());
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        fac = new Factura(cedula, cantidad);
        for (int i = 0; i < cantidad; i++) {
            String codigo = "";
            int cant = 0;//cuanto del producto va a comprar
            Producto articulo = null;
            System.out.println("Indique el codigo del producto deseado");
            try {
                codigo = entrada.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Cuanto del producto");
            try {
                cant = Integer.parseInt(entrada.readLine());
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            //preguntar que producto va a comprar y cuanto de ese producto
            articulo = bunker.buscar(codigo, cant);
            if (articulo != null) {
                System.out.println("nom: "+ articulo.getDescripcion());
                fac.agregarProducto(articulo, i);
                System.out.println("Venta bien vergas");
            } else {
                System.out.println("Se mamo mucho");
            }

        }
        //if (fac.comprobacion(cantidad)) {
        System.out.println("Venta exitosa");
        fac.getTotal();
        fac.mostrarTotales();
        facturas[r] = fac;
        r++;
        //} else {
        //System.out.println("Venta cancelada");
        //}
        //fac.nuevaFactura();
    }

    public void verIngresos() {

        float ingresos = 0;

        for (int i = 0; i < facturas.length; i++) {
            if (facturas[i] != null) {
                ingresos += facturas[i].Ganancia();
            }
        }
        System.out.println("Los ingresos de la empresa en ventas es: " + ingresos);
    }

    public void verEgresos() {
        bunker.egresos();
    }

    public void masVentas() {
        bunker.top10();
    }

    public void menosProductos() {
        bunker.menos();

    }

}
