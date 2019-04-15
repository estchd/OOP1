package OOP1;

class Main {
    /**@author Erik
     * Main Funktion des Nimm-Spiels
     *
     * @param args Consolen Argumente
     */
    public static void main(String[] args){
        Spiel spiel;
        boolean weiterspielen;

        do{
            int spieleranzahl = EinAusgabe.intBereichAbfrage("Wie viele Spieler spielen?",2,5);
            spiel = new Spiel(spieleranzahl);
            spiel.spielStart();

            weiterspielen = EinAusgabe.jaNeinFrage("Weiterspielen?");
        }while(weiterspielen);
    }
}
