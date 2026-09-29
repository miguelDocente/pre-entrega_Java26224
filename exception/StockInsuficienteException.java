package exception;
/* Excepcion personalizada que se lanza ccuando se intenta asignar un stock invalido (ej: un valor negativo)
 
   Si incorporamos un carrito de compras , podemos senalar el caso en que un cliente quiera comprar más unidades de las disponibles.
   
*/
public class StockInsuficienteException extends RuntimeException{
    public StockInsuficienteException (String mensaje){
        super(mensaje);
    }
    
}
