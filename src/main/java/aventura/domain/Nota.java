package aventura.domain;

public class Nota extends Item implements Leible{

    private String contenido;

    //Constructor
    public Nota(String nombre, String descripcion, String contenido, boolean visible) {
        super(nombre,descripcion, visible);
        this.contenido = contenido;
    }

    @Override
    public String leer() {
        return this.contenido;
    }
}