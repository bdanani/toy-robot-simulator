package au.com.codepractice.general.toyrobot.core.domain;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.IsEqual.equalTo;

public class OrientationTest {
    @Test
    public void testLeft() {
        Orientation orientation = Orientation.NORTH;

        orientation = orientation.left();
        Assert.assertThat(orientation, equalTo(Orientation.WEST));

        orientation = orientation.left();
        Assert.assertThat(orientation, equalTo(Orientation.SOUTH));

        orientation = orientation.left();
        Assert.assertThat(orientation, equalTo(Orientation.EAST));

        orientation = orientation.left();
        Assert.assertThat(orientation, equalTo(Orientation.NORTH));
    }

    @Test
    public void testRight() {
        Orientation orientation = Orientation.NORTH;

        orientation = orientation.right();
        Assert.assertThat(orientation, equalTo(Orientation.EAST));

        orientation = orientation.right();
        Assert.assertThat(orientation, equalTo(Orientation.SOUTH));

        orientation = orientation.right();
        Assert.assertThat(orientation, equalTo(Orientation.WEST));

        orientation = orientation.right();
        Assert.assertThat(orientation, equalTo(Orientation.NORTH));
    }
}
