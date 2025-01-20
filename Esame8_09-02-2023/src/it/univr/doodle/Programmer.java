package it.univr.doodle;

public class Programmer extends Person{

    protected Programmer(String name) {
        super(name);
    }

    @Override
    public int priority() {
        return 2;
    }
}
