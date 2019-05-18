package OOP1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/** @author Josephine
 * Die Klasse des Nim-Spiels führt das Spiel entsprechend der Regeln und der Spieleranzahl durch.
 *
 */
class Spiel {

    private int spieleranzahl;
    private List<Spieler> spielerList;
    private Steinhaufen steinhaufen;

    /**
     * Erstellt ein neues Spiel mit der eingegebenen Anzahl an Spielern.
     * @param spielerAnz Anzahl der Spieler
     */
    public Spiel(int spielerAnz){
        this.spieleranzahl = spielerAnz;
    }

    /**
     * Diese Methode führt das gesamte Spiel durch.
     * Sie gibt erstellt einen neuen Steinhaufen für das Spiel, gibt die Spielregeln aus und
     * erstellt die Namen für die Spieler, vor Beginn.
     * Danach ist angefangen von einem zufälligen Startspieler jeder Spieler an der Reihe und
     * entnimmt Steine.
     */
    public void spielStart(){
        //Hier sind die Grenzen des Steinhaufens festgelegt, somit brauche ich hier keine Exception, falls max >= min
        steinhaufen = new Steinhaufen(20,30);
        System.out.println(getSpielregeln());
        System.out.println("Bitte die Spielernamen festlegen. Dabei beachten Sie, \n"+
                "das der Startspieler noch zufällig festgelegt wird.");
        spielerList = new ArrayList<Spieler>();
        for (int i = 1; i <= spieleranzahl; i++){
            String name = EinAusgabe.einfacheAbfrage("Eingabe Spielername" + i + ": ").trim();
            Spieler spieler = new Spieler();
            spieler.setName(name);
            spielerList.add(spieler);
            System.out.println("Es wurde "+ name + " als Spielername gesetzt.");
        }
        int anfangsspieler = ThreadLocalRandom.current().nextInt(1, spieleranzahl + 1);
        boolean hatSteine = true;
        while (hatSteine) {
            int i = 0;
            while (i< spieleranzahl) {
                int indexSpieler = anfangsspieler;
                if (i!=0) {
                    if (anfangsspieler + i <= spieleranzahl) {
                        indexSpieler = anfangsspieler + i;
                    } else {
                        indexSpieler = i + anfangsspieler - spieleranzahl;
                    }
                }
                System.out.println("Es sind " + steinhaufen.getAnzSteine() + " Steine im Haufen.");
                Spieler spieler = spielerList.get(indexSpieler - 1);
                boolean abfrageGueltig = true;
                while (abfrageGueltig) {
                    abfrageGueltig = false;
                    String entnahmeSteine = EinAusgabe.einfacheAbfrage(spieler.getName() + " gibt ein wie viele Steine er entnehmen will. (1-3 sind erlaubt)");
                    try {
                        steinhaufen.nimmSteine(entnahmeSteine);
                    } catch (Exception e) {
                        abfrageGueltig = true;
                        System.out.println("Fehler in der Eingabe, bitte um erneute Werteingabe.");
                    }
                }
                if (steinhaufen.getAnzSteine() <= 0) {
                    hatSteine = false;
                    System.out.println(spieler.getName() + " hat den letzten Stein genommen und verliert somit :(.\n" +
                            "Nächstes Mal klappts bestimmt besser.");
                    spielerList.remove(spieler);
                    System.out.println("Gewonnen haben:");
                    for (Spieler gewonnenSpieler: spielerList) {
                        System.out.println(gewonnenSpieler.getName());
                    }
                    break;
                }
                i++;
            }
        }
    }

    /**
     * Die Methode gibt die Spielregeln zurück.
     * @return Spielregeln als String
     */
    public String getSpielregeln(){
        String regeln = " Spielregeln des Nim-Spiels: \n" +
                " Zwei Spieler nehmen Steine von einem Steinhaufen bis kein Stein mehr vorhanden ist. \n" +
                " Die Anzahl der Steine im Steinhaufen ist zufällig zwischen 20 und 30, sowie ist auch \n" +
                " der Startspieler zufällig. Die Spieler nehmen im Wechsel 1 bis 3 Steine vom Steinhaufen.\n" +
                " Verloren hat der Spieler, der den letzten Stein nehmen muss.";
        return regeln;
    }
}
