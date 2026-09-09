package org.example.model;

import org.example.roles.Cashier;
import org.example.roles.Customer;
import org.example.roles.Kitchen;
import org.example.roles.Waiter;

/**
 * Equipo del restaurante y recorrido del pedido.
 */
public class Team {

    private final Cashier cashier = new Cashier("Michael", "Centro");
    private final Kitchen kitchen = new Kitchen("Diego", "Parrilla");
    private final Waiter waiter = new Waiter("Juan", 3);

    /** Recorre los roles (User[]) y cada uno actúa según el estado del pedido. */
    public void processOrder(Customer customer, Order order) {
        User[] equipo = {customer, cashier, kitchen, waiter};

        System.out.println("--- Roles ---");
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
    }
}
