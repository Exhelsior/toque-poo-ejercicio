package org.example.app;

import java.util.Scanner;

import org.example.model.Order;
import org.example.roles.Customer;

/**
 * Captura por consola los datos iniciales del flujo Toque.
 */
public class ConsoleInput {

    private final Scanner scanner = new Scanner(System.in);

    public InputData capture() {
        System.out.println("=== TOQUE ===");
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

        Customer customer = new Customer(customerName, tableNumber);

        if (!customer.mesaValida()) {
            System.out.println("Mesa inválida. Se asigna mesa 1 por defecto, pasar por caja para reclamar pedido");
            customer.setTableNumber(1);
        }

        if (total <= 0) {
            System.out.println("Total inválido. Se usa 25000 por defecto.");
            total = 25000;
        }

        int id = (int) (Math.random() * 100) + 1;
        Order order = new Order("ORD-TOQUE-" + id, description, total, "CREADA");

        return new InputData(customer, order);
    }

    public void close() {
        scanner.close();
    }

    public record InputData(Customer customer, Order order) {
    }
}
