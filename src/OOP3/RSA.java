package OOP3;

import java.math.BigInteger;

public class RSA {
    private static Schlüsselgenerator schlüsselgenerator;
    private static SignaturPrüfmodul signaturmodul;

    public RSA(){
        this.schlüsselgenerator = new Schlüsselgenerator();
        this.signaturmodul = new SignaturPrüfmodul();
    }

    public static void start(String modus){
        //StartEingaben um NullPointerException vorzugbeugen
        Schlüssel pubkey = new Schlüssel(new BigInteger("7"), new BigInteger("187"));
        Schlüssel privkey = new Schlüssel(new BigInteger("23"), new BigInteger("187"));
        Schlüsselpaar keys = new Schlüsselpaar(privkey, pubkey) ;
        BigInteger signatur = BigInteger.ZERO;
        String dateipfad = "";
        System.out.println("Der gewählte Modus ist: " + modus );
        //TODO Eingabe von Werten
        switch (modus) {
            case "schlüssel":
                keys = schlüsselgenerator.generiereSchlüssel();
                pubkey = keys.getPublic();
                privkey = keys.getPrivate();
                System.out.println("Öffentlicher Schlüssel : " + pubkey.getGzahl() + ", " + pubkey.getGzahl());
                System.out.println("Privater Schlüssel : " + privkey.getGzahl() + ", " + privkey.getGzahl());
                break;
            case "signieren":
                privkey = keys.getPrivate();
                //TODO DateiEingabe + prüfe ObFile
                signatur = signaturmodul.generiereSignatur(dateipfad, privkey);
                System.out.println("Die Signatur der Datei " + dateipfad + " lautet: " + signatur);
                break;
            case "prüfen":
                pubkey = keys.getPublic();
                boolean prüf = signaturmodul.prüfeSignatur(dateipfad, pubkey, signatur);
                if (prüf) {
                    System.out.println("Die Signatur ist korrekt.");
                } else {
                    System.out.println("Die Signatur ist nicht korrekt.");
                }
                break;
            default:
                System.out.println("Die zu wählenden Modi sind: schlüssel, signieren, prüfen.");
                keys = schlüsselgenerator.generiereSchlüssel();
                pubkey = keys.getPublic();
                privkey = keys.getPrivate();
                System.out.println("Öffentlicher Schlüssel : " + pubkey.getGzahl() + ", " + pubkey.getGzahl());
                System.out.println("Privater Schlüssel : " + privkey.getGzahl() + ", " + privkey.getGzahl());
                //TODO datei
                signatur = signaturmodul.generiereSignatur(dateipfad, privkey);
                System.out.println("Die Signatur der Datei " + dateipfad + " lautet: " + signatur);
                boolean prüf2 = signaturmodul.prüfeSignatur(dateipfad, pubkey, signatur);
                if (prüf2) {
                    System.out.println("Die Signatur ist korrekt.");
                } else {
                    System.out.println("Die Signatur ist nicht korrekt.");
                }
                 break;
        }
        System.out.println("Programm beendet.");
    }
}
