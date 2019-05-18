package OOP3.Prüfsumme;

/**
 * @author Erik
 *
 * Generiert Prüfsummen mittels Quersumme
 */
public class QSPrüfsummengenerator extends Prüfsummengenerator
{
    /**
     * @author Erik
     *
     * Generiert eine Prüfsumme aus dem gegebenen Text
     * @param text Der Text
     * @return Die Prüfsumme
     */
    @Override
    protected long generateTextChecksum(String text) {
        long sum = 0;

        for(char c : text.toCharArray())
        {
            sum += (int)c;
        }

        long quersumme = 0;

        while(sum > 9)
        {
            quersumme += sum % 10;
            sum /= 10;
        }
        quersumme += sum;

        return quersumme;
    }
}
