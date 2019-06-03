package OOP1;

import OOP3.Schlüssel;
import OOP3.Schlüsselpaar;

import java.math.BigInteger;
import java.util.Scanner;

public class EinAusgabe {

    private static final Scanner scanner = new Scanner(System.in);

    /**@author Erik
     *   Gibt den gegebenen String in der Konsole aus
     *
     * @param ausgabeText Der Text der ausgegeben werden soll
     */
    public static void textAusgabe(String ausgabeText){
        System.out.println(ausgabeText);
    }

    /**@author Erik
     *   Liest die nächste Zeile aus, die in die Konsole eingegeben
     *
     * @return Der in der Konsole eingegebene Text
    */
    public static String textEingabe(){
        return scanner.nextLine();
    }

    /**@author Erik
     *   Stellt die gegebene Ja/Nein Frage in der Konsole und gibt die Antwort als Boolean zurück
     *
     * @param frageText Die Frage, die gestellt werden soll
     *
     * @return Die Antwort auf die Ja/Nein Frage als Boolean (True für Ja, False für Nein)
    */


    @SuppressWarnings({"ConstantConditions", "SameParameterValue"})
    public static boolean jaNeinFrage(String frageText) {

        boolean weiterfragen;
        boolean returnWert = false;

        do{
            weiterfragen = false;
            textAusgabe(frageText + " (J/N)");
            String antwort = textEingabe();

            if(antwort.equalsIgnoreCase("J") || antwort.equalsIgnoreCase("Ja")){
                returnWert = true;
            }
            else if(antwort.equalsIgnoreCase("N") || antwort.equalsIgnoreCase("Nein")){
                returnWert = false;
            }
            else{
                textAusgabe("Bitte mit Ja oder Nein antworten!");
                weiterfragen = true;
            }
        }
        while(weiterfragen);

        return returnWert;
    }

    /**@author Erik
     *   Fragt in der Konsole mit der gegebenen Frage nach einem Wert zwischen min und max Wert und gibt den eingegebenen Wert als integer zurück
     *
     * @param frageText Die Frage, die gestellt werden soll
     * @param minimalWert Der minimale Wert, der als Antwort zugelassen werden soll
     * @param maximalWert Der maximale Wert, der als Antwort zugelassen werden soll
     *
     * @return Die Antwort in Form eines int
    */
    @SuppressWarnings("SameParameterValue")
    public static int intBereichAbfrage(String frageText, int minimalWert, int maximalWert) {

        if(minimalWert >= maximalWert){
            throw new IllegalArgumentException("MinimalWert kann nicht größer oder gleich sein als der MaximalWert!");
        }

        boolean weiterfragen;
        int returnWert = 0;
        do {
            weiterfragen = false;
            textAusgabe(frageText + " Bitte eine Zahl zwischen " + minimalWert + " und " + maximalWert + " angeben!");
            String eingabeString = textEingabe();
            try {
                returnWert = Integer.parseInt(eingabeString);
            }
            catch(NumberFormatException e){
                textAusgabe("Bitte eine Zahl eingeben!");
                weiterfragen = true;
                continue;
            }

            if(returnWert < minimalWert || returnWert > maximalWert) {
                textAusgabe("Bitte eine Zahl zwischen " + minimalWert + " und " + maximalWert + " eingeben!");
                weiterfragen = true;
            }
        }
        while(weiterfragen);

        return returnWert;
    }

    /** @author Josi
     * Eine einfache Konsolenabfrage, er gibt den Text ausgabe aus, und den eingegeben String zurück.
     *
     * @param ausgabe Die Frage, die gestellt werden soll
     *
     * @return Eingabe als String
     */
    public static String einfacheAbfrage(String ausgabe) {
        textAusgabe(ausgabe);
        String eingabe = textEingabe();
        return eingabe;
    }

    public static int intAbfrage(String frage)
    {
        textAusgabe(frage);
        int res = 0;

        boolean weiterfragen = true;
        do
        {

            String eingabe = textEingabe();
            try
            {
                res = Integer.parseInt(eingabe);
            }
            catch (NumberFormatException ex)
            {
                textAusgabe("Bitte eine Zahl angeben!");
                continue;
            }
            weiterfragen = false;
        }
        while(weiterfragen);

        return res;
    }

    public static int positiveIntAbfrage(String frage)
    {
        int res = 0;

        boolean weiterfragen = true;
        do
        {
            res = intAbfrage(frage);
            if(res < 0)
            {
                textAusgabe("Bitte eine Positive Zahl angeben!");
                continue;
            }
            weiterfragen = false;
        }
        while(weiterfragen);

        return res;
    }

    /**
     * @author Josi
     *
     * Konsolenabfrage nach einer Zahl.
     * @param frage : String der auf der Konsole ausgegeben werden soll.
     * @return zahl : abgefragte Zahl als BigInteger.
     */
    public static BigInteger bigIntAbfrage(String frage)
    {
        textAusgabe(frage);
        BigInteger zahl = BigInteger.ZERO;
        boolean weiterfragen = true;
        while (weiterfragen) {
            try {
                String eingabe = textEingabe().trim().toLowerCase();
                zahl = new BigInteger(eingabe);
                weiterfragen = false;
                if (zahl.compareTo(BigInteger.ZERO) < 0) {
                    System.out.println("Eingegebener Wert ist kleiner 0! Bitte erneut eingeben.");
                    weiterfragen = true;
                }
            } catch (NumberFormatException nf) {
                System.out.println("Eingegebener Wert ist keine Zahl! Bitte erneut eingeben.");
                weiterfragen = true;
            } catch (Exception e) {
                System.out.println("Eingegebener Wert ist ungültig! Bitte erneut eingeben.");
                weiterfragen = true;
            }
        }

        return zahl;
    }

    /**
     * @author Erik
     *
     * Eine Abfrage von einer Liste von Möglichkeiten, bei der eine durch einen Integer ausgewählt werden muss.
     * @param frage Konsolenausgabe als String
     * @param möglichkeiten eine Liste an Auswahlmöglichkeiten
     * @return Konsoleneingabe des Indexes der Auswahl als Integer
     */
    public static int auswahlAbfrage(String frage, String[] möglichkeiten)
    {
        boolean hasAnswer = false;

        do{
            textAusgabe(frage);
            textAusgabe("Möglichkeiten:");
            for(int i = 0; i < möglichkeiten.length; i++)
            {
                textAusgabe("   " + möglichkeiten[i]);
            }
            String eingabe = textEingabe();

            for(int i = 0; i < möglichkeiten.length; i++)
            {
                if(eingabe.compareToIgnoreCase(möglichkeiten[i]) == 0)
                {
                    return i;
                }
            }
            textAusgabe("Fehlerhafte Eingabe! Bitte eine der Möglichkeiten Angeben!");
        }
        while (true);
    }

    /**
     * @author Erik
     *
     * Abfrage nach einem Schlüssel.
     * @param frage Konsolenausgabe als String
     * @return Konsoleneingabe als Schlüssel
     */
    public static Schlüssel schlüsselAbfrage(String frage)
    {
        textAusgabe(frage);
        BigInteger zahl = bigIntAbfrage("Bitte Zahl angeben:");
        BigInteger gzahl = bigIntAbfrage("Bitte gZahl angeben:");

        return new Schlüssel(zahl,gzahl);
    }

    /**
     * @author Josi
     *
     * Abfrage nach einem Schlüsselpaar
     * @param frage Konsolenausgabe als String
     * @return Konsoleneingabe als Schlüsselpaar
     */
    public static Schlüsselpaar schlüsselpaarAbfage(String frage)
    {
        textAusgabe(frage);
        Schlüssel pubKey = schlüsselAbfrage("Bitte Öffentlichen Schlüssel angeben:");
        Schlüssel privKey = schlüsselAbfrage("Bitte Privaten Schlüssel angeben:");

        return new Schlüsselpaar(privKey,pubKey);
    }
}
