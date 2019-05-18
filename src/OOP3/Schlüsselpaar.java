package OOP3;

/**
 * @author Josi
 */
public class Schlüsselpaar {
    private static Schlüssel öffSchlüssel;
    private static Schlüssel privSchlüssel;

    public Schlüsselpaar(Schlüssel privatSchlüssel, Schlüssel öffentlSchlüssel){
        öffSchlüssel = öffentlSchlüssel;
        privSchlüssel = privatSchlüssel;
    }
}
