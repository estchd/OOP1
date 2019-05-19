package OOP3;

/**
 * @author Josi
 */
public class Schlüsselpaar {
    private Schlüssel öffSchlüssel;
    private Schlüssel privSchlüssel;

    public Schlüsselpaar(Schlüssel privatSchlüssel, Schlüssel öffentlSchlüssel){
        öffSchlüssel = öffentlSchlüssel;
        privSchlüssel = privatSchlüssel;
    }

    public Schlüssel getPrivate(){
        return privSchlüssel;
    }
    public Schlüssel getPublic(){
        return öffSchlüssel;
    }

    @Override
    public String toString()
    {
        return "( " + öffSchlüssel.toString() + " | " + privSchlüssel.toString() + " )";
    }
}
