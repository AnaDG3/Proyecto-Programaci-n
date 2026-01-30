package aventura.domain;

public abstract class Objeto extends Entidad{

    protected boolean visible; //por si hay objetos que no se  ven y están ocultos
    //hasta que se retire algo o pase algo
    public Objeto(String nombre, String descripcion, boolean visible) {
        super(nombre,descripcion); //Llama al constructor de la clase padre
        this.visible = visible;
    }


}
