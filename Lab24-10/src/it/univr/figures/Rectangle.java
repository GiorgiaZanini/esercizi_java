package it.univr.figures;

public class Rectangle extends Figure{
    private double base;
    private double altezza;

    public Rectangle(Color colore, double base, double altezza) {
        super(colore);
        this.base = base;
        this.altezza = altezza;
    }

    @Override
    public double perimeter() {
        return (base + altezza)*2;
    }

    @Override
    public double area() {
        return base*altezza;
    }

    @Override
    public String toString() {
        return "Rectengle of " + super.toString();
    }
}
