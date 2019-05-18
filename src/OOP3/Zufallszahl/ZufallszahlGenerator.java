package OOP3.Zufallszahl;

/**
 * @author Erik
 * Grundklasse für Zuffals Ganzzahl Generatoren
 */
public abstract class ZufallszahlGenerator implements IZufallszahlGenerator
{
    /**
     * @author Erik
     *
     * Generiert eine Zufalls Ganzzahl zwischen Min und Max
     * Min muss kleiner sein als Max
     *
     * @param min Minimalwert der generierten Ganzzahl
     * @param max Maximalwert der generierten Ganzzahl
     * @return Zufalls Ganzzahl zwischen Min und Max
     */
    public int GeneriereZufallszahl(int min, int max)
    {
        if(min >= max){
            throw new IllegalArgumentException("Max has to be greater than Min!");
        }

        double randomValue = generateRandomNormalizedValue();

        return (int)(min + (max - min) * randomValue);
    }

    /**
     * @author Erik
     *
     * Abstrakte Methode zur generierung von Zufalls Fließkommawerten
     *
     * @return Double Fließkommazahl zwischen 0.0 und 1.0
     */
    protected abstract double generateRandomNormalizedValue();
}
