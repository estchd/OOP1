package OOP3.Primzahl;

/**
 * @author Erik
 *
 * Interfade für Klassen, die Zufällige Primzahlen generieren
 */
public interface IPrimzahlgenerator
{
    /**
     * @author Erik
     *
     * Generiert eine Zufällige Primzahl
     *
     * @return Zufällige Primzahl
     */
    int generierePrimzahl();

    /**
     * @author Erik
     *
     * Testet ob eine Zahl eine Primzahl ist
     *
     * @param prim Die zu testende Primzahl
     *
     * @return Wahr, falls die gegebene Zahl eine Primzahl, sonst falsch
     */
    boolean testePrimzahl(int prim);
}
