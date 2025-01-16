package it.univr.instructions;

import java.util.ArrayList;
import java.util.List;

public class PrintingMachine extends SimpleMachine{
    //private final List<Integer> stack = new ArrayList<>();

    public PrintingMachine(List<Instruction> program) throws IllegalProgramException {
        super(program);
    }

    /*
    private int execute(List<Instruction> program) throws IllegalProgramException {
        for (int i = 0; i < program.size(); i++) {
            System.out.print(program.get(i).toString() + ": ");
            execute(program.get(i), stack);
            System.out.println(stack);
        }
        return stack.get(stack.size() - 1);
    }
     */

    @Override
    protected void execute(Instruction ins, List<Integer> stack) throws IllegalProgramException {
        System.out.print(ins + ": ");
        ins.execute(stack);
        System.out.println(stack);
    }
}
