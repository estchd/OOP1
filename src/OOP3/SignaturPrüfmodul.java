package OOP3;

import OOP3.Prüfsumme.Prüfsummengenerator;
import OOP3.Prüfsumme.QSPrüfsummengenerator;

import java.math.BigInteger;

/**
 * @author Josi
 */
public class SignaturPrüfmodul {

    public static BigInteger generiereSignatur(String dateipfad, Schlüssel privschlüssel){
        Prüfsummengenerator prüfsummegen = new QSPrüfsummengenerator();
        BigInteger prüfsumme = BigInteger.valueOf(prüfsummegen.generierePrüfsumme(dateipfad));
        BigInteger g = privschlüssel.getGzahl();
        BigInteger d = privschlüssel.getZahl();
        BigInteger signat = prüfsumme.modPow(d, g);
        return signat;
    }
    public static boolean prüfeSignatur(String dateipfad, Schlüssel pubschlüssel, BigInteger signatur){
        Prüfsummengenerator prüfsummegen = new QSPrüfsummengenerator();
        BigInteger prüfsumme = BigInteger.valueOf(prüfsummegen.generierePrüfsumme(dateipfad));
        BigInteger g = pubschlüssel.getGzahl();
        BigInteger e = pubschlüssel.getZahl();
        if (prüfsumme  == signatur.modPow(e, g)) {
            return true;
        }
        return false;
    }

}
