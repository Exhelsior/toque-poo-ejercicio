package org.example;
import java. util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Usuario[] usuarios = new Usuario[2];


        System.out.println("--- Registro de Cliente ---");
        System.out.print("Nombre: ");
        String nombreCliente = sc.nextLine();
        System.out.print("Correo: ");
        String correoCliente = sc.nextLine();
        System.out.print("Contraseña: ");
        String passCliente = sc.nextLine();
        System.out.print("Número de mesa: ");
        int mesa = sc.nextInt();
        sc.nextLine();

        usuarios[0] = new Cliente(nombreCliente, correoCliente, passCliente, mesa);

        System.out.println("\n--- Registro de Cajero ---");
        System.out.print("Nombre: ");
        String nombreCajero = sc.nextLine();
        System.out.print("Correo: ");
        String correoCajero = sc.nextLine();
        System.out.print("Contraseña: ");
            String passCajero = sc.nextLine();
            System.out.print("Sucursal: ");
        String sucursal = sc.nextLine();

        usuarios[1] = new Cajero(nombreCajero, correoCajero, passCajero, sucursal);


        System.out.println("\n--- Acciones realizadas ---");
        for (Usuario u : usuarios) {
            System.out.println(u.realizarAccion());
        }

        sc.close();
    }
}
