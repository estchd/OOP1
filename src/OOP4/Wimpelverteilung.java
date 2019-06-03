package OOP4;

import OOP1.EinAusgabe;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

public class Wimpelverteilung
{
    public void start()
    {
        Map<EFarben,Integer> wimpel = new HashMap<>();

        EinAusgabe.textAusgabe("Anzahl der Wimpel angeben:");
        for (EFarben farbe : EFarben.values())
        {
            int anzahl = EinAusgabe.positiveIntAbfrage("Wimpel mit der Farbe " + farbe.toString() + ":");
            wimpel.put(farbe, anzahl);
        }

        int anzahlWimpel = 0;

        for (Integer anzahl : wimpel.values()) {
            anzahlWimpel += anzahl;
        }

        if(anzahlWimpel == 0)
        {
            EinAusgabe.textAusgabe("Ohne Wimpel können keine Ketten gebastelt werden :(");
            return;
        }

        Wimpelketten wimpelketten = new Wimpelketten();

        boolean gotKette = false;
        int minQualität = anzahlWimpel;
        List<List<EFarben>> ketten;

        do {
            minQualität--;
            ketten = wimpelketten.generiereWimpelketten(wimpel, new ArrayList<>(), minQualität);

            if(ketten.size() > 0)
            {
                gotKette = true;
            }
        }
        while (!gotKette);

        ketten.sort(new Comparator<List<EFarben>>() {
            @Override
            public int compare(List<EFarben> o1, List<EFarben> o2) {
                Kettenqualität qual1 = Kettenqualität.berechneQualität(o1);
                Kettenqualität qual2 = Kettenqualität.berechneQualität(o2);

                return -qual1.compareTo(qual2);
            }
        });

        List<List<EFarben>> maxKetten = new ArrayList<>();
        int maxHäufigkeit = 0;

        for (List<EFarben> kette : ketten)
        {
            Kettenqualität qual = Kettenqualität.berechneQualität(kette);

            if(qual.getHäufigkeit() > maxHäufigkeit)
            {
                    maxHäufigkeit = qual.getHäufigkeit();
            }
            if(qual.getHäufigkeit() == maxHäufigkeit)
            {
                maxKetten.add(kette);
            }
        }
        Kettenqualität maxqual = Kettenqualität.berechneQualität(maxKetten.get(0));
        EinAusgabe.textAusgabe("Die Maximale Qualität ist: (" + maxqual.getAbstand() + "|" + maxqual.getHäufigkeit() + ")");
        EinAusgabe.textAusgabe("Die Maximalen Wimpelketten sind:");
        for (List<EFarben> kette: maxKetten)
        {
            String ketteString = "(";
            for (EFarben wimp : kette)
            {
                ketteString += wimp.toString() + ",";
            }
            ketteString += ")";
            EinAusgabe.textAusgabe(ketteString);
        }
    }
}
