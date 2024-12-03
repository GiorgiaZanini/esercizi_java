public abstract class AbstractSoccerPlayer implements SoccerPlayer {
    private String name;

    protected AbstractSoccerPlayer(String name) {
        this.name = name;
    }

    @Override
    public final String toString() {
        return name;
    }

    public abstract boolean canUseHands();
}