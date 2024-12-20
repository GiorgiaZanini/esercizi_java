public class MainGameOfLife_lambda {
    private static Board board = new Board(40, 20, 100);

    public static void main(String[] args) throws InterruptedException {
        board.play(new ProcessorRules());
    }

    public static class ProcessorRules implements NextAliveProcessor {
        @Override
        public boolean isAliveNextAt(int x, int y) {
            int counterAlive = 0;

            for (int i = (x-1); i <= (x+1); i++) {
                for (int j = (y-1); j <= (y+1); j++) {
                    if (i >= 0 && j >= 0 && i < board.getWidth() && j < board.getHeight() && (i!=x || j!=y) && board.isAliveAt(i,j))
                        counterAlive++;
                }
            }

            if (board.isAliveAt(x,y))
                return (counterAlive >= 2 && counterAlive <=3); // rimane viva se intorno ha da 2 a 3 celle vive
            else
                return counterAlive == 3;   // diventa viva se intorno ha esattamente 3 celle vive
        }
    }
}
