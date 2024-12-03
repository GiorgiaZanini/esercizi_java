package it.univr.figures;

public class Figure {
    private Color colore;

    public Figure (Color colore) {
        this.colore = colore;
    }

    public double perimeter() {
        return 0;
    }

    public double area() {
        return 0;
    }

    @Override
    public String toString() {
        return "area: " + this.area() + ", perimeter: " + this.perimeter() + ", color: " + colore;
    }

    protected Color getColore() {
        return colore;
    }
}
