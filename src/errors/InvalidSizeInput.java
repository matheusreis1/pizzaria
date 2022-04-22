package errors;

/**
 *
 * @author user
 */
public class InvalidSizeInput extends Exception {

    public InvalidSizeInput(String forma, double minimum, double maximum) {
        super("Para a forma " + forma + ", o tamanho minimo é " + minimum + " e o máximo é de " + maximum);
    }

}
