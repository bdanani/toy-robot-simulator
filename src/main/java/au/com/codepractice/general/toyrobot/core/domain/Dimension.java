package au.com.codepractice.general.toyrobot.core.domain;

import com.google.common.primitives.UnsignedInteger;

public class Dimension {
    private final UnsignedInteger width;
    private final UnsignedInteger height;

    public Dimension(UnsignedInteger width, UnsignedInteger height) {
        this.width = width;
        this.height = height;
    }

    public UnsignedInteger getWidth() {
        return width;
    }

    public UnsignedInteger getHeight() {
        return height;
    }
}
