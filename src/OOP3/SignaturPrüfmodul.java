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

    /**
     * @author Josi
     * Konstruktor
     */
    public SignaturPrüfmodul()
    {
        prüfsummegen = new FCPrüfsummengenerator();
    }

    /**
     * @author Josi
     *
     * Generiert die Signatur anhand der Prüfsumme der Datei und gibt diese als BigInteger zurück.
     * @param dateipfad als String
     * @param privschlüssel
     * @return Signatur als BigInteger
     * @throws IllegalArgumentException
     */
    public BigInteger generiereSignatur(String dateipfad, Schlüssel privschlüssel) throws IllegalArgumentException
    {
        BigInteger prüfsumme = BigInteger.valueOf(prüfsummegen.generierePrüfsumme(dateipfad));
        return prüfsumme.modPow(privschlüssel.getZahl(), privschlüssel.getGzahl());
    }

    /**
     * Überprüft die eingebene Signatur der Datei und gibt true/false zurück.
     *
     * @author Josi
     * @param dateipfad als String
     * @param pubschlüssel
     * @param signatur als BigInteger
     * @return Prüfergebnis als boolean
     * @throws IllegalArgumentException
     */
    public boolean prüfeSignatur(String dateipfad, Schlüssel pubschlüssel, BigInteger signatur) throws IllegalArgumentException
    {
        BigInteger prüfsumme = BigInteger.valueOf(prüfsummegen.generierePrüfsumme(dateipfad));
        BigInteger calcPrüfsumme = signatur.modPow(pubschlüssel.getZahl(), pubschlüssel.getGzahl());
        return prüfsumme.equals(calcPrüfsumme);
    }

}
