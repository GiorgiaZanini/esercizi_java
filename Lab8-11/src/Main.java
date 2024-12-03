import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] difensori = {"Alex Sandro", "Rugani", "Chiellini", "Dani Alves"};
        String[] centrocampisti = {"Fabinho", "Iniesta", "Pjanic"};
        String[] attaccanti = {"Dybala", "Higuain", "Bernardeschi"};
        String[] portiere = {"Szczesny"};
        String[][] giocatori = {difensori, centrocampisti, attaccanti, portiere};

        SoccerPlayer[] players = new SoccerPlayer[12];
        List<SoccerPlayer> playerList = new LinkedList<SoccerPlayer>();
        test(playerList);

        int index = 0;
        for (int i = 0; i < giocatori.length; i++) {
            for (int j = 0; j < giocatori[i].length; j++) {
                switch (i) {
                    case 0:
                        players[index] = (new Defence (difensori[j]));
                        index++;
                        break;
                    case 1:
                        players[index] = (new Midfield (centrocampisti[j]));
                        index++;
                        break;
                    case 2:
                        players[index] = (new Forward (attaccanti[j]));
                        index++;
                        break;
                    case 3:
                        players[index] = (new GoalKeeper (portiere[j]));
                        index++;
                        break;
                }
            }
        }

        players[index] = (new GoalKeeper("Tizio"));


        try {
            System.out.println(new Formation433(players).isValid());
            System.out.println(new Formation433(players));
        } catch (ExceptionInInitializerError e) {
            System.out.println("Errore nella creazione della formazione.");
            //System.exit(-1);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            //System.exit(-1);
        } finally {
            System.out.println("Try catch finito.");
            System.exit(-1);
        }



    }

    public static void test (List<SoccerPlayer> playerList) {

    }
}
