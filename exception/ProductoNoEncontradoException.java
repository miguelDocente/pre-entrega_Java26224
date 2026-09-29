package exception;


/* Excepción personalizada que se lanza cuando se busca un producto por su id y no existe en el sistema

    hereda de RuntimeException ( excepciones no chequedas ): no obliga a quien usa el método a envolver la llamada en try/catch , pero si permite capturarla cuando nos interesa.

    Crear nuestras propias nos permite comunicar errores de dominio con nombres claros, en lugar de usar excepciones genericas como Exception o IllegalArgumentException.

 */
public class ProductoNoEncontradoException extends RuntimeException {
    public ProductoNoEncontradoException(String mensaje){
        // super() llama al constructor de la clase padre (RuntimeException)
        // que es quien guarda el mensaje y lo expone con getmessage();
        super(mensaje);
    }
}
