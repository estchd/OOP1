package OOP3.Primzahl;

/**
 * @author Erik
 *
 * Generiert Primzahlen mit der Naiven Methode
 */
public class NaivePrimzahlgenerator extends Primzahlgenerator
{

    /**
     * @author Erik
     *
     * Generiert eine Zufällige Primzahl mit der Naiven Methode
     *
     * @return Eine Zufällige Primzahl
     */
    @Override
    public int generierePrimzahl()
    {
        int prime = getRandomPrimeCeiling();

        while(!testePrimzahl(prime))
        {
            prime--;
        }

        return prime;
    }
}
