package OOP3.Zufallszahl;

import java.util.Random;

/**
 * @author Erik
 *
 * Generiert Zufallswerte mittels Random
 */
public class RZufallszahlGenerator extends ZufallszahlGenerator
{
    private Random rng;

    /**
     * @author Erik
     *
     * Erstellt einen Neuen ZufallszahlGenerator mit der Zeit als Zufälligen Seed
     */
    public RZufallszahlGenerator()
    {
        rng = new Random(System.currentTimeMillis());
    }

    /**
     * @author Erik
     *
     * Erstellt einen Neuen ZufallszahlGenerator mit dem gegebenen Seed
     *
     * @param seed Der Zufällige Seed
     */
    public RZufallszahlGenerator(long seed)
    {
        rng = new Random(seed);
    }

    /**
     * @author Erik
     *
     * Generiert einen Zufalls Fließkommawert zwischen 0.0 (inclusiv) und 1.0 (exclusiv)
     *
     * @return Zufalls Fließkommawert zwischen 0.0 (inclusiv) und 1.0 (exclusiv)
     */
    @Override
    protected double generateRandomNormalizedValue() {
        return rng.nextDouble();
    }
}
