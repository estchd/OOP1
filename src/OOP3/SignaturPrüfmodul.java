package OOP3;

import OOP3.Prüfsumme.Prüfsummengenerator;
import OOP3.Prüfsumme.QSPrüfsummengenerator;

import java.math.BigInteger;

/**
 * @author Josi
 */
public class SignaturPrüfmodul {

    public static BigInteger generiereSignatur(String dateipfad, Schlüssel schlüssel){
        Prüfsummengenerator prüfsummegen = new QSPrüfsummengenerator();
        BigInteger prüfsumme = BigInteger.valueOf(prüfsummegen.generierePrüfsumme(dateipfad));
        BigInteger g = schlüssel.getGzahl();
        BigInteger d = schlüssel.getZahl();
        BigInteger signat = prüfsumme.modPow(d, g);
        return signat;
    }
    public static boolean prüfeSignatur(String dateipfad, Schlüssel schlüssel, BigInteger signatur){
        Prüfsummengenerator prüfsummegen = new QSPrüfsummengenerator();
        BigInteger prüfsumme = BigInteger.valueOf(prüfsummegen.generierePrüfsumme(dateipfad));
        BigInteger g = schlüssel.getGzahl();
        BigInteger e = schlüssel.getZahl();
        if (prüfsumme  == signatur.modPow(e, g)) {
            return true;
        }
        return false;
    }

}
