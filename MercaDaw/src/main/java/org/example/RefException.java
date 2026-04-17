package org.example;

/**
 * Excepción personalizada para controlar errores relacionados
 * con referencias de productos duplicadas.
 *
 * Se lanza cuando se intenta insertar un producto con una referencia
 * que ya existe en el sistema, impidiendo así duplicados.
 */
public class RefException extends Exception {

    /**
     * Constructor de la excepción.
     *
     * Inicializa la excepción con un mensaje personalizado indicando
     * que la referencia ya existe y no puede repetirse.
     *
     * @param message Mensaje de error (no se utiliza directamente,
     *                ya que se establece un mensaje fijo)
     */
    public RefException(String message) {
        super("No se puede repetir Referencia, Vuelva a insertar otro producto pero con otra referencia");
    }
}