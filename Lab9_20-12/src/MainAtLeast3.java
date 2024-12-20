public class MainAtLeast3 {
    private static Board board = new Board(40, 20, 100);

    public static void main(String[] args) throws InterruptedException {
        board.play(new Processor3());
    }

    private static class Processor3 implements NextAliveProcessor {
        @Override
        public boolean isAliveNextAt(int x, int y) {
            int counterAlive = 0;

            for (int i = (x-1); i <= (x+1); i++) {
                for (int j = (y-1); j <= (y+1); j++) {
                    if (i >= 0 && j >= 0 && i < board.getWidth() && j < board.getHeight() && board.isAliveAt(i,j))
                        counterAlive++;
                }
            }
            
            return counterAlive >= 3;
        }
    }
}
