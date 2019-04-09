package OOP1;

import java.util.Scanner;

public class EinAusgabe {

    private static Scanner scanner = new Scanner(System.in);

    public static void textAusgabe(String ausgabeText){
        System.out.println(ausgabeText);
    }

    public static String textEingabe(){
        return scanner.nextLine();
    }

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
                continue;
            }
        }
        while(weiterfragen);

        return returnWert;
    }
}
