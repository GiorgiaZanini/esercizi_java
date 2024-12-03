public class HexNumber extends AbstractNumber{
    public HexNumber(int value) {
        super(value);
    }

    @Override
    protected int getBase() {
        return 16;
    }

    @Override
    protected char getCharForDigit(int digit) {
        return array[digit];
    }

    private static final char[] array = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
}
