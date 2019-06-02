package OOP4;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class Kettenqualität implements Comparable<Kettenqualität>{

    private int abstand;
    private int häufigkeit;

    /**
     * Bestimmt die Quallität der Kette und gibt diese zurück.
     * @author Josi
     * @param kette Liste mit Farben
     * @return
     */
    public Kettenqualität berechneQualität(List<EFarben> kette)
    {
        //TODO: Prüfen ob nicht doch größtmöglicher Abstand gefragt
        int firstR = 0;
        int firstB = 0;
        int firstG = 0;
        int firstW = 0;
        int firstS = 0;

        for (int i = 0; i<kette.size(); i++ ) {
            EFarben farb = kette.get(i);
            if (farb == EFarben.Rot) {
                if ((i - firstR) == abstand ) {
                    abstand++;
                    häufigkeit++;
                } else if ((i - firstR) < abstand) {
                    abstand = (i - firstR);
                    häufigkeit = 1;
                }
                firstR = i;
            } else if (farb == EFarben.Blau) {
                if ((i - firstB) == abstand ) {
                    abstand++;
                    häufigkeit++;
                } else if ((i - firstB) < abstand) {
                    abstand = (i - firstB);
                    häufigkeit = 1;
                }
                firstB = i;
            }else if (farb == EFarben.Gelb) {
                if ((i - firstG) == abstand ) {
                abstand++;
                häufigkeit++;
            } else if ((i - firstG) < abstand) {
                abstand = (i - firstG);
                häufigkeit = 1;
            }
                firstG = i;
            }else if (farb == EFarben.Weiß) {
                if ((i - firstW) == abstand ) {
                abstand++;
                häufigkeit++;
            } else if ((i - firstW) < abstand) {
                abstand = (i - firstW);
                häufigkeit = 1;
            }
                firstW = i;
            }else if (farb == EFarben.Schwarz) {
                if ((i - firstS) == abstand ) {
                    abstand++;
                    häufigkeit++;
                } else if ((i - firstS) < abstand) {
                    abstand = (i - firstS);
                    häufigkeit = 1;
                }
                firstS = i;
            }
        }

        return this;
    }

    /**
     * Vergleichsmethode der Kettenqualität
     *
     * @author Josi
     * @param o anderes Objekt der Kettenqualität zum Vergleich
     * @return ein negativer Integer, Null, oder ein positiver Integer wenn dieses Objekt is weniger als, gleich, oder größer als das bestimmte  Objekt.
     */
    @Override
    public int compareTo(Kettenqualität o)
    {
        if (this.abstand < o.abstand) {
            //kleiner als o
            return -1;
        } else if (this.abstand > o.abstand) {
            //größer als o
            return 1;
        } else {
            if (this.häufigkeit < o.häufigkeit) {
                return -1;
            } else if (this.häufigkeit > o.häufigkeit) {
                return 1;
            }
        }
        //sonst gleich
        return 0;
    }
}
