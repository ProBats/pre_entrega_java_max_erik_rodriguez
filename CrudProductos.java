
import java.util.ArrayList;

public class CrudProductos extends CrudConsola<Producto> {

    private final ArrayList<Producto> productos;
    private final ArrayList<Categoria> categorias;

    public CrudProductos(ArrayList<Producto> productos, ArrayList<Categoria> categorias) {
        this.productos = productos;
        this.categorias = categorias;
    }

    @Override
    public void crear() {
        System.out.println();
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║     CREAR PRODUCTO NUEVO     ║");
        System.out.println("╠══════════════════════════════╣");
        System.out.println("║ 1) Crear Artículo            ║");
        System.out.println("║ 2) Crear Servicio            ║");
        System.out.println("╚══════════════════════════════╝");
        int op = leerEntero("Elegí una opción: ");

        if (op == 1) {
            String nombre = leerTexto("Nombre del artículo: ");
            double precio = leerDouble("Precio del artículo: ");

            Categoria categoriaSeleccionada = seleccionarCategoriaActiva();
            if (categoriaSeleccionada == null) {
                System.out.println("No hay categorías activas disponibles. Operación cancelada.");
                return;
            }

            Articulo nuevoArticulo = new Articulo(nombre, (float) precio, categoriaSeleccionada);
            productos.add(nuevoArticulo);
            System.out.println("Artículo creado exitosamente: " + nuevoArticulo);

        } else if (op == 2) {
            String nombre = leerTexto("Nombre del servicio: ");
            double precio = leerDouble("Precio del servicio: ");
            int duracion = leerEntero("Duración en horas: ");

            Servicio nuevoServicio = new Servicio(nombre, (float) precio, duracion);
            productos.add(nuevoServicio);
            System.out.println("Servicio creado exitosamente: " + nuevoServicio);

        } else {
            System.out.println("Opción inválida. Operación cancelada.");
        }

    }

    @Override
    public void listar() {
        if (productos.isEmpty()) {
            System.out.println("(sin productos)");
        } else {
            for (Producto p : productos) {
                System.out.println(p);
            }
        }
    }

    @Override
    public void actualizar() {
        int id = leerEntero("Ingrese el ID del producto a actualizar: ");
        for (Producto p : productos) {
            if (p.getId() == id) {
                String nuevoNombre = leerTexto("Nuevo nombre (actual: " + p.getNombre() + "): ");
                double nuevoPrecio = leerDouble("Nuevo precio (actual: " + p.getPrecio() + "): ");
                p.setNombre(nuevoNombre);
                p.setPrecio((float) nuevoPrecio);

                if (p instanceof Articulo articulo) {
                    System.out.println("¿Cambiar categoría? 1=Sí / 0=No");
                    int cam = leerEntero("Opción: ");
                    if (cam == 1) {
                        Categoria nuevaCat = seleccionarCategoriaActiva();
                        if (nuevaCat != null) {
                            articulo.setCategoria(nuevaCat);
                        } else {
                            System.out.println("No hay categorías activas disponibles. Se mantiene la categoría actual.");
                        }
                    }
                }

                if (p instanceof Servicio servicio) {
                    System.out.println("¿Cambiar duración (horas)? 1=Sí / 0=No");
                    int cam = leerEntero("Opción: ");
                    if (cam == 1) {
                        int dur = leerEntero("Nueva duración (horas): ");
                        servicio.setDuracionHoras(dur);
                    }
                }

                System.out.println("Actualizado: " + p);
                return;
            }
        }
        System.out.println("No se encontró producto con id " + id);
    }

    @Override
    public void eliminar() {
        int id = leerEntero("Id del producto a eliminar/desactivar: ");
        for (Producto p : productos) {
            if (p.getId() == id) {
                System.out.println("¿Qué desea hacer?");
                System.out.println("1) Eliminar permanentemente");
                System.out.println("2) Desactivar (mantener en la lista)");
                int opcion = leerEntero("Opción: ");

                if (opcion == 1) {
                    productos.remove(p);
                    System.out.println("Producto eliminado definitivamente.");
                } else if (opcion == 2) {
                    p.setActivo(false);
                    System.out.println("Producto desactivado: " + p.getNombre());
                } else {
                    System.out.println("Opción inválida. No se realizó ninguna acción.");
                }
                return;
            }
        }
        System.out.println("No se encontró producto con id " + id);
    }

    public void reactivar() {
        int id = leerEntero("Ingrese el ID del producto a reactivar: ");
        for (Producto p : productos) {
            if (p.getId() == id) {
                if (!p.isActivo()) {
                    p.setActivo(true);
                    System.out.println("Producto reactivado: " + p.getNombre());
                } else {
                    System.out.println("El producto ya está activo.");
                }
                return;
            }
        }
        System.out.println("No se encontró producto con id " + id);
    }

    private Categoria seleccionarCategoriaActiva() {
        while (true) {
            ArrayList<Categoria> activas = new ArrayList<>();
            for (Categoria c : categorias) {
                if (c.isActivo()) activas.add(c);
            }

            System.out.println("Categorías activas disponibles:");
            for (Categoria c : activas) {
                System.out.println(c.getId() + ") " + c.getNombreCategoria());
            }
            System.out.println("0) Crear nueva categoría");

            int idCat = leerEntero("Elegí ID de la categoría o 0 para crear nueva: ");

            if (idCat == 0) {
                String nuevoNombre = leerTexto("Nombre de la nueva categoría: ");
                Categoria nuevaCat = new Categoria(nuevoNombre);
                categorias.add(nuevaCat);
                System.out.println("Nueva categoría creada: " + nuevaCat.getNombreCategoria());
                return nuevaCat;  
            }

            // Buscar la categoría elegida
            for (Categoria c : activas) {
                if (c.getId() == idCat) return c;
            }

            System.out.println("Categoría no encontrada. Intenta de nuevo.");
        }
    }
}
