public class Base58Number extends AbstractNumber{
    public Base58Number(int value) {
        super(value);
    }

    @Override
    protected int getBase() {
        return 58;
    }

    @Override
    protected char getCharForDigit(int digit) {
        return string.charAt(digit);
    }

    private static final String string = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz";
}
