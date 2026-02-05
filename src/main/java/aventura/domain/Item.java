package aventura.domain;

public class Item extends Objeto implements Inventariable {

    public Item(String nombre, String descripcion, boolean visible) {
        super(nombre,descripcion,visible);

    }
}