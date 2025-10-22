public class Articulo extends Producto {
    private Categoria categoria;

    public Articulo(String nombre, float precio, Categoria categoria) {
        super(nombre, precio);
        this.categoria = categoria;
    }
    

    public Categoria getCategoria() {
    return categoria;
    }

    public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
    }
    
    @Override
    public double calcularDescuento() {
        // Ejemplo: descuento fijo del 10%
        return getPrecio() * 0.90;
    }


    @Override
    public String toString() {
        return super.toString() + ", categoria=" + (categoria != null ? categoria.getNombreCategoria().toUpperCase() : "sin categoria") + "]";
    }
    
    

}
