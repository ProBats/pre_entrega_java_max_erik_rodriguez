
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        final ArrayList<Categoria> categorias = new ArrayList<>();
        Categoria cat1 = new Categoria("Electrónica");
        Categoria cat2 = new Categoria("Ropa");
        Categoria cat3 = new Categoria("Servicios Técnicos");

        categorias.add(cat1);
        categorias.add(cat2);
        categorias.add(cat3);
        final ArrayList<Producto> productos = new ArrayList<>();
        Producto prod1 = new Articulo("Mouse inalámbrico", 8500f, cat1);
        Producto prod2 = new Articulo("Campera deportiva", 22000f, cat2);
        Producto prod3 = new Servicio("Reparación de notebook", 15000f, 3);

        productos.add(prod1);
        productos.add(prod2);
        productos.add(prod3);
        

        final CrudProductos crudProd = new CrudProductos(productos, categorias);
        final CrudCategorias crudCat = new CrudCategorias(categorias);

        int opcion;
        do {
            System.out.println();
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║        MENÚ PRINCIPAL        ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.println("║ 1) CRUD de Productos         ║");
            System.out.println("║ 2) CRUD de Categorías        ║");
            System.out.println("║ 0) Salir                     ║");
            System.out.println("╚══════════════════════════════╝");
            System.out.print("Opción: ");
            String linea = crudProd.teclado.nextLine();
            try {
                opcion = Integer.parseInt(linea.trim());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1 -> {
                    int op;
                    do {
                        crudProd.mostrarOpciones();
                        op = crudProd.leerEntero("");
                        switch (op) {
                            case 1 -> crudProd.crear();
                            case 2 -> crudProd.listar();
                            case 3 -> crudProd.actualizar();
                            case 4 -> crudProd.eliminar();
                            case 5 -> crudProd.reactivar();
                            case 0 -> System.out.println("Volviendo al menú principal...");
                            default -> System.out.println("Opción inválida");
                        }
                    } while (op != 0);
                }
                case 2 -> {
                    int op;
                    do {
                        crudCat.mostrarOpciones();
                        op = crudCat.leerEntero("");
                        switch (op) {
                            case 1 -> crudCat.crear();
                            case 2 -> crudCat.listar();
                            case 3 -> crudCat.listarActivas();
                            case 4 -> crudCat.listarInactivas();
                            case 5 -> crudCat.actualizar();
                            case 6 -> crudCat.eliminar();
                            case 7 -> crudCat.reactivar();
                            case 0 -> System.out.println("Volviendo al menú principal...");
                            default -> System.out.println("Opción inválida");
                        }
                    } while (op != 0);
                }
                case 0 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 0);
    }
}
