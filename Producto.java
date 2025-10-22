public abstract class Producto implements Vendible {
    private int id;
    private String nombre;
    private float precio;
    private boolean activo;

    private static int contadorProductos = 1;

    public Producto(String nombre, float precio) {
        this.id = contadorProductos ++;
        this.nombre = nombre;
        this.precio = precio;
        this.activo = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public abstract double calcularDescuento();

    @Override
    public String toString() {
        return id + " - " + nombre + " ($" + precio + ") " + (activo ? "[Activo]" : "[Inactivo]");
    }

    
}
