public class Forward extends AbstractSoccerPlayer{

    protected Forward(String name) {
        super(name);
    }

    @Override
    public boolean canUseHands() {
        return false;
    }
}
