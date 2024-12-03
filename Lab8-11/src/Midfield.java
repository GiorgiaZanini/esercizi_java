public class Midfield extends AbstractSoccerPlayer{

    protected Midfield(String name) {
        super(name);
    }

    @Override
    public boolean canUseHands() {
        return false;
    }
}
