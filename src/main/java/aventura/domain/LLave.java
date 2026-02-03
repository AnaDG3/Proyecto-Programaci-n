package aventura.domain;
public class LLave extends Item {

    private String codigoSeguridad;

    public LLave( String  nombre, String descripcion, String codigoSeguridad){
        super(nombre,descripcion);
        this.codigoSeguridad = codigoSeguridad;
    }

    public String getCodigoSeguridad(){
        return this.codigoSeguridad;
    }
}