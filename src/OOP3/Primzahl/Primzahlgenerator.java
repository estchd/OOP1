package OOP3.Primzahl;

import OOP3.Zufallszahl.*;

/**
 * @author Erik
 *
 * Abstrakte Grundklasse für Primzahlgeneratoren
 */
public abstract class Primzahlgenerator implements IPrimzahlgenerator
{
    private IZufallszahlGenerator rng = new RZufallszahlGenerator();

    /**
     * @author Erik
     *
     * Generiert eine Zufällige Ganzzahl zwischen Integer.MAX_VALUE / 2 und Integer.MAX_VALUE
     *
     * @return Zufällige Ganzzahl zwischen Integer.MAX_VALUE / 2 und Integer.MAX_VALUE
     */
    protected int getRandomPrimeCeiling()
    {
        return rng.GeneriereZufallszahl((Integer.MAX_VALUE / 2),Integer.MAX_VALUE);
    }

    /**
     * @author Erik
     *
     * Generiert eine Zufällige Primzahl
     *
     * @return Zufällige Primzahl
     */
    public abstract int generierePrimzahl();

    /**
     * @author Erik
     *
     * Testet, ob eine gegebene Zahl eine Primzahl
     *
     * @param prim Die zu testende Primzahl
     *
     * @return Wahr, falls die zu testende Zahl Primzahl, sonst Falsch
     */
    public boolean testePrimzahl(int prim)
    {
        for(int p = 2; p*p <= prim; p++)
        {
            if(prim % p == 0)
            {
                System.out.println("Divisible by: " + p);
                return false;
            }
        }
        return true;
    }
}
