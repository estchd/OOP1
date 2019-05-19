package OOP3;

import java.math.BigInteger;

/**
 * @author Josi
 */
public class Schlüssel {
    private BigInteger zahl;

    public BigInteger getGzahl() {
        return gzahl;
    }

    private BigInteger gzahl;

    public BigInteger getZahl() {
        return zahl;
    }

    public Schlüssel(BigInteger _zahl, BigInteger _generatorzahl){
        this.zahl = _zahl;
        this.gzahl = _generatorzahl;
    }

}
