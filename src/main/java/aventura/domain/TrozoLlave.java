package aventura.domain;

public class TrozoLlave extends Item implements Combinable {

    private String id;

    public TrozoLlave(String nombre, String descripcion, String id, boolean visible) {
        super(nombre, descripcion, visible);
        this.id = id;
    }

    @Override
    public Objeto combinar(Objeto otro) {

        if (otro instanceof TrozoLlave otroTrozo) {

            // Si son diferentes trozos → crear llave completa
            if (!this.id.equals(otroTrozo.id)) {

                return new LLave(
                        "llave",
                        "Una llave completa del armario",
                        "ARMARIO_123",
                        true
                );
            }
        }

        return null;
    }
}
