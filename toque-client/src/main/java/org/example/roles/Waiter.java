package org.example.roles;

import org.example.model.Order;
import org.example.model.User;

/**
 * R2 Herencia: Waiter extiende User.
 * Entrega el pedido listo y lo deja COMPLETADA.
 */
public class Waiter extends User {

    private int zone;

    public Waiter(String name, int zone) {
        super(name, "WAITER");
        this.zone = zone;
    }

    public int getZone() {
        return zone;
    }

    public void setZone(int zone) {
        this.zone = zone;
    }

    /** Valida zona de atención (condicional + operadores). */
    public boolean zonaActiva() {
        return zone >= 1 && zone <= 10;
    }

    @Override
    public void processOrder(Order order) {
        if (!canHandle(order)) {
            System.out.println(getName() + " (mesero) no entrega: estado = " + order.getStatus());
            return;
        }
        if (!zonaActiva()) {
            System.out.println(getName() + " tiene zona inválida: " + zone);
            return;
        }
        order.advanceTo(nextStatus(order));
        System.out.println(getName() + " entregó el pedido " + order.getId()
                + " en zona " + zone + " → " + order.getStatus());
    }

    @Override
    public boolean canHandle(Order order) {
        return order.getStatus().equals("LISTA");
    }

    @Override
    public String describeAction() {
        return getName() + " [" + getRole() + "] entrega en zona " + zone;
    }

    @Override
    public double calculateAmount(Order order) {
        // Propina sugerida 10%
        return order.getTotal() * 0.10;
    }

    @Override
    public String nextStatus(Order order) {
        return "COMPLETADA";
    }
}
