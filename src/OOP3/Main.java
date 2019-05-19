package OOP3;

public class Main {

    //main string args methode#
    public static void main(String[] args){
        RSA rsa = new RSA();
        rsa.start("");//default: generiert schlüssel, signiert, überprüft datei
        //rsa.start("schlüssel");//schlüssel: generiert schlüssel, Ausgabe auf Konsole.
        //rsa.start("signieren");//signieren: signiert Datei und gibt die Signatur auf Konsole aus.
        //rsa.start("prüfen");//default: überprüft Signatur der Datei.
    }
   }
