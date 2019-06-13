package OOP4;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

/**
 * Klasse zur Generierung von Wimpelketten
 *
 * @author Erik
 */
public class Wimpelketten
{
    /**
     * Generiert alle Wimpelketten mit einem Minimalen Abstand >= kleinstMinAbst
     *
     * @author Erik
     * @param farben Die Verfügbaren Wimpelfarben
     * @param kette Die Schon bestehende Wimpelkette
     * @param kleinstMinAbst Der kleinste minimale Abstand einer generierten Wimpelkette
     * @return Alle möglichen Wimpelketten mit minimalem Abstand >= kleinstMinAbst
     */
    public List<List<Farbe>> generiereWimpelketten(List<Farbe> farben, List<Farbe> kette, int kleinstMinAbst)
    {
        List<List<Farbe>> ketten = new ArrayList<>();

        int wimpel = 0;
        for (Farbe farbe : farben)
        {
            wimpel += farbe.GetAnzahl();
        }

        if(wimpel == 0)
        {
            ketten.add(kette);
            return ketten;
        }

        for (Farbe farbe : farben)
        {
            if(farbe.GetAnzahl() <= 0)
            {
                continue;
            }

            List<Farbe> addKette = new ArrayList<>(kette);

            addKette.add(farbe);

            Kettenqualität kettenqualität = Kettenqualität.berechneQualität(addKette);

            if(kettenqualität.getHäufigkeit() != 0 && kettenqualität.getAbstand() < kleinstMinAbst)
            {
                continue;
            }

            List<Farbe> subFarben = new ArrayList<>(farben);
            int farbenIndex = subFarben.indexOf(farbe);
            Farbe subFarbe = new Farbe(farbe.GetFullName(),farbe.GetShortName(),farbe.GetAnzahl() - 1);
            subFarben.set(farbenIndex,subFarbe);

            ketten.addAll(generiereWimpelketten(subFarben,addKette, kleinstMinAbst));
        }

        return ketten;
    }
}
