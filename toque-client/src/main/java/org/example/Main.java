package org.example;

public class Main {

    public static void main(String[] args) {
        Logistics road = new RoadLogistics();
        Logistics sea = new SeaLogistics();

        Envio envio1 = new Envio("Cajas de zapatos", "Bogotá", 120);
        Envio envio2 = new Envio("Café", "Cartagena", 500);

        System.out.println("--- Logística terrestre ---");
        road.planDelivery(envio1);

        System.out.println("--- Logística marítima ---");
        sea.planDelivery(envio2);
    }
}
