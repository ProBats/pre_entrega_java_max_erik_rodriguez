import java.util.ArrayList;

public class CrudCategorias extends CrudConsola<Categoria> {
    private final ArrayList<Categoria> categorias;

    public CrudCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }

    @Override
public void mostrarOpciones() {
    System.out.println("╔══════════════════════════════════════╗");
    System.out.println("║         MENÚ CRUD CATEGORÍAS         ║");
    System.out.println("╠══════════════════════════════════════╣");
    System.out.println("║ 1) Crear categoría                   ║");
    System.out.println("║ 2) Listar todas                      ║");
    System.out.println("║ 3) Listar activas                    ║");
    System.out.println("║ 4) Listar inactivas                  ║");
    System.out.println("║ 5) Actualizar                        ║");
    System.out.println("║ 6) Desactivar categoría              ║");
    System.out.println("║ 7) Reactivar categoría               ║");
    System.out.println("║ 0) Volver al menú principal          ║");
    System.out.println("╚══════════════════════════════════════╝");
    System.out.print("Opción: ");
}

    @Override
    public void crear() {
        String nombre = leerTexto("Nombre de la nueva categoría: ");
        categorias.add(new Categoria(nombre));
        System.out.println("Categoría creada.");
    }

    @Override
    public void listar() {
        if (categorias.isEmpty()) {
            System.out.println("(sin categorías)");
        } else {
            System.out.println("Listado general de categorías:");
            for (Categoria c : categorias) {
                System.out.println(c);
            }
        }
    }

    public void listarActivas() {
        System.out.println("Categorías activas:");
        boolean hayActivas = false;
        for (Categoria c : categorias) {
            if (c.isActivo()) {
                System.out.println(c);
                hayActivas = true;
            }
        }
        if (!hayActivas) {
            System.out.println("(no hay categorías activas)");
        }
    }

    public void listarInactivas() {
        System.out.println("Categorías inactivas:");
        boolean hayInactivas = false;
        for (Categoria c : categorias) {
            if (!c.isActivo()) {
                System.out.println(c);
                hayInactivas = true;
            }
        }
        if (!hayInactivas) {
            System.out.println("(no hay categorías inactivas)");
        }
    }

    @Override
    public void actualizar() {
        listar(); 

        int id = leerEntero("Id de la categoría a actualizar: ");
        for (Categoria c : categorias) {
            if (c.getId() == id) {
                String nuevo = leerTexto("Nuevo nombre: ");
                c.setNombreCategoria(nuevo);
                System.out.println("Actualizada: " + c);

                return;
        }
    }
    System.out.println("No se encontró categoría con id " + id);

    }

    @Override
    public void eliminar() {
        listarActivas();
        int id = leerEntero("Id de la categoría a desactivar: ");
        for (Categoria c : categorias) {
            if (c.getId() == id) {
                if (!c.isActivo()) {
                    System.out.println("La categoría ya estaba inactiva.");
                    return;
                }
                c.setActivo(false);
                System.out.println("Categoría desactivada: " + c.getNombreCategoria());
                return;
            }
        }
        System.out.println("No se encontró categoría con id " + id);
    }

    public void reactivar() {
        listarInactivas();
        int id = leerEntero("Id de la categoría a reactivar: ");
        for (Categoria c : categorias) {
            if (c.getId() == id) {
                if (c.isActivo()) {
                    System.out.println("La categoría ya está activa.");
                    return;
                }
                c.setActivo(true);
                System.out.println("Categoría reactivada: " + c.getNombreCategoria());
                return;
            }
        }
        System.out.println("No se encontró categoría con id " + id);
    }
}
