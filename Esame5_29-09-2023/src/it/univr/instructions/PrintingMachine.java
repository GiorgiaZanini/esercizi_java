package it.univr.instructions;

import java.util.List;

public class PrintingMachine extends SimpleMachine{

    public PrintingMachine(List<Instruction> program) throws IllegalProgramException {
        super(program);
    }
}
