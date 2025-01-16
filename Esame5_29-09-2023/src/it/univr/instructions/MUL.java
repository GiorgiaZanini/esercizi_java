package it.univr.instructions;

import java.util.List;

public class MUL implements Instruction {

    public MUL() {}

    @Override
    public void execute(List<Integer> stack) throws IllegalProgramException {
        int size = stack.size();
        if (size < 2)
            throw new IllegalProgramException("Errore: Operandi insufficienti per un’operazione binaria");
        // se l'operazione non va a buon fine, rimetto i numeri nello stack (in questo caso non li rimuovo nemmeno dalla lista)

        // pop1 -> i2
        // pop2 -> i1

        int result = stack.get(size - 2) * stack.get(size - 1);
        new POP().execute(stack);
        new POP().execute(stack);
        new PUSH(result).execute(stack);
    }

    @Override
    public String toString() {
        return "mul";
    }
}
