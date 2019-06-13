package OOP4;

/**
 * Repräsentiert eine Farbe
 * @author Erik
 */
public class Farbe {


    private String fullName;
    private String shortName;
    private int anzahl;

    /**
     * Konstruiert eine neue Farbe
     *
     * @author Erik
     * @param fullName Der Volle Name der Farbe, eg. Schwarz
     * @param shortName Der Kurze Name der Farbe, eg. s
     */
    public Farbe(String fullName, String shortName, int anzahl)
    {
        this.fullName = fullName;
        this.shortName = shortName;
        this.anzahl = anzahl;
    }

    /**
     * Gibt den Vollen Namen der Farbe zurück
     *
     * @author Erik
     * @return Der Volle Name der Farbe
     */
    public String GetFullName()
    {
        return fullName;
    }

    /**
     * Setzt den Vollen Namen der Farbe
     *
     * @author Erik
     * @param fullName Der neue Volle Name der Farbe
     */
    public void SetFullName(String fullName)
    {
        this.fullName = fullName;
    }

    /**
     * Gibt den Kurzen Namen der Farbe zurück
     *
     * @author Erik
     * @return Der Kurze Name der Farbe
     */
    public String GetShortName()
    {
        return shortName;
    }

    /**
     * Setzt den Kurzen Namen der Farbe
     *
     * @author Erik
     * @param shortName Der neue Kurze Name der Farbe
     */
    public void SetShortName(String shortName)
    {
        this.shortName = shortName;
    }

    /**
     * Gibt die Anzahl der Wimpel mit der Farbe zurück
     *
     * @author Erik
     * @return Die Anzahl der Wimpel mit der Farbe
     */
    public int GetAnzahl()
    {
        return anzahl;
    }

    /**
     * Setzt die Anzahl der Wimpel mit der Farbe
     *
     * @author Erik
     * @param anzahl Die neue Anzahl der Wimpel mit der Farbe
     */
    public void SetAnzahl(int anzahl)
    {
        this.anzahl = anzahl;
    }

    /**
     * Vergleicht die Farbe mit anderen Objekten
     *
     * @param obj Das andere Objekt
     * @return Wahr, falls dass andere Objekt eine Farbe mit gleichem Vollen Namen, sonst Falsch
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Farbe)) {
            return false;
        }
        Farbe other = (Farbe) obj;
        return this.fullName.equals(other.fullName);
    }
}
