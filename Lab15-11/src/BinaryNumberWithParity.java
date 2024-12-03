public class BinaryNumberWithParity extends BinaryNumber{
    public BinaryNumberWithParity(int value) {
        super(value);
    }

    @Override
    public String toString(){
        String string = super.toString();
        int counter1 = 0;

        for (int i = 0; i < string.length(); i++) {
            //char c = string.charAt(i);
            if (string.charAt(i) == '1') {
                counter1++;
            }
        }
        /*
        for (char stringa : string) {
            if (stringa == 1) {
                counter1++;
            }
        }
        */

        return string + (counter1 % 2);
    }
}
