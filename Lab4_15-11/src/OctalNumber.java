public class OctalNumber extends AbstractNumber {
    public OctalNumber(int value) {
        super(value);
    }

    @Override
    protected int getBase() {
        return 8;
    }

    @Override
    protected char getCharForDigit(int digit) {
        return string.charAt(digit);
    }

    private static final String string = "012345678";
}
