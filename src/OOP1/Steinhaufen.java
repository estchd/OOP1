package OOP1;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Josephine
 *
 * Die Steinhaufen-Klasse gibt die Anzahl der Steine im Steinhaufen aus,
 * sowie bietet sie eine Methode an, 1-3 Steine aus dem Steinhaufen zu entnehmen.
 */

class Steinhaufen {

    private int anzSteine;

    /**
     * Erstellt einen neuen Steinhaufen mit einer zufälligen Anzahl von Steinen, die zwischen
     * dem Minimum und Maximum liegt, welches eingegeben wurde.
     * @param minAnzSteine
     * @param maxAnzSteine
     */
    public Steinhaufen(int minAnzSteine, int maxAnzSteine){
        this.anzSteine =  ThreadLocalRandom.current().nextInt(minAnzSteine, maxAnzSteine + 1);
    }

    /**
     * Gibt die noch vorhandene Anzahl Steine im Huafen zurück.
     * @return Anzahl Steine im Haufen
     */
    public int getAnzSteine(){
        return anzSteine;
    }

    /**
     * Private Methode, die die eingebene Anzahl an Steinen von der insgesamten Zahl abzieht.
     */
    private void nimmSteine(int anzahlSteine) {
        this.anzSteine = this.anzSteine - anzahlSteine;
        System.out.println("Es wurden " + anzahlSteine + " Steine aus dem Steinhaufen genommen.");
    }

    /**
     * nimmSteine(String eingabeAnz)
     *  überprüft ob die Eingabe gültig ist. Die Methode entfernt alle
     * NichtZahlen aus dem String und überführt diesen  in einen Integer.
     * Desweiteren wird die Größe überprüft, wirft Exception wenn die Eingabe ungültig,
     * und gibt dessen Grund aus.
     * @param eingabeAnz
     * @throws Exception
     */
    public void nimmSteine(String eingabeAnz) throws Exception {
        String eingabe = eingabeAnz.trim().toLowerCase().replaceAll("[\\D]", "");
        int anzS;
        try {
            anzS = Integer.parseInt(eingabe);
        } catch (NumberFormatException nf) {
            System.out.println("Eingegebener Wert ist keine Zahl! Bitte erneut eingeben.");
            throw nf;
        }
        if (anzS < 1 || anzS > 3 ) {
            System.out.println("Die eingegebene Steinanzahl liegt nicht zwischen 1 und 3 und ist somit ungültig.");
            throw new Exception();
        }
        if (anzSteine < anzS) {
            System.out.println("Die eingegebene Steinanzahl ist größer als die Anzahl, \n" +
                    "die noch im Steinhaufen sind. Es sind noch: " + anzSteine + " Steine da.");
            throw new Exception();
        }
        nimmSteine(anzS);
    }
}
