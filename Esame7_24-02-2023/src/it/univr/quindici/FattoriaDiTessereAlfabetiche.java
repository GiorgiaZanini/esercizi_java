package it.univr.quindici;

public class FattoriaDiTessereAlfabetiche extends FattoriaDiTessere<String> {

    public FattoriaDiTessereAlfabetiche () {
    }

    private final static String lettere = "abcdefghijklmnopqrstuvwxyz";    // 26

    @Override
    public Tessera<String> get() {
        String string = "";

        int max;
        do {
            max = random.nextInt(6);
        } while (max == 0);

        for (int i = 0; i < max; i++)
            string += lettere.charAt(random.nextInt(26));
        return new Tessera<String>(string);
    }
}
