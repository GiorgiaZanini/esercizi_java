public class MainAtLeast3 {
    prvate static Board board = new Board(40, 20, 100);

    public static void main(String[] args) {
        board.play(new Processor3());
    }

    private static class Processor3 implements NextAliveProcessor {
        @Override
        public boolean isAliveNextAt(int x, int y) {
            int counterAlive = 0;

            for (int i = (x-1); i <= (x+1); i++) {
                for (int j = (y-1); j <= (y+1); j++) {
                    if (h >= 0 && k >= 0 && h < board.getWidth() && k < board.getHeight() && i!=0 && j!=0 && board.isAliveAt(i,j))
                                counterAlive++;
                }
            }

            return counterAlive >= 3;
        }
    }
}
