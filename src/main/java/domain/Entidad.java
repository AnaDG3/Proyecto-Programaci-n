package domain;

public abstract class Entidad {

    private String nombre;
    private String descripcion;
    protected Entidad(){
        this.nombre=getNombre();
        this.descripcion=getDescripcion();
    }

    public String getNombre() {
        return nombre;

    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
