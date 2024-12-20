import java.util.Random;

public class Board {
    private final int width;
    private final int height;
    private boolean[][] current;
    //        ...

    /**
     * Inizializza la tavola alle dimensioni indicate, in modo che
     * contenga esattamente howManyAlive cellule vive, posizionate
     * casualmente nella tavola.
     *
     * @param width la larghezza della tavola
     * @param height l'altezza della tavola
     * @param howManyAlive il numero di cellule vive della tavola
     * @throws IllegalArgumentException se width o height sono negative,
     *         oppure se howManyAlive è negativo o maggiore del numero di cellule della tavola
     */
    public Board(int width, int height, int howManyAlive) {
        if (howManyAlive < 0 || howManyAlive > width*height)
            throw new IllegalArgumentException("il numero di cellule vive non è nel range previsto");

        if (width < 0)
            throw new IllegalArgumentException("width è negativo");
        this.width = width;

        if (height < 0)
            throw new IllegalArgumentException("height è negativo");
        this.height = height;


        this.current = new boolean[width][height];

        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++)
                current[i][j] = false;

        Random random = new Random();
        int randomWidth;
        int randomHeight;
        for (int i = 0; i < howManyAlive; i++) {
            do {
                randomWidth = random.nextInt(width);
                randomHeight = random.nextInt(height);
            } while (current[randomWidth][randomHeight]);
            current[randomWidth][randomHeight] = true;
        }
        /*
        current[0][0] = true;
        current[2][0] = true;
        current[3][0] = true;
        current[2][1] = true;
        current[4][1] = true;
        current[0][2] = true;
        current[1][2] = true;
        current[3][3] = true;
        current[3][4] = true;
        current[4][3] = true;
        */
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    /**
     * Determina se la cellula (x,y) è viva o morta.
     */
    public boolean isAliveAt(int x, int y) {
        return current[x][y];
    }

    public String toString() {
        String result = "";
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++)
                result += isAliveAt(x, y) ? '*' : ' ';
                //result += isAliveAt(x, y) ? "|*" : "| ";
            result += "\n";
            //result += "|\n";
        }
        return result;
    }

    /**
     * Stampa ripetutamente questa tavola, chiamando ogni volta
     * next() per farla passare alla generazione successiva. L'unico modo
     * per terminare questo metodo è con CTRL+C. In Eclipse, tale segnale
     * viene inviato cliccando sul pulsante quadrato rosso della console.
     *
     * @param processor la specifica di come si passa da una generazione alla successiva
     */
    public void play(NextAliveProcessor processor) throws InterruptedException {
        while (true) {
            System.out.println(this);
            System.out.println("----------------------------------------");
            //System.out.println("---------------------------------------------------------------------------------");
            next(processor);
            Thread.sleep(500); // aspetta mezzo secondo
        }
    }

    /**
     * Modifica la tavola in modo che la cellula (x,y) sarà viva
     * se e solo se processor.isAliveNextAt(x,y) è vero.
     */
    private void next(NextAliveProcessor processor) {
        //Board b = new Board(width, height, 0);
        //b.current[0][0] = true;
        boolean[][] tmpBoard = new boolean[width][height];
        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++)
                tmpBoard[i][j] = false;

        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++)
                if (processor.isAliveNextAt(i,j))
                    tmpBoard[i][j] = true;

        current = tmpBoard;
    }
}
