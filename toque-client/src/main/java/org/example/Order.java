package org.example;

/**
 * Clase de apoyo (no forma parte de la herencia polimórfica).
 * Modela el pedido y sus estados en el flujo Toque:
 * CREADA → PAGADA → EN_COCINA → LISTA → COMPLETADA
 */
public class Order {

    private String id;
    private String description;
    private double total;
    private String status;

    public Order(String id, String description, double total, String status) {
        this.id = id;
        this.description = description;
        this.total = total;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /** Avanza el pedido al estado indicado. */
    public void advanceTo(String newStatus) {
        this.status = newStatus;
    }

    /** Regla de negocio: ¿ya está pagado o más adelante en el flujo? */
    public boolean isPaid() {
        return status.equals("PAGADA")
                || status.equals("EN_COCINA")
                || status.equals("LISTA")
                || status.equals("COMPLETADA");
    }

    public String resumen() {
        return "Pedido " + id + " | " + description + " | $" + total + " | Estado: " + status;
    }
}
