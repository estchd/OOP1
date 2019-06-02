package OOP4;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class Kettenqualität implements Comparable<Kettenqualität>{

    private int abstand;
    private int häufigkeit;

    public static Kettenqualität berechneQualität(List<EFarben> kette)
    {
        throw new NotImplementedException();
    }


    @Override
    public int compareTo(Kettenqualität o)
    {
        return 0;
    }
}
