package domain;

public class Contenedor extends Mueble implements Abrible {


    public Contenedor(String nombre, String descripcion, String codigoNecesario, Objeto objetoInterno){
        super(nombre, descripcion);
        this.codigoNecesario = codigoNecesario;
        this.objetoInterno = objetoInterno;
        this.abierto = false;
    }

    private String codigoNecesario;
    private Objeto objetoInterno;
    private boolean abierto = false;

    @Override
    public RespuestaAccion abrir(LLave lLave){
        //Comprobar si ya esta abierto
        if (this.abierto){
            return new RespuestaAccion(false, "El contenedor ya está abierto.");
        }
        //Abrir el cofre/caja fuerte
        if (codigoNecesario == null) {
            this.abierto = true;
            String nombreObj = (this.objetoInterno != null) ? this.objetoInterno.getNombre() : "nada";
            this.objetoInterno = null; // Vaciamos el contenedor
            return new RespuestaAccion(true, "Has abierto el cajón y has encontrado: " + nombreObj);
        }

        if (lLave != null && lLave.getCodigoSeguridad().equals(this.codigoNecesario)) {
            this.abierto = true;
            String nombreObj = (this.objetoInterno != null) ? this.objetoInterno.getNombre() : "nada";
            this.objetoInterno = null; // Vaciamos el contenedor
            return new RespuestaAccion(true, "!Click; Has usado la llave correcta y has encontrado: " + nombreObj);

        } else {
            return new RespuestaAccion(false, "La lalve no encaja o no tines la llave adecuada ");
        }
    }

    @Override
    public boolean estaAbierto(){
        return this.abierto;
    }
}