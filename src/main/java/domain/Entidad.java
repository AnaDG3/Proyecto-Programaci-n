package domain;

public abstract class Entidad {

    private String nombre;
    private Entidad(){
        this.nombre=getNombre();
    }

    public String getNombre() {
        return nombre;

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
