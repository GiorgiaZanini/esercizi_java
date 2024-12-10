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
        for (char stringa : string) {   //non si può fare il for each sulle stringhe
            if (stringa == 1) {
                counter1++;
            }
        }
        */

        return string + (counter1 % 2); //se dispari il resto è 1, senno è 0
                                        //viene concatenato alla stringa del numero binario già esistente
    }
}
