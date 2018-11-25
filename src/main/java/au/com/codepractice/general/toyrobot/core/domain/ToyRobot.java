package au.com.codepractice.general.toyrobot.core.domain;

public class ToyRobot extends BoardObject {
    /*
    public String reportStatus() {
        if(placement == null){
            return String.format("%s %s", this.getClass().getName(), " [A valid placement (Position/Orientation) hasn't been initialised]");
        }
        return buildStatusMessage();
    }

    private String buildStatusMessage() {
        StringBuilder statusMessage = new StringBuilder();
        statusMessage.append(" (").append(placement.getPosition().getXPos()).append(",");
        statusMessage.append(placement.getPosition().getYPos()).append("),");
        statusMessage.append(placement.getOrientation().name());
        return statusMessage.toString();
    }
    */
}