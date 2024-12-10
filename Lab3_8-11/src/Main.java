import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] difensori = {"Alex Sandro", "Rugani", "Chiellini", "Dani Alves"};
        String[] centrocampisti = {"Fabinho", "Iniesta", "Pjanic"};
        String[] attaccanti = {"Dybala", "Higuain", "Bernardeschi"};
        String[] portiere = {"Szczesny"};
        String[][] giocatori = {difensori, centrocampisti, attaccanti, portiere};

        SoccerPlayer[] players = new SoccerPlayer[12];  //array di SoccerPlayer con dimensione definita
                                                        //12 → test per vedere se fallisce (dimensione valida → 11)
        List<SoccerPlayer> playerList = new LinkedList<SoccerPlayer>(); //LinkedList
        test(playerList);   //LinkedList

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

        players[index] = (new GoalKeeper("Tizio")); //test per vedere se fallisce


        //try – catch – finally
        try {   //prova il pezzo di codice all’interno,
                // se durante l’esecuzione vengono generate delle eccezioni all’interno del try,
                // e sono catturabili da uno dei catch, esegui il catch corrispondente all’eccezione (errore)
            System.out.println(new Formation433(players).isValid());
            System.out.println(new Formation433(players));
        } catch (ExceptionInInitializerError e) {   //esegue in catch sse l’eccezione (errore) generata è del tipo che riceve come parametro o sua “figlia”
            System.out.println("Errore nella creazione della formazione.");
            //System.exit(-1);  //–1 → codice di uscita con errore
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            //System.exit(-1);
        } finally { //a prescindere esegui, se non viene terminata prima l’esecuzione (System.exit, errori non catturati, return, ...)
            System.out.println("Try catch finito.");
            System.exit(-1);
        }



    }

    public static void test (List<SoccerPlayer> playerList) {}  //LinkedList
                                                                //riesce a entrare perché la classe LinkedList è figlia dell’interfaccia List
                                                                //e il metodo è static come il main
}
