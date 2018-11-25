package au.com.codepractice.general.toyrobot.core.domain;

public class GameState {
    private Placement toyRobotPlacement;
    private boolean toyRobotPlaced;

    public Placement getToyRobotPlacement() {
        return toyRobotPlacement;
    }

    public boolean isToyRobotPlaced() {
        return toyRobotPlaced;
    }

    public void setToyRobotPlacement(Placement toyRobotPlacement) {
        this.toyRobotPlacement = toyRobotPlacement;
        if (toyRobotPlacement != null)
            toyRobotPlaced = true;
    }
}
