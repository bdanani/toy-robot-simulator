package au.com.codepractice.general.toyrobot.core.domain;

import lombok.Data;

@Data
public class Position {

    private int xPos;
    private int yPos;

    public Position (int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public Position incrementX() {
        return new Position(xPos + 1, yPos);
    }

    public Position decrementX() {
        return new Position(xPos - 1, yPos);
    }

    public Position incrementY() {
        return new Position(xPos, yPos + 1);
    }

    public Position decrementY() {
        return new Position(xPos, yPos - 1);
    }

    @Override
    public String toString() {
        return "Position [xPos=" + xPos + ", yPos=" + yPos + "]";
    }

}
