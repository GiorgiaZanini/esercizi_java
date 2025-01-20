package it.univr.doodle;

public class CEO extends Person{

    protected CEO(String name) {
        super(name);
    }

    @Override
    public int priority() {
        return 4;
    }
}
