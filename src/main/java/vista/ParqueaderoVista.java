/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.ParqueaderoControlador;
import java.util.Scanner;

/**
 *
 * @author juanr
 */
public class ParqueaderoVista {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ParqueaderoControlador controlador = new ParqueaderoControlador();

        int op;
        do {
            System.out.println("GESTION PARQUEADERO");
            System.out.println("1. Entrada Automovil");
            System.out.println("2. Entrada Motocicleta");
            System.out.println("3. Entrada Camion");
            System.out.println("4. Salida Vehiculo");
            System.out.println("5. Consultar estado");
            System.out.println("0. Salir");
            op = leerEntero(sc, "Opcion: ");

            switch (op) {

                // Registro de entrada de automovil
                case 1 -> {
                    System.out.print("Placa: ");
                    String placa = sc.nextLine();
                    System.out.print("Marca: ");
                    String marca = sc.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();
                    System.out.print("Tipo de combustible: ");
                    String combustible = sc.nextLine();

                    controlador.entradaAuto(placa, marca, modelo, combustible);
                    System.out.println("Automovil registrado.");
                }

                // Registro de entrada de moto
                case 2 -> {
                    System.out.print("Placa: ");
                    String placa = sc.nextLine();
                    System.out.print("Marca: ");
                    String marca = sc.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();
                    int cilindraje = leerEntero(sc, "Cilindraje: ");

                    controlador.entradaMoto(placa, marca, modelo, cilindraje);
                    System.out.println("Motocicleta registrada.");
                }

                // Registro de entrada de camion
                case 3 -> {
                    System.out.print("Placa: ");
                    String placa = sc.nextLine();
                    System.out.print("Marca: ");
                    String marca = sc.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();
                    double carga = leerDouble(sc, "Capacidad de carga: ");

                    controlador.entradaCamion(placa, marca, modelo, carga);
                    System.out.println("Camion registrado.");
                }

                // Registro de salida de un vehiculo
                case 4 -> {
                    System.out.print("Placa: ");
                    String placa = sc.nextLine();
                    double costo = controlador.salida(placa);
                    System.out.println("Total a pagar: $" + costo);
                }

                // Consulta del estado del parqueadero
                case 5 -> {
                    System.out.println("Estado del Parqueadero");
                    controlador.consultarEstado();
                }

                // Finaliza el programa
                case 0 ->
                    System.out.println("Sistema finalizado.");

                // Opción incorrecta    
                default ->
                    System.out.println("Opcion invalida.");
            }

        } while (op != 0);
    }

    /**
     * Metodo para leer un numero entero para validacion.
     */
    private static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String input = sc.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar un numero entero.");
            }
        }
    }

    /**
     * Metodo para leer un numero decimal para validacion.
     */
    private static double leerDouble(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String input = sc.nextLine();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar un numero decimal.");
            }
        }
    }
}
