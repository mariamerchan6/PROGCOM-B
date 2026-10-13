import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] tipo = {"rosa", "tulipan", "girasol", "amapola", "lirio"};
        int[] cantidad = {1, 17, 3, 8, 5};
        int[] precio = {4000, 80000, 5000, 15000, 23000};

        String[] carTipo = new String[50];
        int[] carCantidad = new int[50];
        int[] carPrecio = new int[50];
        int carTotalItems = 0;

        int pagoOpc = 0;
        int totalPagar = 0;

        System.out.println("Bienvenido a mi floristeria");
        System.out.println("");

        while (true) {
            System.out.println("Menu");
            System.out.println("Que desea hacer?");
            System.out.println("1. Visualizar nuestras flores");
            System.out.println("2. Comprar");
            System.out.println("3. Pagar");
            System.out.println("4. Factura de compra");
            System.out.println("5. Salir");
            System.out.print("Ingrese su opcion: ");
            int opc = Integer.parseInt(sc.nextLine());

            if (opc == 1) {
                System.out.println("\nEstas son nuestras flores");
                System.out.println("Flores - Cantidad - Precio unit");
                for (int i = 0; i < tipo.length; i++) {
                    System.out.println(tipo[i] + " - " + cantidad[i] + " - " + precio[i]);
                }
            } else if (opc == 2) {
                while (true) {
                    System.out.println("\n--- Carrito ---");
                    if (carTotalItems == 0) {
                        System.out.println("No hay nada en el carrito :(");
                    } else {
                        for (int i = 0; i < carTotalItems; i++) {
                            System.out.println((i+1) + ". " + carTipo[i] + " x" + carCantidad[i]);
                        }
                    }
                    System.out.println("\nFlores disponibles:");
                    for (int i = 0; i < tipo.length; i++) {
                        System.out.println((i+1) + ". " + tipo[i] + " (Stock: " + cantidad[i] + ") $" + precio[i]);
                    }
                    System.out.println("0. Volver al menu principal");
                    System.out.print("Seleccione numero de flor: ");
                    int sel = Integer.parseInt(sc.nextLine());
                    if (sel == 0) break;
                    sel = sel - 1;
                    if (sel < 0 || sel >= tipo.length) {
                        System.out.println("Opcion no valida");
                        continue;
                    }
                    System.out.print("Que cantidad desea?: ");
                    int cant = Integer.parseInt(sc.nextLine());
                    if (cant > cantidad[sel]) {
                        System.out.println("No hay suficiente stock, solo quedan " + cantidad[sel]);
                        continue;
                    }
                    carTipo[carTotalItems] = tipo[sel];
                    carCantidad[carTotalItems] = cant;
                    carPrecio[carTotalItems] = precio[sel];
                    carTotalItems++;
                    cantidad[sel] = cantidad[sel] - cant;
                    System.out.println("Agregado!");
                }
            } else if (opc == 3) {
                if (carTotalItems == 0) {
                    System.out.println("El carrito esta vacio, primero compre en opcion 2");
                    continue;
                }
                System.out.println("\nSeleccione el medio de pago");
                System.out.println("1. Efectivo");
                System.out.println("2. Tarjeta de credito");
                System.out.println("3. Tarjeta debito");
                System.out.println("4. Otro medio de pago");
                System.out.print("Seleccione su opcion: ");
                pagoOpc = Integer.parseInt(sc.nextLine());
                totalPagar = 0;
                for (int i = 0; i < carTotalItems; i++) {
                    totalPagar = totalPagar + (carCantidad[i] * carPrecio[i]);
                }
                System.out.println("Usted debe pagar " + totalPagar);
            } else if (opc == 4) {
                System.out.println("\n***FACTURA DE COMPRA***");
                if (carTotalItems == 0) {
                    System.out.println("No hay productos comprados");
                    continue;
                }
                for (int i = 0; i < carTotalItems; i++) {
                    int subtotal = carCantidad[i] * carPrecio[i];
                    System.out.println(carTipo[i] + " cantidad: " + carCantidad[i] + " Subtotal: " + subtotal);
                }
                System.out.println("(SOMOS EVASORES DE IMPUESTOS (:))");
                System.out.println("Metodo de pago : " + pagoOpc);
                System.out.println("TOTAL: " + totalPagar);
            } else if (opc == 5) {
                System.out.println("Gracias por su compra");
                break;
            }
        }
        sc.close();
    }
}