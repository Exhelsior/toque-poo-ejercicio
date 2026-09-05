public class Cajero extends Usuario{
    private String sucursal;

    public Cajero(String nombre, String correo, String contraseña, String sucursal){
        super(nombre,correo,constraseña);
        this.sucursal = sucursal;
    }

    @Override
    public String realizarAccion(){
        return nombre + " esta registrando un cobro en la sucursal" + sucursal;
    }
}