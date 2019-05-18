package OOP3.Prüfsumme;

/**
 * @author Erik
 *
 * Generiert Prüfsummen mittels Fletchers Checksum
 */
public class FCPrüfsummengenerator extends Prüfsummengenerator
{
    /**
     * @author Erik
     *
     * Generiert eine Prüfsume aus dem gegebenen Text
     *
     * @param text Der Text
     * @return Die Prüfsumme
     */
    @Override
    protected long generateTextChecksum(String text) {
        int sum1 = 0;
        int sum2 = 0;

        char[] textarr = text.toCharArray();

        for(char c : textarr)
        {
            sum1 = (sum1 + c) % 255;
            sum2 = (sum2 + sum1) % 255;
        }
        String checksumStr = String.valueOf(sum1) + String.valueOf(sum2);

        return Long.parseLong(checksumStr);
    }
}
