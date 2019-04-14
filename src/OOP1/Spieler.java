package OOP1;

@SuppressWarnings("unused")
class Spieler {

    private String name;

    /**author Erik
     * Erstellt einen neuen Spieler
     */
    public Spieler(){

    }

    /**author Erik
     * Gibt den Namen des Spielers aus
     *
     * @return Der Name des Spielers
     */
    public String getName(){
        return name;
    }

    /**author Erik
     * Setzt den Namen des Spielers
     *
     * @param name Der neue Name Spielers
     */
    public void setName(String name){
        this.name = name;
    }
}
