package OOP4;

import OOP1.EinAusgabe;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

/**
 * Klasse für das Verteilen von Wimpeln auf Ketten
 *
 * @author Erik
 */
public class Wimpelverteilung
{
    /**
     * Führt eine Wimpelverteilung durch
     * Fragt erst die verfügbaren Wimpel ab und berechnet dann die besten Wimpelketten
     *
     * @author Erik
     */
    public void start()
    {
        List<Farbe> farben = EinAusgabe.FarbenAbfrage("Welche Farben gibt es?");

        int anzahlWimpel = 0;

        for (Farbe farbe : farben) {
            anzahlWimpel += farbe.GetAnzahl();
        }

        if(anzahlWimpel == 0)
        {
            EinAusgabe.textAusgabe("Ohne Wimpel können keine Ketten gebastelt werden :(");
            return;
        }

        Wimpelketten wimpelketten = new Wimpelketten();

        boolean gotKette = false;
        int minQualität = anzahlWimpel;
        List<List<Farbe>> ketten;

        do {
            minQualität--;
            ketten = wimpelketten.generiereWimpelketten(farben, new ArrayList<>(), minQualität);

            if(ketten.size() > 0)
            {
                gotKette = true;
            }
        }
        while (!gotKette);

        ketten.sort(new Comparator<List<Farbe>>() {
            @Override
            public int compare(List<Farbe> o1, List<Farbe> o2) {
                Kettenqualität qual1 = Kettenqualität.berechneQualität(o1);
                Kettenqualität qual2 = Kettenqualität.berechneQualität(o2);

                return -qual1.compareTo(qual2);
            }
        });

        List<List<Farbe>> maxKetten = new ArrayList<>();
        int maxHäufigkeit = anzahlWimpel;

        for (List<Farbe> kette : ketten)
        {
            Kettenqualität qual = Kettenqualität.berechneQualität(kette);

            if(qual.getHäufigkeit() < maxHäufigkeit || maxHäufigkeit == 0)
            {
                    maxHäufigkeit = qual.getHäufigkeit();
                    maxKetten.clear();
            }
            if(qual.getHäufigkeit() == maxHäufigkeit)
            {
                maxKetten.add(kette);
            }
        }
        Kettenqualität maxqual = Kettenqualität.berechneQualität(maxKetten.get(0));
        EinAusgabe.textAusgabe("Die Maximale Qualität ist: (" + maxqual.getAbstand() + "|" + maxqual.getHäufigkeit() + ")");
        EinAusgabe.textAusgabe("Die Anzahl der maximalen Wimpelketten ist:" + maxKetten.size());
        EinAusgabe.textAusgabe("Die Maximalen Wimpelketten sind:");
        for (List<Farbe> kette: maxKetten)
        {
            StringBuilder ketteString = new StringBuilder("(");
            for (Farbe wimp : kette)
            {
                ketteString.append(wimp.GetShortName()).append(",");
            }
            ketteString.append(")");
            EinAusgabe.textAusgabe(ketteString.toString());
        }
    }
}
