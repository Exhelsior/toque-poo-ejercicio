package org.example.model;

/**
 * R1 Abstracción: clase abstracta padre (molde general del proyecto Toque).
 * R3 Encapsulamiento: atributos privados con get/set.
 * R4 Constructor con this.
 */
public abstract class User {

    private String name;
    private String role;

    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    /** Acción principal sobre el pedido según el rol. */
    public abstract void processOrder(Order order);

    /** Indica si este rol puede actuar según el estado actual del pedido. */
    public abstract boolean canHandle(Order order);

    /** Descripción acción del rol. */
    public abstract String describeAction();

    /** Monto que calcula o aporta este rol sobre el pedido. */
    public abstract double calculateAmount(Order order);

    /** Siguiente estado al que avanzaría este rol. */
    public abstract String nextStatus(Order order);
}
