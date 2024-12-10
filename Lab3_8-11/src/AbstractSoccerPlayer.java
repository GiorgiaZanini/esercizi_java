//classe astratta → mette insieme la classe concreta e l’interfaccia,
                    //comprende quindi metodi già implementati, e metodi non implementati (da implementare nelle sottoclassi), contrassegnati dalla parola "abstract"
public abstract class AbstractSoccerPlayer implements SoccerPlayer {    //implements → implementa l’interfaccia
    private String name;

    protected AbstractSoccerPlayer(String name) {
        this.name = name;
    }

    @Override
    public final String toString() {
        return name;
    }

    public abstract boolean canUseHands();  //metodo da implementare
}