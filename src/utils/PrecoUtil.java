package utils;

import java.text.NumberFormat;

/**
 *
 * @author user
 */
public class PrecoUtil {

    public static String format(double preco) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String precoFormatado = formatter.format(preco);
        return precoFormatado;
    }

}
