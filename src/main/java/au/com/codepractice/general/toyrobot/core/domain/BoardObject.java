package au.com.codepractice.general.toyrobot.core.domain;

public abstract class BoardObject {
    protected Placement placement;
    public final void setPlacement(Placement placement) {
        this.placement = placement;
    }
    public final Placement getPlacement(){
        return placement;
    }
}