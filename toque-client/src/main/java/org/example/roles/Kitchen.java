package org.example.roles;

import org.example.model.Order;
import org.example.model.User;

/**
 * R2 Herencia: Kitchen extiende User.
 * Prepara el pedido: PAGADA → EN_COCINA → LISTA.
 */
public class Kitchen extends User {

    private String station;

    public Kitchen(String name, String station) {
        super(name, "KITCHEN");
        this.station = station;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    /** Indica si la estación puede preparar el plato (condicional). */
    public boolean estacionLista() {
        if (station != null && !station.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public void processOrder(Order order) {
        if (!canHandle(order)) {
            System.out.println(getName() + " (cocina) no actúa: estado = " + order.getStatus());
            return;
        }
        if (!estacionLista()) {
            System.out.println(getName() + " no tiene estación asignada");
            return;
        }

        if (order.getStatus().equals("PAGADA")) {
            order.advanceTo("EN_COCINA");
            System.out.println(getName() + " en " + station + " comenzó a preparar " + order.getDescription());
        }

        if (order.getStatus().equals("EN_COCINA")) {
            order.advanceTo("LISTA");
            System.out.println(getName() + " marcó el pedido " + order.getId() + " como LISTA");
        }
    }

    @Override
    public boolean canHandle(Order order) {
        // Solo cocina si ya pagó (PAGADA) o está en preparación
        return order.isPaid()
                && (order.getStatus().equals("PAGADA") || order.getStatus().equals("EN_COCINA"));
    }

    @Override
    public String describeAction() {
        return getName() + " [" + getRole() + "] prepara en estación " + station;
    }

    @Override
    public double calculateAmount(Order order) {
        return 0.0;
    }

    @Override
    public String nextStatus(Order order) {
        if (order.getStatus().equals("PAGADA")) {
            return "EN_COCINA";
        }
        if (order.getStatus().equals("EN_COCINA")) {
            return "LISTA";
        }
        return order.getStatus();
    }
}
