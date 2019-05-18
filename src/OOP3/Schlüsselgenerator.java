package OOP3;

import java.math.BigInteger;

/**
 * @author Josi
 */
public class Schlüsselgenerator {
    private static IPrimzahlgenerator primgenerator;

    public Schlüsselgenerator(){
        //random für eins von beiden
        this.primgenerator = new SOEPrimzahlgenerator();
    }

    public static Schlüsselpaar generiereSchlüssel(){

        BigInteger p = BigInteger.valueOf(primgenerator.generierePrinzahl());
        BigInteger q = BigInteger.valueOf(primgenerator.generierePrinzahl());
        BigInteger g = p.multiply(q);
        BigInteger phiVonG = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        //finde e, wobei ggt(e, phiG) = 1, gilt bei e prim
        BigInteger e = BigInteger.valueOf(primgenerator.generierePrinzahl());
        BigInteger d = new BigInteger("1");
        while (phiVonG.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phiVonG) < 0)
        {
            e.add(BigInteger.ONE);
        }
        d = e.modInverse(phiVonG);
        if ( (d.multiply(e)).mod(phiVonG) == BigInteger.ONE){
                System.out.println("d funktioniert und ist vom Wert: " + d);
        } else {
            System.out.println("d funktioniert NICHT und ist vom Wert: " + d);
        }


        //RSA Schlüsselgenerierun
        Schlüssel öffschl = new Schlüssel(e, g);
        Schlüssel pschl = new Schlüssel(d, g);
        Schlüsselpaar schlüsselp = new Schlüsselpaar(pschl, öffschl);
        return schlüsselp;
    }
}
