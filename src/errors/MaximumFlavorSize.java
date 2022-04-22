package errors;

/**
 *
 * @author user
 */
public class MaximumFlavorSize extends Exception {

    public MaximumFlavorSize(int size) {
        super("O tamanho máximo (" + size + ") de sabores foi atingido!");
    }

}
