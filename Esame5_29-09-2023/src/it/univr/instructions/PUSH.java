package it.univr.instructions;

import java.util.List;

public class PUSH implements Instruction {
    private Integer c;

    public PUSH(Integer c) {
        this.c = c;
    }

    @Override
    public void execute(List<Integer> stack) throws IllegalProgramException {
        int size = stack.size();
        // in caso l'errore sarebbe throw new StackOverflowError(); se si supera il nuro di elementi massimo (non consiuto)
        // ipotizzo che il valore massimo di inserimento è il numero massimo di int
        if (size >= Integer.MAX_VALUE)
            //throw new StackOverflowError("spazio nello stack finito");
            throw new IllegalProgramException("StackOverflowError: spazio nello stack finito");
        // se l'operazione non va a buon fine, non aggiungo il numero allo stack

        stack.add(c); // aggiunge l'elemento in cima allo stack
    }

    @Override
    public String toString() {
        return "push(" + c + ")";
    }
}
