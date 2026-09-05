public class Cliente extends Usuario{
    private int mesa;

    public CLiente(String nombre, String correo, String contraseña, int mesa){
        super(nombre,correo, contraseña);
        this.mesa = mesa;
    }

    @Override
    public String realizarAccion(){
        return nombre + "esta realizando un pedido desde la mesa" + mesa;
    }
}