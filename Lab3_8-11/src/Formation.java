public class Formation {
    private SoccerPlayer[] players;

    public Formation(SoccerPlayer[] players) {
        this.players = players;
        if (!isValid())
            throw new IllegalArgumentException("invalid formation");    //lancia un errore (rosso)
    }

    // ritorna true se e solo se la formazione è fatta da 11 giocatori, di cui esattamente uno è un portiere
    protected boolean isValid() {
        int portieri = 0;

        /*
        for (int i = 0; i < players.length; i++) {
            SoccerPlayer player = players[i];
            if (player.canUseHands()) {
                portieri++;
            }
            if (portieri > 1) {
                return false;
            }
        }
         */

        for (SoccerPlayer player : players) {   //for each → SoccerPlayer player = players[i];
                                                //viene istanziata una variabile, in questo caso di tipo SoccerPlayer
                                                // (bisogna prendere il tipo della proprietà della singola cella dell’array → ad esempio con String si prende char),
                                                // che passa una a una ogni cella dell’array
            if (player.canUseHands()) {
                portieri++;
            }
            if (portieri > 1) {
                return false;
            }
        }

        return players.length == 11 && portieri == 1;
    }

    // ritorna i giocatori di questa formazione
    protected SoccerPlayer[] getPlayers() {
        return this.players;
    }

    @Override
    // ritorna i nomi dei giocatori della formazione, separati da virgola
    public final String toString() {
        String giocatori = "";

        for (int i = 0; i < players.length; i++) {
            if (i == 0) {
                giocatori = players[i].toString();
            } else {
                giocatori = giocatori + ", " + players[i].toString();
            }
        }

        return giocatori;
    }
}
