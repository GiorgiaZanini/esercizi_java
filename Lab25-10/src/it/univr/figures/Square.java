package it.univr.figures;

public class Square extends Rectangle{
    private double lato;

    public Square(Color colore, double lato) {
        super(colore, lato, lato);
    }

    @Override
    public String toString() {
        return "Square, a " + super.toString();
    }
}
