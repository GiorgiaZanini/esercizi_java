package it.univr.figures;

import it.univr.MainFigure;

public class Circle extends Figure{ //extends → Rectangle è figlia di Figure
    private double raggio;

    public Circle(Color colore, double raggio) {
        super(colore);  //richiama il costruttore della superclasse e assegna il valore alla rispettiva proprietà, già presente nella superclasse (quindi non si deve ri-istanziare nella sottoclasse).
                        //va richiamato nella prima riga di codice del costruttore, se non si scrive, è implicito super();

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
