package org.example;

/**
 * R2 Herencia: Cashier extiende User.
 * Cobra el pedido y lo pasa a PAGADA.
 */
public class Cashier extends User {

    private String branch;

    public Cashier(String name, String branch) {
        super(name, "CASHIER");
        this.branch = branch;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    /** Aplica descuento si el total supera un umbral (operadores + condicional). */
    public double aplicarDescuento(double total) {
        if (total >= 50000) {
            return total * 0.9;
        }
        return total;
    }

    @Override
    public void processOrder(Order order) {
        if (!canHandle(order)) {
            System.out.println(getName() + " no puede cobrar: estado actual = " + order.getStatus());
            return;
        }
        double cobro = applyPayment(order);
        order.advanceTo(nextStatus(order));
        System.out.println(getName() + " cobró $" + cobro + " en sucursal " + branch
                + " → pedido " + order.getId() + " ahora " + order.getStatus());
    }

    /** Método con retorno: calcula el monto a cobrar. */
    public double applyPayment(Order order) {
        double cobro = applyDiscount(order.getTotal());
        order.setTotal(cobro);
        return cobro;
    }

    private double applyDiscount(double total) {
        return aplicarDescuento(total);
    }

    @Override
    public boolean canHandle(Order order) {
        return order.getStatus().equals("CREADA");
    }

    @Override
    public String describeAction() {
        return getName() + " [" + getRole() + "] cobra en caja (" + branch + ")";
    }

    @Override
    public double calculateAmount(Order order) {
        return aplicarDescuento(order.getTotal());
    }

    @Override
    public String nextStatus(Order order) {
        return "PAGADA";
    }
}
