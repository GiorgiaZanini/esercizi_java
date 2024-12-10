public class BinaryNumber extends AbstractNumber{
    public BinaryNumber(int value) {
        super(value);
    }

    @Override
    protected int getBase() {
        return 2;
    }

    @Override
    protected char getCharForDigit(int digit) {
        return string.charAt(digit);
    }

    private static final String string = "01";
}
