package org.example;

public class Cliente extends Usuario{
    private int mesa;

    public Cliente(String nombre, String correo, String password, int mesa){
        super(nombre,correo, password);
        this.mesa = mesa;
    }

    @Override
    public String realizarAccion(){
        return nombre + " esta realizando un pedido desde la mesa " + mesa;
    }
}