package OOP1;

import java.util.List;

/** @author Josephine
 * "Nimm-Spiel"
 * Zwei Spieler nehmen Steine von einem Steinhaufen bis kein Stein mehr vorhanden ist.
 * Die Anzahl der Steine im Steinhaufen ist zufällig zwischen 20 und 30, sowie ist auch
 * der Startspieler zufällig. Die Spieler nehmen im Wechsel 1 bis 3 Steine vom Steinhaufen.
 * Verloren hat der Spieler, der den letzten Stein nehmen muss.
 */
class Spiel {

    private int spieleranzahl;
    private List<Spieler> spieler;
    private Steinhaufen steinhaufen;

    @SuppressWarnings("unused")
    public Spiel(int spieleranzahl){
        // er braucht spieler - mit namen, und nicht den int
    }

    /**
     * Spielernamen festlegen?
     * Spielregeln
     * wie viele steine im steinhaufen gesamt
     * startspieler
     * Rundenschleife - spieler nimmt wie viele Steine, wie viele sind übrig
     */
    @SuppressWarnings("EmptyMethod")
    public void spielStart(){
        //Hier sind die Grenzen des Steinhaufens festgelegt, somit brauche ich hier keine Exception, falls max >= min
        steinhaufen = new Steinhaufen(20,30);
        System.out.println(getSpielregeln());
        

    }

    @SuppressWarnings({"SameReturnValue", "unused"})
    public String getSpielregeln(){
        String regeln = " Spielregeln des Nim-Spiels: \n" +
                " Zwei Spieler nehmen Steine von einem Steinhaufen bis kein Stein mehr vorhanden ist. \n" +
                " Die Anzahl der Steine im Steinhaufen ist zufällig zwischen 20 und 30, sowie ist auch \n" +
                " der Startspieler zufällig. Die Spieler nehmen im Wechsel 1 bis 3 Steine vom Steinhaufen.\n" +
                " Verloren hat der Spieler, der den letzten Stein nehmen muss.";
        return regeln;
    }
}
