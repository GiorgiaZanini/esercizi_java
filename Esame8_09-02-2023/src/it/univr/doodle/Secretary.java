package it.univr.doodle;

public class Secretary extends Person {

    protected Secretary(String name) {
        super(name);
    }

    @Override
    public int priority() {
        return 1;
    }
}
