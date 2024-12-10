package it.univr;

import it.univr.figures.*;

public class MainFigure {
    public static void main(String[] args) {
        Figure rettangolo = new Rectangle(Color.BLU, 10, 11);
        Figure quadrato = new Square(Color.BLU, 10);
        print(rettangolo);



        Figure cerchio = new Circle(Color.GIALLO, 5);
        print(cerchio);

        // System.out.println();   /in questa classe non è possibile chiamare il metodo getColor() sulle figure, perché il metodo è protected e la classe main non si trova nella stessa cartella del file che contiene il metodo getColor() da richiamare



        
    }

    public static void print(Figure figure) {   //l’oggetto più generico può contenere gli oggetti più specifici, quindi posso passare Rectangle, che è una sottoclasse di Figure,
                                            //ma viene poi utilizzata sotto il tipo di Figure,
        if (figure instanceof Rectangle)    //per averla sotto il tipo di Rectangle, dopo aver controllato che effettivamente è un’istanza di Rectangle,
                                            // si può castare, ovvero creare una nuova variabile, definendola col tipo più specifico,
                                            // oppure si può dire di considerarla del tipo più specifico, a si deve fare ogni volta che si utilizza

            return;

        System.out.println(figure);
    }
}
