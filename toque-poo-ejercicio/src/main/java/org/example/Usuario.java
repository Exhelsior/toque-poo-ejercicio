package org.example;

public abstract class Usuario {
    protected String nombre;
    private String correo;
    private String password;

    public Usuario(String nombre, String correo, String password) {
        this.nombre = nombre;
        setCorreo(correo);
        this.password = password;
    }

    public void setCorreo(String correo) {
        if (!correo.contains("@")) {
            System.out.println("correo invalido");
        } else {
            this.correo = correo;
        }
    }

    public String getCorreo() {
        return correo;
    }

    public boolean verificaContrasena(String intento) {
        return this.password.equals(intento);
    }

    public abstract String realizarAccion();
}