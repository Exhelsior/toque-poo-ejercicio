package org.example;

/**
 * R2 Herencia: Customer extiende User.
 * Crea / solicita la orden (estado CREADA).
 */
public class Customer extends User {

    private int tableNumber;

    public Customer(String name, int tableNumber) {
        super(name, "CUSTOMER");
        this.tableNumber = tableNumber;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    /** Confirma si la mesa es válida (regla con condicional). */
    public boolean mesaValida() {
        if (tableNumber > 0 && tableNumber <= 50) {
            return true;
        }
        return false;
    }

    @Override
    public void processOrder(Order order) {
        if (!mesaValida()) {
            System.out.println(getName() + " no puede pedir: mesa inválida (" + tableNumber + ")");
            return;
        }
        order.advanceTo("CREADA");
        System.out.println(getName() + " (mesa " + tableNumber + ") solicitó: " + order.getDescription());
    }

    @Override
    public boolean canHandle(Order order) {
        return order.getStatus() == null || order.getStatus().equals("CREADA");
    }

    @Override
    public String describeAction() {
        return getName() + " [" + getRole() + "] solicita el pedido desde la mesa";
    }

    @Override
    public double calculateAmount(Order order) {
        return order.getTotal();
    }

    @Override
    public String nextStatus(Order order) {
        return "CREADA";
    }
}
