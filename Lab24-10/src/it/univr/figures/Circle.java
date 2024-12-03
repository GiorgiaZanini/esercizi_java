package it.univr.figures;

import it.univr.MainFigure;

public class Circle extends Figure{
    private double raggio;

    public Circle(Color colore, double raggio) {
        super(colore);
        this.raggio = raggio;
    }

    @Override
    public double perimeter() {
        return 2*Math.PI*raggio;
    }

    @Override
    public double area() {
        return Math.PI*raggio*raggio;
    }

    @Override
    public String toString() {
        return "Circle of " + super.toString();
    }
}
