package OOP1;

import java.util.Scanner;

class EinAusgabe {

    private static final Scanner scanner = new Scanner(System.in);

    /**Erik
    *   Gibt den gegebenen String in der Konsole aus
     */
    @SuppressWarnings("WeakerAccess")
    public static void textAusgabe(String ausgabeText){
        System.out.println(ausgabeText);
    }

    /**@author Erik
    *   Liest die nächste Zeile aus, die in die Konsole eingegeben
    */
    @SuppressWarnings("WeakerAccess")
    public static String textEingabe(){
        return scanner.nextLine();
    }

    /**@author Erik
    *   Stellt die gegebene Ja/Nein Frage in der Konsole und gibt die Antwort als Boolean zurück
    */
    @SuppressWarnings({"unused", "ConstantConditions"})
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
    */
    @SuppressWarnings("unused")
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
}
