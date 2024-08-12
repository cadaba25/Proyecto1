/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package barreda_carlos_proyecto1;

import java.util.Scanner;

/**
 *
 * @author enigm
 */
public class Barreda_Carlos_Proyecto1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner lea = new Scanner(System.in);
        
        // Variables universales para controlar flujo y contadores
        int salidaventas = 0;
        int salidacompras = 0;
        int menu = 0;
        
        // Variables relacionadas con el manejo de la caja
        int cajacerrada = 1; // 1 = cerrada, 0 = abierta
        int abrircaja = 0; // 0 = cerrada, 1 = abierta
        double dinerocaja = 0.0; // Dinero actual en la caja
        
        // Inventario de productos y registros de ventas
        int invAzucar = 0;
        int invAvena = 0;
        int invTrigo = 0;
        int invMaiz = 0;
        
        double pago = 0.0; // Pago total para las ventas actuales
        int facturaAzucar = 0; // Cantidad de azucar vendida
        int facturaAvena = 0;  // Cantidad de avena vendida
        int facturaTrigo = 0;  // Cantidad de trigo vendida
        int facturaMaiz = 0;   // Cantidad de maiz vendida
        
        // Variables relacionadas con las compras
        double pagoC = 0.0, totalC;
        
        // Contadores y acumuladores adicionales para reportes
        int contadorVentas = 0;  // Numero total de ventas realizadas
        int contadorCompras = 0; // Numero total de compras realizadas
        double totalVentas = 0.0; // Monto total de las ventas
        double totalCompras = 0.0; // Monto total de las compras
        
        // Variable para verificar entradas validas
        int codigoCorrecto = 1; // 1 = correcto, 0 = incorrecto
        
        while (menu != 6) { // Ciclo principal del menu
            
            // Mostrar el menu principal
            System.out.println("=================================");
            System.out.println("           MENU PRINCIPAL        ");
            System.out.println("=================================");
            System.out.println("(1) Abrir caja                   |");
            System.out.println("(2) Ventas                       |");
            System.out.println("(3) Compras                      |");
            System.out.println("(4) Reportes                     |");
            System.out.println("(5) Cierre de caja               |");
            System.out.println("(6) Salir del sistema            |");
            System.out.println("=================================");
            
            // Leer la opcion seleccionada por el usuario
            System.out.print("Seleccione una opcion: ");
            menu = lea.nextInt();
            System.out.println("=================================");
            
            switch (menu) {
                case 1:
                    // Caso para abrir la caja y agregar dinero
                    if (cajacerrada == 1) {
                        // La caja estaba cerrada, ahora se abrirá
                        abrircaja = 1;
                        cajacerrada = 0;
                        System.out.print("Ingrese una cantidad de efectivo para agregar a la caja: ");
                        double montoAdicional = lea.nextDouble();
                        dinerocaja += montoAdicional; // Sumar el monto ingresado al dinero en caja
                        System.out.println("Caja abierta con exito. Dinero en caja: " + dinerocaja + " Lps");
                        System.out.println("=================================");
                    } else {
                        // La caja ya estaba abierta, se agrega mas dinero
                        System.out.print("Caja ya esta abierta. Ingrese una cantidad de efectivo para agregar a la caja: ");
                        double montoAdicional = lea.nextDouble();
                        dinerocaja += montoAdicional;
                        System.out.println("Efectivo agregado. Dinero en caja: " + dinerocaja + " Lps");
                        System.out.println("=================================");
                    }
                    break;
                    
                case 2:
                    // Caso para manejar ventas
                    if (abrircaja == 0) {
                        // No se puede acceder a ventas si la caja esta cerrada
                        System.out.println("=================================");
                        System.out.println("       CAJA CERRADA              ");
                        System.out.println("=================================");
                        System.out.println("Abrir caja para acceder a ventas ");
                        System.out.println("=================================");
                    } else if (invAzucar == 0 && invAvena == 0 && invTrigo == 0 && invMaiz == 0) {
                        // No hay inventario disponible para realizar ventas
                        System.out.println("=================================");
                        System.out.println("     INVENTARIO VACIO            ");
                        System.out.println("=================================");
                        System.out.println("No hay inventario disponible ");
                        System.out.println("=================================");
                    } else {
                        // Se accede a la seccion de ventas
                        System.out.println("=================================");
                        System.out.println("             VENTAS              ");
                        System.out.println("=================================");
                        
                        salidaventas = 0; // Reiniciar la salida de ventas
                        
                        while (salidaventas == 0) {
                            // Mostrar las opciones de cliente y productos disponibles
                            System.out.println("Cliente    | Codigo   | Producto");
                            System.out.println("    A      |  1,2,3,4 | Azucar, Avena, Trigo, Maiz");
                            System.out.println("    B      |  1,2,3   | Azucar, Avena, Trigo");
                            System.out.println("    C      |  4       | Maiz");
                            System.out.print("Ingresa el tipo de Cliente: ");
                            String cliente = lea.next().toUpperCase();
                            
                            if (cliente.equals("A") || cliente.equals("B") || cliente.equals("C")) {
                                int cantidad = 0;
                                String codigoproducto = "";
                                
                                switch (cliente) {
                                    case "A":
                                        // Mostrar productos disponibles para cliente tipo A
                                        System.out.println("------CLIENTE TIPO A------");
                                        System.out.println("Codigo | Producto | Precio");
                                        System.out.println("      1    |   Azucar   | 30 Lps");
                                        System.out.println("      2    |   Avena    |  25 Lps");
                                        System.out.println("      3    |   Trigo    | 32 Lps");
                                        System.out.println("      4    |   Maiz     | 20 Lps");
                                        System.out.println("-----------------------------------");
                                        break;  
                                    case "B":
                                        // Mostrar productos disponibles para cliente tipo B
                                        System.out.println("------CLIENTE TIPO B------");
                                        System.out.println("Codigo   | Producto   | Precio");
                                        System.out.println("      1    |   Azucar   | 30 Lps");
                                        System.out.println("      2    |   Avena    |  25 Lps");
                                        System.out.println("      3    |   Trigo    | 32 Lps");
                                        System.out.println("-----------------------------------");
                                        break;
                                    case "C":
                                        // Mostrar productos disponibles para cliente tipo C
                                        System.out.println("------CLIENTE TIPO C------");
                                        System.out.println("Codigo   | Producto   | Precio");
                                        System.out.println("      4    |   Maiz       | 20 Lps");
                                        System.out.println("-----------------------------------");
                                        break;
                                }

                                // Solicitar el codigo del producto al usuario
                                System.out.print("Ingrese codigo de producto: ");
                                codigoproducto = lea.next();

                                if (codigoproducto.equals("1") || codigoproducto.equals("2") || codigoproducto.equals("3") || codigoproducto.equals("4")) {
                                    
                                    switch (codigoproducto) {
                                        case "1":
                                            // Proceso de venta de azucar
                                            System.out.println("Inventario azucar: " + invAzucar);
                                            System.out.print("Ingrese la cantidad de azucar que comprara: ");
                                            cantidad = lea.nextInt();
                                            if (cantidad <= invAzucar) {
                                                invAzucar -= cantidad;
                                                pago += cantidad * 30;
                                                facturaAzucar += cantidad;
                                            } else {
                                                System.out.println("Inventario insuficiente");
                                            }
                                            break;

                                        case "2":
                                            // Proceso de venta de avena
                                            System.out.println("Inventario avena: " + invAvena);
                                            System.out.print("Ingrese la cantidad de avena que comprara: ");
                                            cantidad = lea.nextInt();
                                            if (cantidad <= invAvena) {
                                                invAvena -= cantidad;
                                                pago += cantidad * 25;
                                                facturaAvena += cantidad;
                                            } else {
                                                System.out.println("Inventario insuficiente");
                                            }
                                            break;

                                        case "3":
                                            // Proceso de venta de trigo
                                            System.out.println("Inventario trigo: " + invTrigo);
                                            System.out.print("Ingrese la cantidad de trigo que comprara: ");
                                            cantidad = lea.nextInt();
                                            if (cantidad <= invTrigo) {
                                                invTrigo -= cantidad;
                                                pago += cantidad * 32;
                                                facturaTrigo += cantidad;
                                            } else {
                                                System.out.println("Inventario insuficiente");
                                            }
                                            break;

                                        case "4":
                                            // Proceso de venta de maiz
                                            System.out.println("Inventario maiz: " + invMaiz);
                                            System.out.print("Ingrese la cantidad de maiz que comprara: ");
                                            cantidad = lea.nextInt();
                                            if (cantidad <= invMaiz) {
                                                invMaiz -= cantidad;
                                                pago += cantidad * 20;
                                                facturaMaiz += cantidad;
                                            } else {
                                                System.out.println("Inventario insuficiente");
                                            }
                                            break;
                                    }
                                } else {
                                    // Codigo de producto incorrecto
                                    System.out.println("Codigo incorrecto");
                                }

                                // Preguntar si desea realizar otra compra
                                System.out.print("Desea hacer otra compra? (SI/NO): ");
                                String seguirComprando = lea.next().toUpperCase();
                                if ("NO".equals(seguirComprando)) {
                                    salidaventas = 1; // Salir de la seccion de ventas
                                }
                                
                                // Calcular el subtotal y la factura correspondiente
                                double subTotalAzucar = facturaAzucar * 30;
                                double subTotalAvena = facturaAvena * 25;
                                double subTotalTrigo = facturaTrigo * 32;
                                double subTotalMaiz = facturaMaiz * 20;

                                double subtotal = subTotalAzucar + subTotalAvena + subTotalTrigo + subTotalMaiz;
                                double descuento = 0;
                                if (subtotal >= 1000 && subtotal <= 5000) {
                                    descuento = subtotal * 0.05;
                                } else if (subtotal > 5000) {
                                    descuento = subtotal * 0.10;
                                }
                                double subtotalConDescuento = subtotal - descuento;
                                double impuesto = subtotalConDescuento * 0.07;
                                double total = subtotalConDescuento + impuesto;

                                // Mostrar la factura al usuario
                                System.out.println("------ FACTURA ------");
                                System.out.println("Producto | Cantidad | Precio | Subtotal");
                                System.out.println("----------------------------------------");

                                if (facturaAzucar > 0) {
                                    
                                    System.out.printf("Azucar   |    %d     | 30 Lps | %.2f Lps%n", facturaAzucar, subTotalAzucar);
                                }
                                if (facturaAvena > 0) {
                                    
                                    System.out.printf("Avena    |    %d     | 25 Lps | %.2f Lps%n", facturaAvena, subTotalAvena);
                                }
                                if (facturaTrigo > 0) {
                                    
                                    System.out.printf("Trigo    |    %d     | 32 Lps | %.2f Lps%n", facturaTrigo, subTotalTrigo);
                                }
                                if (facturaMaiz > 0) {
                                    
                                    System.out.printf("Maiz     |    %d     | 20 Lps | %.2f Lps%n", facturaMaiz, subTotalMaiz);
                                }

                                System.out.println("----------------------------------------");
                                System.out.printf("Subtotal: %.2f Lps%n", subtotal);

                                if (descuento > 0) {
                                    
                                    System.out.printf("Descuento aplicado: -%.2f Lps%n", descuento);
                                }

                                System.out.printf("Impuesto (7%%): +%.2f Lps%n", impuesto);
                                System.out.println("----------------------------------------");
                                System.out.printf("Total a pagar: %.2f Lps%n", total);
                                System.out.println("----------------------");

                                totalVentas += total; // Acumular el total de ventas
                                contadorVentas++; // Incrementar el contador de ventas
                            } else {
                                
                                // Cliente no valido
                                System.out.println("Cliente no valido");
                            }
                        }
                    }
                    break;
                    
                case 3:
                    // Caso para manejar compras de inventario
                    if (abrircaja == 0) {
                        // No se pueden realizar compras si la caja esta cerrada
                        System.out.println("=================================");
                        System.out.println("       CAJA CERRADA              ");
                        System.out.println("=================================");
                        System.out.println("Abrir caja para acceder a compras");
                        System.out.println("=================================");
                    } else {
                        // Seccion de compras de inventario
                        System.out.println("=================================");
                        System.out.println("             COMPRAS             ");
                        System.out.println("=================================");
                        
                        String codigoproducto;
                        salidacompras = 0; // Reinicio del valor al inicio de cada compra
                        
                        while(salidacompras == 0){
                            // Mostrar opciones de productos y proveedores
                            System.out.println("Codigo | Producto | Precio | Inventario ");
                            System.out.println("   1   | Azucar   | 25Lps  | " + invAzucar);
                            System.out.println("   2   | Avena    | (B)20,(C)22 | " + invAvena);
                            System.out.println("   3   | Trigo    | 30Lps  | " + invTrigo);
                            System.out.println("   4   | Maiz     | 18Lps  | " + invMaiz);
                            System.out.println("=================================");
                            System.out.println("---------Tipo Proveedores--------");
                            System.out.println(" Proveedor | Productos           ");
                            System.out.println("   A       |   1,4               ");
                            System.out.println("   B       |   2,3               ");
                            System.out.println("   C       |   2                 ");
                            System.out.println("=================================");
                            
                            System.out.print("Ingrese el tipo de proveedor: ");
                            String cliente = lea.next().toUpperCase();
                            
                            codigoCorrecto = 1; 
                                
                            switch(cliente) {
                                
                                case "A":
                                    
                                    // Procesar compras de proveedor tipo A
                                    System.out.println("------Proveedor Tipo A------");
                                    System.out.println("Codigo | Producto | Precio");
                                    System.out.println("      1    |   Azucar   | 25 Lps");
                                    System.out.println("      4    |   Maiz     | 18 Lps");
                                    System.out.println("-----------------------------------");
                                    System.out.print("Ingrese codigo de producto: ");
                                    codigoproducto = lea.next();
                                                
                                    if(codigoproducto.equals("1") || codigoproducto.equals("4")){
                                        if(codigoproducto.equals("1")){
                                            // Comprar azucar al proveedor tipo A
                                            System.out.println("Inventario Azucar: " + invAzucar);
                                            System.out.print("Ingrese la cantidad de kg de Azucar que desea comprar: ");
                                            double producto = lea.nextDouble();
                                                        
                                            pagoC = producto * 25;
                                            totalC = dinerocaja - pagoC;

                                            if (pagoC <= dinerocaja) {
                                                invAzucar += producto;
                                                dinerocaja -= pagoC;
                                                totalCompras += pagoC;
                                                System.out.println("Compra realizada exitosamente. Dinero restante en caja: " + dinerocaja + " Lps");
                                            } else {
                                                double faltante = pagoC - dinerocaja;
                                                System.out.println("No se puede pagar la compra.");
                                                System.out.println("Dinero en caja: " + dinerocaja + " Lps. Faltante: " + faltante + " Lps");
                                            }
                                        }
                                                    
                                        if(codigoproducto.equals("4")){
                                            // Comprar maiz al proveedor tipo A
                                            System.out.println("Inventario Maiz: " + invMaiz);
                                            System.out.print("Ingrese la cantidad de kg de Maiz que desea comprar: ");
                                            double producto = lea.nextDouble();
                                                        
                                            pagoC = producto * 18;
                                            totalC = dinerocaja - pagoC;

                                            if (pagoC <= dinerocaja) {
                                                invMaiz += producto;
                                                dinerocaja -= pagoC;
                                                totalCompras += pagoC;
                                                System.out.println("Compra realizada exitosamente. Dinero restante en caja: " + dinerocaja + " Lps");
                                            } else {
                                                double faltante = pagoC - dinerocaja;
                                                System.out.println("No se puede pagar la compra.");
                                                System.out.println("Dinero en caja: " + dinerocaja + " Lps. Faltante: " + faltante + " Lps");
                                            }
                                        }
                                    } else {
                                        
                                        // Codigo incorrecto para proveedor tipo A
                                        System.out.println("Codigo incorrecto");
                                        codigoCorrecto = 0;
                                    }
                                    break;
                                    
                                
                                
                                case "B":
                                    
                                    // Procesar compras de proveedor tipo B
                                    System.out.println("------Proveedor Tipo B------");
                                    System.out.println("Codigo | Producto | Precio");
                                    System.out.println("      2    |   Avena    | 20 Lps");
                                    System.out.println("      3    |   Trigo    | 30 Lps");
                                    System.out.println("-----------------------------------");
                                    System.out.print("Ingrese codigo de producto: ");
                                    codigoproducto = lea.next();
                                     
                                    
                                    
                                    if(codigoproducto.equals("2") || codigoproducto.equals("3")){
                                        if(codigoproducto.equals("2")){
                                            // Comprar avena al proveedor tipo B
                                            System.out.println("Inventario Avena: " + invAvena);
                                            System.out.print("Ingrese la cantidad de kg de Avena que desea comprar: ");
                                            double producto = lea.nextDouble();
                                                        
                                            pagoC = producto * 20;
                                            totalC = dinerocaja - pagoC;

                                            if (pagoC <= dinerocaja) {
                                                invAvena += producto;
                                                dinerocaja -= pagoC;
                                                totalCompras += pagoC;
                                                System.out.println("Compra realizada exitosamente. Dinero restante en caja: " + dinerocaja + " Lps");
                                            } else {
                                                double faltante = pagoC - dinerocaja;
                                                System.out.println("No se puede pagar la compra.");
                                                System.out.println("Dinero en caja: " + dinerocaja + " Lps. Faltante: " + faltante + " Lps");
                                            }
                                        }
                                                    
                                        
                                        if(codigoproducto.equals("3")){
                                            // Comprar trigo al proveedor tipo B
                                            System.out.println("Inventario Trigo: " + invTrigo);
                                            System.out.print("Ingrese la cantidad de kg de Trigo que desea comprar: ");
                                            double producto = lea.nextDouble();
                                                        
                                            pagoC = producto * 30;
                                            totalC = dinerocaja - pagoC;

                                            if (pagoC <= dinerocaja) {
                                                invTrigo += producto;
                                                dinerocaja -= pagoC;
                                                totalCompras += pagoC;
                                                System.out.println("Compra realizada exitosamente. Dinero restante en caja: " + dinerocaja + " Lps");
                                            } else {
                                                double faltante = pagoC - dinerocaja;
                                                System.out.println("No se puede pagar la compra.");
                                                System.out.println("Dinero en caja: " + dinerocaja + " Lps. Faltante: " + faltante + " Lps");
                                            }
                                        }   
                                    } else {
                                        // Codigo incorrecto para proveedor tipo B
                                        System.out.println("Codigo incorrecto");
                                        codigoCorrecto = 0;
                                    }
                                    break;
                                    
                                
                                case "C":
                                    
                                    // Procesar compras de proveedor tipo C
                                    System.out.println("------Proveedor Tipo C------");
                                    System.out.println("Codigo | Producto | Precio");
                                    System.out.println("      2    |   Avena    | 22 Lps");
                                    System.out.println("-----------------------------------");
                                    System.out.print("Ingrese codigo de producto: ");
                                    codigoproducto = lea.next();
                                                
                                    if(codigoproducto.equals("2")){
                                        
                                        // Comprar avena al proveedor tipo C
                                        System.out.println("Inventario Avena: " + invAvena);
                                        System.out.print("Ingrese la cantidad de kg de Avena que desea comprar: ");
                                        double producto = lea.nextDouble();
                                                        
                                        pagoC = producto * 22;
                                        totalC = dinerocaja - pagoC;

                                        if (pagoC <= dinerocaja) {
                                            invAvena += producto;
                                            dinerocaja -= pagoC;
                                            totalCompras += pagoC;
                                            System.out.println("Compra realizada exitosamente. Dinero restante en caja: " + dinerocaja + " Lps");
                                        } else {
                                            double faltante = pagoC - dinerocaja;
                                            System.out.println("No se puede pagar la compra.");
                                            System.out.println("Dinero en caja: " + dinerocaja + " Lps. Faltante: " + faltante + " Lps");
                                        }
                                    } else {
                                        // Codigo incorrecto para proveedor tipo C
                                        System.out.println("Codigo incorrecto");
                                        codigoCorrecto = 0;
                                    }
                                    break;
                                    
                                
                                default:
                                    // Proveedor no valido
                                    System.out.println("Tipo de cliente no valido");
                                    codigoCorrecto = 0;
                                    break;
                            }
                            
                            if (codigoCorrecto == 0) {
                                // Si el codigo es incorrecto, repetir la seleccion de cliente
                                System.out.println("Ingrese el tipo de cliente nuevamente.");
                                continue; // Volver a preguntar el tipo de cliente
                            }
                            contadorCompras++; // Incrementar el contador de compras
                            salidacompras = 1; // Se regresa al menu principal despues de una compra exitosa
                        }
                    }
                    break;
                    
                
                
                
                
                case 4:
                    
                    // Opcion para generar reportes
                    System.out.println("=================================");
                    System.out.println("            REPORTES             ");
                    System.out.println("=================================");
                    
                    // Mostrar el estado actual de la caja y operaciones realizadas
                    System.out.println(String.format("Cantidad Actual que hay en la Caja: %.2f Lps", dinerocaja));
                    System.out.println("Numero de compras: " + contadorCompras);
                    System.out.println("Ventas Realizadas: "+ contadorVentas);
                    System.out.println(String.format("Volumen total de Compras: %.2f Lps", totalCompras));
                    System.out.println(String.format("Volumen de ventas efectuadas antes del cierre: %.2f Lps", totalVentas));
                    System.out.println(String.format("Margen de Ganancia: %.2f Lps", totalVentas - totalCompras));
                    
                    // Promedio de compras
                    double promedioCompras = contadorCompras == 0 ? 0 : totalCompras / contadorCompras;
                    
                    // Promedio de ventas
                    double promedioVentas = contadorVentas == 0 ? 0 : totalVentas / contadorVentas;
                    
                    
                    System.out.println(String.format("Promedio de Compras: %.2f Lps", promedioCompras));
                    System.out.println(String.format("Promedio de Ventas: %.2f Lps", promedioVentas));
                    System.out.println("=================================");

                    // Determinando el producto estrella
                    String productoEstrella = "Ninguno";
                    int cantidadVendida = 0; // Variable para almacenar la cantidad vendida del producto estrella

                    if (facturaAzucar >= facturaAvena && facturaAzucar >= facturaTrigo && facturaAzucar >= facturaMaiz) {
                        productoEstrella = "Azucar";
                        cantidadVendida = facturaAzucar;
                    } else if (facturaAvena >= facturaTrigo && facturaAvena >= facturaMaiz) {
                        productoEstrella = "Avena";
                        cantidadVendida = facturaAvena;
                    } else if (facturaTrigo >= facturaMaiz) {
                        productoEstrella = "Trigo";
                        cantidadVendida = facturaTrigo;
                    } else {
                        productoEstrella = "Maiz";
                        cantidadVendida = facturaMaiz;
                    }
                    
                    // Mostrar el producto estrella
                    System.out.println("El producto estrella es: " + productoEstrella + " con una cantidad de " + cantidadVendida + " kg vendidos.");
                    System.out.println("=================================");

                    // Ranking de productos mas vendidos
                    System.out.println("-------------RANKING----------------");
                    if (facturaMaiz >= facturaAzucar) {
                        if (facturaMaiz >= facturaAvena) {
                            if (facturaMaiz >= facturaTrigo) {
                                System.out.println("El producto que mas se ha vendido es: Maiz");
                                if (facturaAvena >= facturaAzucar) {
                                    if (facturaAvena >= facturaTrigo) {
                                        System.out.println("El segundo producto mas vendido es: Avena");
                                        if (facturaAzucar >= facturaTrigo) {
                                            System.out.println("El tercer producto mas vendido es: Azucar");
                                        } else {
                                            System.out.println("El tercer producto mas vendido es: Trigo");
                                        }
                                    } else {
                                        
                                        System.out.println("El segundo producto mas vendido es: Trigo");
                                        if (facturaAvena >= facturaAzucar) {
                                            System.out.println("El tercer producto mas vendido es: Avena");
                                        } else {
                                            System.out.println("El tercer producto mas vendido es: Azucar");
                                        }
                                    }
                                } else {
                                    if (facturaTrigo >= facturaAzucar) {
                                        System.out.println("El segundo producto mas vendido es: Trigo");
                                        System.out.println("El tercer producto mas vendido es: Azucar");
                                    
                                    } else {
                                        System.out.println("El segundo producto mas vendido es: Azucar");
                                        System.out.println("El tercer producto mas vendido es: Trigo");
                                    }
                                }
                            }
                        }
                    } else if (facturaAvena >= facturaAzucar) {
                        if (facturaAvena >= facturaTrigo) {
                            System.out.println("El producto que mas se ha vendido es: Avena");
                            if (facturaAzucar >= facturaTrigo) {
                                System.out.println("El segundo producto mas vendido es: Azucar");
                                System.out.println("El tercer producto mas vendido es: Trigo");
                            } else {
                                System.out.println("El segundo producto mas vendido es: Trigo");
                                System.out.println("El tercer producto mas vendido es: Azucar");
                            }
                        
                        } else {
                            System.out.println("El producto que mas se ha vendido es: Trigo");
                            System.out.println("El segundo producto mas vendido es: Avena");
                            System.out.println("El tercer producto mas vendido es: Azucar");
                        }
                    } else {
                        System.out.println("El producto que mas se ha vendido es: Azucar");
                        if (facturaTrigo >= facturaMaiz) {
                            System.out.println("El segundo producto mas vendido es: Trigo");
                            System.out.println("El tercer producto mas vendido es: Maiz");
                        
                        } else {
                            System.out.println("El segundo producto mas vendido es: Maiz");
                            System.out.println("El tercer producto mas vendido es: Trigo");
                        }
                    }
                    System.out.println("=================================");
                    // Automaticamente regresa al menu principal
                    break;
                    
                
                
                
                case 5:
                    // Caso para cierre de caja
                    if (abrircaja == 0) {
                        // No se puede cerrar una caja que ya esta cerrada
                        System.out.println("=================================");
                        System.out.println("       CAJA YA ESTA CERRADA      ");
                        System.out.println("=================================");
                    } else {
                        // Proceso de cierre de caja
                        System.out.println("=================================");
                        System.out.println("       CIERRE DE CAJA            ");
                        System.out.println("=================================");
                        System.out.println("Total en caja: " + dinerocaja + " Lps");
                        System.out.println("¿Cuanto desea depositar en el banco? (Maximo " + (dinerocaja * 0.6) + " Lps): ");
                        double deposito = lea.nextDouble();
                        
                        if (deposito <= (dinerocaja * 0.6)) {
                            // Depositar la cantidad solicitada
                            dinerocaja -= deposito;
                            System.out.println("Deposito exitoso. Dinero restante en caja: " + dinerocaja + " Lps");
                        } else {
                            // Monto excede el limite permitido
                            System.out.println("No se puede depositar mas del 60% del efectivo en caja.");
                        }
                        
                        // Resetear los contadores y acumuladores
                        contadorVentas = 0;
                        contadorCompras = 0;
                        totalVentas = 0;
                        totalCompras = 0;
                        facturaAzucar = 0;
                        facturaAvena = 0;
                        facturaTrigo = 0;
                        facturaMaiz = 0;
                        
                        // Mantener inventario y dinero en caja, cerrar la caja
                        abrircaja = 0;
                        cajacerrada = 1;
                        
                        System.out.println("La caja ha sido cerrada. No puede realizar ventas o compras hasta que la caja se vuelva a abrir.");
                        System.out.println("=================================");
                    }
                    break;
                    
                
                
                
                case 6:
                    // Salir del sistema
                    System.out.println("=================================");
                    System.out.println("      SALIENDO DEL SISTEMA       ");
                    System.out.println("=================================");
                    break;
                    
                
                
                
                default:
                    // Manejo de opciones no validas
                    System.out.println("=================================");
                    System.out.println("        OPCION NO VALIDA         ");
                    System.out.println("=================================");
                    break;
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
            }
        }
    }
}