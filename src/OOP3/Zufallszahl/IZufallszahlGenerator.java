package OOP3.Zufallszahl;

/**
 * @author Erik
 *
 * Interface für Klassen, die Zufalls Ganzzahlen generieren
 */
public interface IZufallszahlGenerator
{
    /**
     * @author Erik
     *
     * Generiert eine Zufalls Ganzzahl zwischen Min und Max
     *
     * @param min Minimalwert der generierten Ganzzahl
     * @param max Maximalwert der generierten Ganzzahl
     * @return Zufalls Ganzzahl zwischen Min und Max
     */
    int GeneriereZufallszahl(int min, int max);
}
