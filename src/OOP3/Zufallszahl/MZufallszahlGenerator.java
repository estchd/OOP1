package OOP3.Zufallszahl;

/**
 * @author Erik
 * Generiert Zufallszahlen mittels Math.random
 */
public class MZufallszahlGenerator extends ZufallszahlGenerator
{
    /**
     * @author Erik
     *
     * Generiert Zufalls Flieskommawerte mittels Math.random
     *
     * @return Zuffals Flieskommawert zwischen 0.0 (inclusiv) und 1.0 (exclusiv)
     */
    @Override
    protected double generateRandomNormalizedValue()
    {
        return Math.random();
    }
}
