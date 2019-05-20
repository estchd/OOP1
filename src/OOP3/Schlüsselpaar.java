package OOP3;

/**
 * @author Josi
 */
public class Schlüsselpaar {
    private Schlüssel öffSchlüssel;
    private Schlüssel privSchlüssel;

    /**
     * Konstruktor
     * @param privatSchlüssel privater Schlüssel zum signieren
     * @param öffentlSchlüssel öffentlicher Schlüssel zum Überprüfen
     */
    public Schlüsselpaar(Schlüssel privatSchlüssel, Schlüssel öffentlSchlüssel){
        öffSchlüssel = öffentlSchlüssel;
        privSchlüssel = privatSchlüssel;
    }

    /**
     * Getter
     * @return privater Schlüssel
     */
    public Schlüssel getPrivate(){
        return privSchlüssel;
    }
    /**
     * Getter
     * @return öffentlicher Schlüssel
     */
    public Schlüssel getPublic(){
        return öffSchlüssel;
    }

    /**
     * @author Erik
     *
     * Stringrepräsentation dieser Klasse.
     * @return String mit den beiden Schlüsseln.
     */
    @Override
    public String toString()
    {
        return " (öffentl. | privat) : ( " + öffSchlüssel.toString() + " | " + privSchlüssel.toString() + " )";
    }
}
