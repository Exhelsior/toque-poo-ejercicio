package org.example.app;

import org.example.service.OrderFlowService;

/**
 * Pilares evidenciados en el proyecto:
 * - Abstracción: User (clase abstracta)
 * - Herencia: Customer, Cashier, Kitchen, Waiter extends User
 * - Encapsulamiento: atributos private + get/set
 * - Polimorfismo: arreglo User[] en Team
 *
 * Capas:
 * - app: entrada por consola
 * - service: casos de uso
 * - model: entidades y Team
 * - roles: actores del sistema
 */
public class Main {

    public static void main(String[] args) {
        ConsoleInput input = new ConsoleInput();
        ConsoleInput.InputData data = input.capture();

        OrderFlowService service = new OrderFlowService();
        service.process(data.customer(), data.order());

        input.close();
    }
}
