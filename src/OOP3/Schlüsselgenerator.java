package OOP3;

import OOP3.Primzahl.*;

import java.math.BigInteger;
/**
 * @author Josi
 */
public class Schlüsselgenerator {
    private Primzahlgenerator primgenerator;

    /**
     * @author Josi
     *
     * Konstruktor
     */
    public Schlüsselgenerator(){
        //this.primgenerator = new NaivePrimzahlgenerator();
        this.primgenerator = new SOEPrimzahlgenerator();
    }

    /**
     * @author Josi
     * Generiert aus zufälligen Primzahlen öffentlichen und privaten Schlüssel anhand des RSA Algorithmus.
     * @return Schlüsselpaar
     */
    public Schlüsselpaar generiereSchlüssel(){

        BigInteger p = BigInteger.valueOf(primgenerator.generierePrimzahl());
        BigInteger q = p;
        while (q.equals(p)) {
            q = BigInteger.valueOf(primgenerator.generierePrimzahl());
        }
        BigInteger g = p.multiply(q);
        BigInteger phiVonG = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        //finde e, wobei ggt(e, phiG) = 1, gilt bei e prim
        BigInteger e = p;
        while ( e.equals(p) || e.equals(q) || e.equals(g)) {
            e = BigInteger.valueOf(primgenerator.generierePrimzahl());
        }
        // finde d, wobei (d*e) mod phi(g) = 1
        BigInteger d = e.modInverse(phiVonG);


        //RSA Schlüsselgenerierung
        return new Schlüsselpaar(new Schlüssel(d, g), new Schlüssel(e, g));
    }
}
