package OOP4;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

public class Wimpelketten
{
    public List<List<EFarben>> generiereWimpelketten(Map<EFarben,Integer> farben, List<EFarben> kette, int kleinstMinAbst)
    {
        List<List<EFarben>> ketten = new ArrayList<>();

        int wimpel = 0;
        for (Integer anzahl : farben.values())
        {
            wimpel += anzahl;
        }

        if(wimpel == 0)
        {
            ketten.add(kette);
            return ketten;
        }

        for (Map.Entry<EFarben,Integer> farbe : farben.entrySet())
        {
            if(farbe.getValue() <= 0)
            {
                continue;
            }

            List<EFarben> addKette = new ArrayList<>(kette);

            addKette.add(farbe.getKey());

            Kettenqualität kettenqualität = Kettenqualität.berechneQualität(addKette);

            if(kettenqualität.getHäufigkeit() != 0 && kettenqualität.getAbstand() < kleinstMinAbst)
            {
                continue;
            }

            Map<EFarben,Integer> subFarben = new HashMap<>(farben);
            subFarben.replace(farbe.getKey(), farben.get(farbe.getKey()) - 1);

            ketten.addAll(generiereWimpelketten(subFarben,addKette, kleinstMinAbst));
        }

        return ketten;
    }
}
