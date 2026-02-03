package aventura.domain;
public class LLave extends Item {

    private String codigoSeguridad;

    public LLave( String  nombre, String descripcion, String codigoSeguridad, boolean visible){
        super(nombre,descripcion,visible);
        this.codigoSeguridad = codigoSeguridad;
    }

    public String getCodigoSeguridad(){
        return this.codigoSeguridad;
    }
}