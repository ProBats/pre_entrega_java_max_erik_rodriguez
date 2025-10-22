public class Categoria {
    private int id;
    private String nombreCategoria;
    private boolean activo;

    private static int contadorProductos = 1;

    public Categoria( String nombreCategoria) {
        this.id = contadorProductos++;
        this.nombreCategoria = nombreCategoria;
        this.activo = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        String estado = activo ? "Activo" : "Inactivo";
        return "Categoria [id=" + id + ", nombreCategoria=" + nombreCategoria + ", estado=" + estado + "]";
    }
}
