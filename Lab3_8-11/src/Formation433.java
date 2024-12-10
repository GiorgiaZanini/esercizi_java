import java.util.LinkedList;

public class Formation433 extends Formation{

    public Formation433(SoccerPlayer[] players) {
        super(players);
    }

    // ritorna true se e solo se la formazione è fatta da 11 giocatori,
    // di cui 4 difensori, 3 centrocampisti e 3 attaccanti, e un portiere
    protected boolean isValid() {
        if (!super.isValid()) { return false; }

        int difensori = 0;
        int centrocampisti = 0;
        int attaccanti = 0;

        /*
        for (SoccerPlayer player : getPlayers()) {
            if (player instanceof Defence) {
                difensori++;
                if (difensori > 4) { return false; }
            } else if (player instanceof Midfield) {
                centrocampisti++;
                if (centrocampisti > 3) { return false; }
            } else if (player instanceof Forward) {
                attaccanti++;
                if (attaccanti > 3) { return false; }
            }
        }

        return true;
         */

        for (SoccerPlayer player : getPlayers()) {
            if (player instanceof Defence) {
                difensori++;
            } else if (player instanceof Midfield) {
                centrocampisti++;
            } else if (player instanceof Forward) {
                attaccanti++;
            }
        }

        return difensori == 4 && centrocampisti == 3 && attaccanti == 3;
    }

}
