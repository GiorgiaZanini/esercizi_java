public class MainAtLeast3 {
    public static void main(String[] args) {
        Board board = new Board(40, 20, 100);
        board.play();
    }

    private static class Processor3 implements NextAliveProcessor {
        @Override
        public boolean isAliveNextAt(int x, int y) {
            int counterAlive = 0;
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {

                    counterAlive = 0;
                    for (int h = (i-1); h <= (i+1); h++) {
                        for (int k = (j-1); k <= (j+1); k++) {

                            if (h >= 0 && k >= 0 && h < x && k < y && thisBoard[h][k] == true)
                                counterAlive++;

                        }
                    }
                    if (counterAlive <= 3)
                        nextBoard[i][j] = true;
                    else nextBoard[i][j] = false;

                }
            }
        }
    }
}
