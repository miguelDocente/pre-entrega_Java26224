package service;

import java.util.ArrayList;
import java.util.List;
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

        productos.add(p);

        return p;

    }

    
    
}
