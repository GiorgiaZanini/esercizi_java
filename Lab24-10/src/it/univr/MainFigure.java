package it.univr;

import it.univr.figures.*;

public class MainFigure {
    public static void main(String[] args) {
        Figure rettangolo = new Rectangle(Color.BLU, 10, 11);
        Figure quadrato = new Square(Color.BLU, 10);
        print(rettangolo);



        Figure cerchio = new Circle(Color.GIALLO, 5);
        print(cerchio);

        // System.out.println();   // In tale classe è possibile chiamare il metodo getColor() sulle figure?



        
    }

    public static void print(Figure figure) {
        if (figure instanceof Rectangle)
            return;

        System.out.println(figure);
    }
}
