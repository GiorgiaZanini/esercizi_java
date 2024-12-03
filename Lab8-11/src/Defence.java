public class Defence extends AbstractSoccerPlayer{

    protected Defence(String name) {
        super(name);
    }

    @Override
    public boolean canUseHands() {
        return false;
    }
}
