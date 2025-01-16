package it.univr.instructions;

import java.util.List;

public class REPEAT implements Instruction {
    private final Integer c;  // != da c delle istruzioni (non passare come parametro), serve per sapere quante volte eseguire l'operazione passata
    private final Instruction ins;

    public REPEAT(Integer c, Instruction ins) {
        this.c = c;
        this.ins = ins;
        //System.out.println(this.ins.toString());
    }

    @Override
    public void execute(List<Integer> stack) throws IllegalProgramException {
        for (int i = 0; i < c; i++)
            ins.execute(stack);
    }

    @Override
    public String toString() {
        return "repeat";
    }
}
