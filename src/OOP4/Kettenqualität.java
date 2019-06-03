package OOP4;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kettenqualität implements Comparable<Kettenqualität>{

    private int abstand;

    public int getAbstand()
    {
        return abstand;
    }

    private int häufigkeit;

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
    public static Kettenqualität berechneQualität(List<EFarben> kette)
    {
        //TODO: Prüfen ob nicht doch größtmöglicher Abstand gefragt
        Kettenqualität kettenqualität = new Kettenqualität();
        kettenqualität.abstand = kette.size();
        kettenqualität.häufigkeit = 0;

        Map<EFarben, Integer> last = new EnumMap<>(EFarben.class);

        for (int i = 0; i < kette.size(); i++ )
        {

            EFarben farbe = kette.get(i);
            if(!last.containsKey(farbe))
            {
                last.put(farbe,i);
                continue;
            }

            int farbAbstand = i - last.get(farbe);
            if (farbAbstand == kettenqualität.abstand) {
                kettenqualität.häufigkeit++;
            } else if (farbAbstand < kettenqualität.abstand) {
                kettenqualität.abstand = farbAbstand;
                kettenqualität.häufigkeit = 1;
            }
            last.replace(farbe, i);
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
