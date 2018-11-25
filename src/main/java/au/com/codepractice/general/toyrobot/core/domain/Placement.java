package au.com.codepractice.general.toyrobot.core.domain;

import lombok.Data;

@Data
public class Placement {
    private final Position position;
    private final Orientation orientation;

    public Placement(Position position, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;
    }

    public Position getPosition() {
        return position;
    }
    public Orientation getOrientation() {
        return orientation;
    }
}

