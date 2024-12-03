public class Main {
    public static void main(String[] args) {
        String card1 = (new Card()).toString();
        System.out.println(card1);
        String card2;
        do {
            card2 = new Card().toString();
            System.out.println(card2);
        } while (!card1.equals(card2));

        System.out.println("-----------------------------------------");

        main2();
    }

    public static void main2() {
        Card card1 = new Card(12);
        System.out.println(card1);
        System.out.println(card1.toString());
        Card card2 = null;
        do {
            card2 = new Card(12);
            System.out.println(card2);
        } while (!card1.equals(card2));

        System.out.println("-----------------------------------------");

        main3();
    }

    public static void main3() {
        Card2 card1 = new Card2(Value.DUE);
        System.out.println(card1);
        Card2 card2;
        do {
            card2 = new Card2(Value.DUE);
            System.out.println(card2);
        } while (!card1.equals(card2));
    }
}