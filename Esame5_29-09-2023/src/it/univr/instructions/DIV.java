package it.univr.instructions;

import java.util.List;

public class DIV implements Instruction {

    public DIV() {}

    @Override
    public void execute(List<Integer> stack) throws IllegalProgramException {
        int size = stack.size();
        if (size < 2)
            throw new IllegalProgramException("numero di elementi presenti nello stack insufficente per l'operazione add");
        // se l'operazione non va a buon fine, rimetto i numeri nello stack (in questo caso non li rimuovo nemmeno dalla lista)

        // pop1 -> i2
        // pop2 -> i1

        int i2 = stack.get(size - 1);
        if (i2 == 0)
            throw new IllegalProgramException("i2 = 0");

        int result = stack.get(size - 2) - i2;
        new POP().execute(stack);
        new POP().execute(stack);
        new PUSH(result).execute(stack);
    }

    @Override
    public String toString() {
        return "div";
    }
}
