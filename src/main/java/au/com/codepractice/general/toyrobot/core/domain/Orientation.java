package au.com.codepractice.general.toyrobot.core.domain;

import com.google.common.primitives.UnsignedInteger;

import java.util.HashMap;
import java.util.Map;

public enum Orientation {
    NORTH(0),
    EAST(1),
    SOUTH(2),
    WEST(3);

    private int index;

    Orientation(int index) {
        this.index = index;
    }

    int getIndex() {
        return index;
    }

    private static final Map<Integer, Orientation> supportedOrientations = new HashMap<>();

    static {
        for (Orientation o : Orientation.values()) {
            supportedOrientations.put(o.getIndex(), o);
        }
    }

    public static Orientation byIndex(UnsignedInteger index) {
        return supportedOrientations.get(index.intValue());
    }

    /**
     * Return the Orientation to the left of the current orientation.
     */
    public Orientation left() {
        return byIndex(UnsignedInteger.valueOf( (index + 3) % 4 ));
    }

    /**
     * Return the Orientation to the right of the current orientation.
     */
    public Orientation right() {
        return byIndex(UnsignedInteger.valueOf( (index + 1) % 4 ));
    }

    public static Orientation defaultOrientation() {
        return Orientation.NORTH;
    }
}
