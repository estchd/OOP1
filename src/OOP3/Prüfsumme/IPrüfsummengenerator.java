package OOP3.Prüfsumme;

/**
 * @author Erik
 *
 * Interface für Klassen, die Prüfsummen von Textdateien generieren
 */
public interface IPrüfsummengenerator
{
    /**
     * @author Erik
     *
     * Generiert die Prüfsumme für die gegebene Textdatei
     *
     * @param pfad Der Pfad zur Textdatei
     * @return Die Prüfsumme des Texts
     */
    long generierePrüfsumme(String pfad) throws IllegalArgumentException;
}
