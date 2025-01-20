package it.univr.doodle;

public class WeightedDoodle extends Doodle {

    @Override
    protected int priority(Person person) {
        return person.priority();
    }
}
