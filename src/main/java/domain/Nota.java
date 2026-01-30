package domain;

public class Nota extends Item implements Leible{

    private String contenido;

    //Constructor
    public Nota(String nombre, String descripcion, String contenido) {
        super(nombre,descripcion);
        this.contenido = contenido;
    }

    @Override
    public String leer() {
        return this.contenido;
    }
}