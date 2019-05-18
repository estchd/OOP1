package OOP3.Prüfsumme;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Erik
 *
 * Abstrakte Grundklasse für Prüfsummengeneratoren
 */
public abstract class Prüfsummengenerator implements IPrüfsummengenerator
{
    /**
     * @author Erik
     *
     * Generiert die Prüfsumme für die gegebene Textdatei
     *
     * @param pfad Der Pfad zur Textdatei
     * @return Die Prüfsumme des Texts
     */
    public long generierePrüfsumme(String pfad)
    {
        String text;
        try {
            text = LoadFile(pfad);
        }
        catch(IOException e){
            throw new IllegalArgumentException("Could not Read File!");
        }

        return generateTextChecksum(text);
    }

    /**
     * @author Erik
     *
     * Lädt eine Textdatei und gibt den Inhalt aus
     *
     * @param path Der Pfad der Textdatei
     * @return Der Inhalt der Textdatei
     */
    private String LoadFile(String path) throws IOException
    {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    /**
     * @author Erik
     *
     * Generiert die Prüfsumme eines Texts
     *
     * @param text Der Text
     * @return Die Prüfsumme des Texts
     */
    protected abstract long generateTextChecksum(String text);

}
