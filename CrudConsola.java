
import java.util.Scanner;

public abstract class CrudConsola<T> {
    protected final Scanner teclado = new Scanner(System.in);

    public abstract void crear();
    public abstract void listar();
    public abstract void actualizar();
    public abstract void eliminar();

    public void mostrarOpciones() {
        System.out.println("╔════════════════════════╗");
        System.out.println("║      MENÚ CRUD         ║");
        System.out.println("╠════════════════════════╣");
        System.out.println("║ 1) Crear               ║");
        System.out.println("║ 2) Listar              ║");
        System.out.println("║ 3) Actualizar          ║");
        System.out.println("║ 4) Eliminar            ║");
        System.out.println("║ 5) Reactivar           ║");
        System.out.println("║ 0) Volver / Salir      ║");
        System.out.println("╚════════════════════════╝");
        System.out.print("Opción: ");
    }

    protected int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                String linea = teclado.nextLine();
                return Integer.parseInt(linea.trim());
            } catch (NumberFormatException e) {
                System.out.println("Debe ser un número entero.");
            }
        }
    }

    protected double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                String linea = teclado.nextLine();
                return Double.parseDouble(linea.trim());
            } catch (NumberFormatException e) {
                System.out.println("Debe ser un número (use punto).");
            }
        }
    }

    protected String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return teclado.nextLine();
    }

}
