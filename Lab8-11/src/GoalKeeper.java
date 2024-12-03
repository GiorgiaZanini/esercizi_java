public class GoalKeeper extends AbstractSoccerPlayer{

    protected GoalKeeper(String name) {
        super(name);
    }

    @Override
    public boolean canUseHands() {
        return true;
    }
}
