package org.example.service;

import org.example.model.Order;
import org.example.model.Team;
import org.example.roles.Customer;

/**
 * Caso de uso: procesa el pedido.
 */
public class OrderFlowService {

    private final Team team = new Team();

    public void process(Customer customer, Order order) {
        System.out.println();
        System.out.println("--- Pedido inicial ---");
        System.out.println(order.resumen());
        System.out.println();

        team.processOrder(customer, order);

        System.out.println("--- Resultado final ---");
        System.out.println(order.resumen());

        if (order.getStatus().equals("COMPLETADA")) {
            System.out.println("Pedido completado con éxito.");
        } else {
            System.out.println("El pedido quedó en: " + order.getStatus());
        }
    }
}
