package OOP3.Primzahl;

/**
 * @author Erik
 *
 * Generiert Primzahlen mit dem Sieb des Erastothenes
 */
public class SOEPrimzahlgenerator extends Primzahlgenerator
{

    /**
     * @author Erik
     *
     * Generiert eine Zufällige Primzahl
     *
     * @return Eine Zufällige Primzahl
     */
    @Override
    public int generierePrimzahl()
    {
        int primeCeil = getRandomPrimeCeiling();

        boolean[] primes = new boolean[primeCeil + 1];

        for(int i = 0; i <= primeCeil; i++)
        {
            primes[i] = true;
        }

        for(int p = 2; p*p <= primeCeil; p++)
        {
            if(primes[p])
            {
                for(int i = p*p; i<= primeCeil; i+= p)
                {
                    primes[i] = false;
                }
            }
        }
        int i = primeCeil;
        while(!primes[i])
        {
            i--;
        }
        return i;
    }

}
