package OOP1;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Josephine
 * Die Steinhaufen-Klasse gibt die Anzahl der Steine im Steinhaufen aus,
 * sowie bietet sie eine Methode an, 1-3 Steine aus dem Steinhaufen zu entnehmen
 */
@SuppressWarnings("unused")
class Steinhaufen {

    private int anzSteine;

    public Steinhaufen(int minAnzSteine, int maxAnzSteine){
        this.anzSteine =  ThreadLocalRandom.current().nextInt(minAnzSteine, maxAnzSteine + 1);
    }

    @SuppressWarnings("SameReturnValue")
    public int getAnzSteine(){
        return anzSteine;
    }

    @SuppressWarnings("EmptyMethod")
    /**
     * Exception in Main behandelt, Exception " bitte anderen Wert eingeben, weil..."
     * wdh der Eingabe
     */
    public void nimmSteine(int anzahlSteine) throws Exception{
        if (anzahlSteine >= 1 && anzahlSteine<=3) {
            if (anzSteine >= anzahlSteine) {
                this.anzSteine = this.anzSteine - anzahlSteine;
                System.out.println("Es wurden " + anzahlSteine + " aus dem Steinhaufen genommen.");
            } else {
                throw Exception;
            }
        } else {
            throw Exception;
        }

    }
}
