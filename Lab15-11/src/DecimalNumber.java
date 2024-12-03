public class DecimalNumber extends AbstractNumber{
    public DecimalNumber(int value) {
        super(value);
    }

    @Override
    protected int getBase() {
        return 10;
    }

    @Override
    protected char getCharForDigit(int digit) {
        return string.charAt(digit);
    }

    private static final String string = "0123456789";
}
