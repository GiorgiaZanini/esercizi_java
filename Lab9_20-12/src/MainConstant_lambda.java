public class MainConstant_lambda {
    private static Board board = new Board(40, 20, 100);

    public static void main(String[] args) throws InterruptedException {
        board.play(new ProcessorEquals());
    }

    private static class ProcessorEquals implements NextAliveProcessor {
        @Override
        public boolean isAliveNextAt(int x, int y) {
            return board.isAliveAt(x,y);
        }
    }
}
