package captindutch;

import captindutch.states.State;

public class StateManager {

    private static State curState;

    public static void setState(State state) {
        curState = state;
    }

    public static State getState() {
        return curState;
    }

}
