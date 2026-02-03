package aventura.domain;

import java.util.Objects;

public abstract class Entidad {

    private String nombre;
    private String descripcion;

    protected Entidad(String nombre, String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    @Override
    public boolean equals(Object o) {
        //este método nos servirá para poder comprobar en la clase objeto si 2 objetos son iguales
        if (!(o instanceof Entidad entidad)) return false;
        return Objects.equals(nombre, entidad.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
