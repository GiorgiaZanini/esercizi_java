public class MainConstant_lambda {
    public static void main(String[] args) throws InterruptedException {
        Board board = new Board(40, 20, 100);

        /*
        board.play(new NextAliveProcessor() {   // classe anonima
            @Override
            public boolean isAliveNextAt(int x, int y) {
                return board.isAliveAt(x,y);
            }
        });
        */

        board.play((x, y) -> board.isAliveAt(x,y));
        //board.play(board::isAliveAt);
    }
}
