package org.example;

import java.util.Scanner;

/**
 * Clase principal — Actividad Integradora POO (Toque).
 *
 * Pilares evidenciados:
 * - Abstracción: User (clase abstracta)
 * - Herencia: Customer, Cashier, Kitchen, Waiter extends User
 * - Encapsulamiento: atributos private + get/set
 * - Polimorfismo: arreglo User[]
 *
 * R6: métodos con return (calculateAmount, canHandle, etc.) y void (processOrder)
 * R7: Scanner captura al menos un objeto
 * R8: condicionales if/else en roles y aquí
 * R9: salida por System.out.println
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== TOQUE — Flujo de pedido (consola) ===");
        System.out.print("Nombre del cliente: ");
        String customerName = scanner.nextLine();

        System.out.print("Número de mesa: ");
        int tableNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Descripción del pedido: ");
        String description = scanner.nextLine();

        System.out.print("Total del pedido: ");
        double total = scanner.nextDouble();
        scanner.nextLine();

        // R7: objeto capturado por consola
        Customer customer = new Customer(customerName, tableNumber);

        // Regla con condicional (R8)
        if (!customer.mesaValida()) {
            System.out.println("Mesa inválida. Se asigna mesa 1 por defecto.");
            customer.setTableNumber(1);
        }

        if (total <= 0) {
            System.out.println("Total inválido. Se usa 25000 por defecto.");
            total = 25000;
        }

        Order order = new Order("ORD-001", description, total, "CREADA");

        Cashier cashier = new Cashier("Luis", "Centro");
        Kitchen kitchen = new Kitchen("Ana", "Parrilla");
        Waiter waiter = new Waiter("Sofía", 3);

        System.out.println();
        System.out.println("--- Pedido inicial ---");
        System.out.println(order.resumen());
        System.out.println();

        // R5 Polimorfismo: arreglo del tipo padre + un solo recorrido
        User[] equipo = {customer, cashier, kitchen, waiter};

        System.out.println("--- Procesando roles (polimorfismo) ---");
        for (User user : equipo) {
            System.out.println(user.describeAction());
            if (user.canHandle(order)) {
                System.out.println("  Monto asociado: $" + user.calculateAmount(order));
                System.out.println("  Siguiente estado propuesto: " + user.nextStatus(order));
                user.processOrder(order);
            } else {
                System.out.println("  No actúa en estado " + order.getStatus());
            }
            System.out.println("  Estado actual: " + order.getStatus());
            System.out.println();
        }

        System.out.println("--- Resultado final ---");
        System.out.println(order.resumen());

        if (order.getStatus().equals("COMPLETADA")) {
            System.out.println("Pedido completado con éxito.");
        } else {
            System.out.println("El pedido quedó en: " + order.getStatus());
        }

        scanner.close();
    }
}
