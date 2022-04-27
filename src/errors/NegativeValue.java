package errors;

/**
 *
 * @author user
 */
public class NegativeValue extends Exception {

    public NegativeValue() {
        super("O valor nao pode ser negativo!");
    }

}
