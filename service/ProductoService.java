package service;

import java.util.ArrayList;
import java.util.List;

import exception.ProductoNoEncontradoException;
import model.Producto;
import util.Validador;

/* Capa de servicio: contiene la logica de negocio de nuestro sistema
    Es responsable de:
        - mantener la coleccion de productos
        - Asignar el id al guardar un nuevo producto
        - Validar los datos antes de guardar o actualizar
        - Buscar,modificar y eliminar productos por id

    No tiene Scanner ni System.out : no interuactua con el usuario.
    Quien quiera mostrar mensajes o leer datos lo hace por afuera ( lo hace la clase main )
    spoiler: esta separación nos va a permitir en clases siguientes , reemplazar el menu por una API REST sin tocar este archivo


*/

public class ProductoService {
    // coleccion en memoria que guarda los productos
    private List<Producto> productos = new ArrayList<>();


    // Contador para asignar id`s únicos. Es static porque pertenece a la clase y no a una instancia
    // garantiza que el id sea único aunque hubiera varias instancias de ProductoService

    private static int contadorId = 1;

    // OPERACIONES CRUD ( create ,read , update , delete)

    // CREATE :  agregar un nuevo producto
    public Producto guardar (Producto p) {
        // validamos antes de guardar. Si algo esta mal, se lanza 
        // excepción y el producto NO se agrega a la lista
        Validador.validarNombre(p.getNombre());
        Validador.validarPrecio(p.getPrecio());
        Validador.validarStock(p.getStock());
        Validador.validarCategoria(p.getCategoria());

        // El id lo asigna el servicio,no el usuario. 
        // Despues de asignarlo,incrementamos el contador

        p.setId(contadorId);
        contadorId++;

        // guardo el producto
        productos.add(p);

        return p;

    }

    //Read: devuelve toda la lista de productos
    public List<Producto> listarTodos(){
        return productos;
    }

    // buscar un producto por id 

    public Producto obtenerPorId(int id) {
        for(Producto p : productos){
            if(p.getId() == id){
                return p;
            }
        }

        throw new ProductoNoEncontradoException("No se encontro un producto con el id " + id);
    }

    // update: actualiza los datos del producto existente
    public Producto actualizar(int id,Producto datos){
        // Reutilizamos obtenerPorId . Si lanza excepcion la actualizacion se cancela
        Producto p = obtenerPorId(id);

        //validamos los datos antes de aplicarlos
        Validador.validarNombre(datos.getNombre());
        Validador.validarPrecio(datos.getPrecio());
        Validador.validarStock(datos.getStock());
        Validador.validarCategoria(datos.getCategoria());

        // modificamos el producto encontrado
        // Como Java pasa los objetos por referencia, los cambios se reflejan en la lista
        // sin necesidad de hacer nada más.
        p.setNombre(datos.getNombre());
        p.setPrecio(datos.getPrecio());
        p.setStock(datos.getStock());
        p.setCategoria(datos.getCategoria());

        return p;

    }

    // DELETE: eliminar un producto por ID
    public void eliminar(int id){
        Producto p = obtenerPorId(id);
        productos.remove(p);
    }

    
}
