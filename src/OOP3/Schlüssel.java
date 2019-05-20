package OOP3;

import java.math.BigInteger;

/**
 * @author Josi
 */
public class Schlüssel {
    private BigInteger zahl;
    private BigInteger gzahl;

    /**
     * @author Josi
     * Getter von "g" bei privatem and öffentlichem Schlüssel
     * @return gZahl als BigIntegr
     */
    public BigInteger getGzahl() {
        return gzahl;
    }

    /**
     * @author Josi
     * Getter von e oder d, des Schlüssels.
     * @return zahl als BigInteger
     */
    public BigInteger getZahl() {
        return zahl;
    }

    /**
     * @author Josi
     * Konstruktor
     * @param _zahl Zahl "e" oder "d" des Schlüssels (abh. von privat/öffentl.)
     * @param _generatorzahl Zahl "g" als BigInteger
     */
    public Schlüssel(BigInteger _zahl, BigInteger _generatorzahl){
        this.zahl = _zahl;
        this.gzahl = _generatorzahl;
    }

    /**
     * @author Erik
     *
     * Stringrepräsentation der Klasse.
     * @return String mit "(Zahl | gZahl)"
     */
    @Override
    public String toString()
    {
        return "( " + getZahl().toString() + " | " + getGzahl().toString() + " )";
    }

}
