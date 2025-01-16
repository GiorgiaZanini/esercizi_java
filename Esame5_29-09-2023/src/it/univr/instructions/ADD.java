package it.univr.instructions;

import java.util.List;

public class ADD implements Instruction{

    public ADD() {}

    @Override
    public void execute(List<Integer> stack) throws IllegalProgramException {
        int size = stack.size();
        if (size < 2)
            throw new IllegalProgramException("numero di elementi presenti nello stack insufficente per l'operazione add");
        // se l'operazione non va a buon fine, rimetto i numeri nello stack (in questo caso non li rimuovo nemmeno dalla lista)

        /*
        int i2 = stack.get(size - 1);
        new POP();
        size --;
        int i1 = stack.get(size - 1);
        new POP();
        size --;

        int result = i1 + i2;


        new PUSH(result);
         */
        //new PUSH(stack.get(size - 2) + stack.get(size - 1));  // no prima di caricare il risultato devo togliere i1 e i2

        // pop1 -> i2
        // pop2 -> i1

        int result = stack.get(size - 2) + stack.get(size - 1);
        new POP().execute(stack);
        new POP().execute(stack);
        new PUSH(result).execute(stack);
    }

    @Override
    public String toString() {
        return "add";
    }
}
