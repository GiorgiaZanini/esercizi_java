public class Forward extends AbstractSoccerPlayer{

    protected Forward(String name) {    //anche il costruttore della superclasse è protected, cambiando visibilità non si va a sovrascrivere, ma se ne crea uno nuovo
        super(name);
    }

    @Override
    public boolean canUseHands() {
        return false;
    }
}
