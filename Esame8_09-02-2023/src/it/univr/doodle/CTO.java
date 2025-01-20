package it.univr.doodle;

public class CTO extends Person{

    protected CTO(String name) {
        super(name);
    }

    @Override
    public int priority() {
        return 3;
    }
}
