package OOP3;

import OOP3.Primzahl.NaivePrimzahlgenerator;
import OOP3.Primzahl.Primzahlgenerator;
import OOP3.Primzahl.SOEPrimzahlgenerator;

import java.math.BigInteger;
/**
 * @author Josi
 */
public class Schlüsselgenerator {
    private static Primzahlgenerator primgenerator;


    public Schlüsselgenerator(){
        //this.primgenerator = new NaivePrimzahlgenerator();
        this.primgenerator = new SOEPrimzahlgenerator();
    }

    public static Schlüsselpaar generiereSchlüssel(){

        BigInteger p = BigInteger.valueOf(primgenerator.generierePrimzahl());
        BigInteger q = p;
        while (q == p) {
            q = BigInteger.valueOf(primgenerator.generierePrimzahl());
        }
        BigInteger g = p.multiply(q);
        BigInteger phiVonG = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        //finde e, wobei ggt(e, phiG) = 1, gilt bei e prim
        BigInteger e = p;
        while ( e == p || e == q || e== g) {
            e = BigInteger.valueOf(primgenerator.generierePrimzahl());
        }
        // finde d, wobei (d*e) mod phi(g) = 1
        BigInteger d = e.modInverse(phiVonG);


        //RSA Schlüsselgenerierung
        Schlüssel öffschl = new Schlüssel(e, g);
        Schlüssel pschl = new Schlüssel(d, g);
        Schlüsselpaar schlüsselp = new Schlüsselpaar(pschl, öffschl);
        return schlüsselp;
    }
}
