package OOP4;


import java.util.*;

/**
 * Klasse zur bestimmung der Qualität von Wimpelketten
 *
 * @author Josi
 */
public class Kettenqualität implements Comparable<Kettenqualität>{

    private int abstand;
    private int häufigkeit;

    /**
     * Gibt den Minimalen Abstand der Wimpel in der Kette zurück
     *
     * @author Josi
     * @return Der Minimale Abstand der Wimpel in der Kette
     */
    public int getAbstand()
    {
        return abstand;
    }

    /**
     * Gibt die Häufigkeit des Minimalen Abstands in der Kette zurück
     *
     * @author Josi
     * @return Die Häufigkeit des Minimalen Abstand in der Kette
     */
    public int getHäufigkeit()
    {
        return häufigkeit;
    }

    /**
     * Bestimmt die Quallität der Kette und gibt diese zurück.
     * @author Josi
     * @param kette Liste mit Farben
     * @return
     */
    public static Kettenqualität berechneQualität(List<Farbe> kette)
    {
        Kettenqualität kettenqualität = new Kettenqualität();
        kettenqualität.abstand = kette.size();
        kettenqualität.häufigkeit = 0;

        Integer[] last = new Integer[kette.size()];

        for(int i = 0; i < last.length ; i++)
        {
            last[i] = -1;
        }

        for (int i = 0; i < kette.size(); i++ )
        {

            Farbe farbe = kette.get(i);
            if(last[kette.indexOf(farbe)] == -1)
            {
                last[kette.indexOf(farbe)] = i;
                continue;
            }

            int farbAbstand = i - last[kette.indexOf(farbe)];
            if (farbAbstand == kettenqualität.abstand) {
                kettenqualität.häufigkeit++;
            } else if (farbAbstand < kettenqualität.abstand) {
                kettenqualität.abstand = farbAbstand;
                kettenqualität.häufigkeit = 1;
            }
            last[kette.indexOf(farbe)] = i;
        }
        return kettenqualität;
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
