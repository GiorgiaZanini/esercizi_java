package it.univr.quindici;

public class FattoriaDiTessereNumeriche extends FattoriaDiTessere<Integer> {

    private final int max;

    public FattoriaDiTessereNumeriche (int max) {
        this.max = max;
    }

    @Override
    public Tessera<Integer> get() {
        return new Tessera<Integer>(random.nextInt(max - 1) + 1);
    }
}
