package model;

/**
 * Modelo de dominio: representa un producto del catálogo.
 *
 * Aplica encapsulamiento: los atributos son privados y se accede
 * a ellos a través de getters y setters. Esta clase no sabe nada
 * sobre cómo se almacenan los productos ni cómo se muestran al
 * usuario; su única responsabilidad es representar un producto.
 */
public class Producto {

    // Atributos privados: nadie de afuera puede modificarlos
    // directamente. Para acceder o modificarlos se usan los métodos
    // getters y setters definidos más abajo.
    private int id;
    private String nombre;
    private double precio;
    private int stock;
    private String categoria;

    // Constructor sin id: el id lo asigna el ProductoService al
    // momento de guardar el producto. El usuario nunca elige el id.
    public Producto(String nombre, double precio, int stock, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    // Constructor vacío: útil para crear un Producto y completarlo
    // con setters después. También lo necesitará Spring/JPA más adelante en el curso.
    public Producto() {
    }

    // Getters y setters: la única forma de acceder o modificar
    // los atributos privados desde afuera de la clase.
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // toString() sobreescribe el método heredado de Object.
    // Sirve para mostrar el producto de forma legible al listarlo
    // en consola. Cuando hagamos System.out.println(producto), Java
    // llama automáticamente a este método.
    @Override
    public String toString() {
        return "ID: " + id +
                " | " + nombre +
                " | $" + precio +
                " | Stock: " + stock +
                " | Categoría: " + categoria;
    }
}
