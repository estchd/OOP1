package OOP3;

import OOP1.EinAusgabe;
import OOP3.Prüfsumme.FCPrüfsummengenerator;
import OOP3.Prüfsumme.IPrüfsummengenerator;
import OOP3.Prüfsumme.Prüfsummengenerator;
import OOP3.Prüfsumme.QSPrüfsummengenerator;

import java.math.BigInteger;

/**
 * @author Josi
 */
public class SignaturPrüfmodul {

    private IPrüfsummengenerator prüfsummegen;

    public SignaturPrüfmodul()
    {
        prüfsummegen = new FCPrüfsummengenerator();
    }

    public BigInteger generiereSignatur(String dateipfad, Schlüssel privschlüssel) throws IllegalArgumentException
    {
        BigInteger prüfsumme = BigInteger.valueOf(prüfsummegen.generierePrüfsumme(dateipfad));
        return prüfsumme.modPow(privschlüssel.getZahl(), privschlüssel.getGzahl());
    }
    public boolean prüfeSignatur(String dateipfad, Schlüssel pubschlüssel, BigInteger signatur) throws IllegalArgumentException
    {
        BigInteger prüfsumme = BigInteger.valueOf(prüfsummegen.generierePrüfsumme(dateipfad));
        BigInteger calcPrüfsumme = signatur.modPow(pubschlüssel.getZahl(), pubschlüssel.getGzahl());
        return prüfsumme.equals(calcPrüfsumme);
    }

}
