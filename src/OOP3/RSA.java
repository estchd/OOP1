package OOP3;

import java.math.BigInteger;
import OOP1.EinAusgabe;

public class RSA {
    private Schlüsselgenerator schlüsselgenerator;
    private SignaturPrüfmodul signaturmodul;

    public RSA(){
        this.schlüsselgenerator = new Schlüsselgenerator();
        this.signaturmodul = new SignaturPrüfmodul();
    }

    /**
     * @author Josi und Erik
     *
     * Die Methode fragt den auszuführenden Modus ab, und bildet den Rahmen diesen durchzuführen.
     */
    public void start(){

        int modus = EinAusgabe.auswahlAbfrage("Welcher Modus?",new String[]{"Schlüssel","Signieren","Prüfen","Alles"});
        switch (modus) {
            case 0:
                EinAusgabe.textAusgabe("Modus Schlüsselgeneration gewählt.");
                schlüsselGenerieren();
                break;

            case 1:
                EinAusgabe.textAusgabe("Modus Signieren gewählt.");
                signaturGenerieren();
                break;

            case 2:
                EinAusgabe.textAusgabe("Modus Signatur Prüfen gewählt.");
                signaturPrüfen();
                break;

            case 3:
                System.out.println("Modus Alles Gewählt.");
                schlüsselGenerieren();
                signaturGenerieren();
                signaturPrüfen();
                break;
        }
        System.out.println("Programm beendet.");
    }

    /**
     * @author Erik
     *
     * Generiert ein Schlüsselpaar und gibt diese auf der Konsole aus.
     */
    private void schlüsselGenerieren()
    {
        Schlüsselpaar keys = schlüsselgenerator.generiereSchlüssel();
        EinAusgabe.textAusgabe("Generierte Schlüssel : " + keys.toString());
    }

    /**
     * @author  Josi
     *
     * Generiert eine Signatur anhand das eingegebenen privaten Schlüssels und gibt diese Signatur
     * auf der Konsole aus.
     */
    private void signaturGenerieren()
    {
        Schlüssel privkey = EinAusgabe.schlüsselAbfrage("Bitte Privaten Schlüssel eingeben:");
        EinAusgabe.textAusgabe("Eingegebener Schlüssel: " + privkey.toString());

        boolean hatFunktioniert;
        BigInteger signatur = new BigInteger("0");

        do {
            hatFunktioniert = true;
            EinAusgabe.textAusgabe("Bitte Dateipfad eingeben:");
            String dateipfad = EinAusgabe.textEingabe();
            EinAusgabe.textAusgabe("Eingegebener Dateipfad: " + dateipfad);

            try
            {
                signatur = signaturmodul.generiereSignatur(dateipfad, privkey);
            }
            catch(IllegalArgumentException e)
            {
                hatFunktioniert = false;
                EinAusgabe.textAusgabe("Dateipfad ungültig!");
            }
        }
        while(!hatFunktioniert);

        EinAusgabe.textAusgabe("Die Signatur der Datei lautet: " + signatur);
    }

    /**
     * @author Josi und Erik
     *
     * Überprüft die eingegebene Signatur der angebenen Datei und gibt die Korrektheit auf der Konsole aus.
     */
    private void signaturPrüfen()
    {
        Schlüssel pubkey = EinAusgabe.schlüsselAbfrage("Bitte Öffentlichen Schlüssel eingeben:");
        EinAusgabe.textAusgabe("Eingegebener Schlüssel: " + pubkey.toString());

        BigInteger signatur = EinAusgabe.bigIntAbfrage("Bitte Signatur eingeben:");
        EinAusgabe.textAusgabe("Eingegebene Signatur: " + signatur.toString());

        boolean prüf = false;
        boolean hatFunkioniert;
        do {
            hatFunkioniert = true;
            EinAusgabe.textAusgabe("Bitte Dateipfad eingeben:");
            String dateipfad = EinAusgabe.textEingabe();
            EinAusgabe.textAusgabe("Eingegebener Dateipfad: " + dateipfad);

            try
            {
                prüf = signaturmodul.prüfeSignatur(dateipfad, pubkey, signatur);
            }
            catch(IllegalArgumentException e)
            {
                hatFunkioniert = false;
                EinAusgabe.textAusgabe("Dateipfad ungültig!");
            }
        }
        while(!hatFunkioniert);

        if (prüf)
        {
            System.out.println("Die Signatur ist korrekt.");
        }
        else {
            System.out.println("Die Signatur ist nicht korrekt.");
        }
    }
}
