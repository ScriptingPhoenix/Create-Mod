package me.firebird.samplemod;

import me.scriptingphoenix.createmod.core.cell.Rotation;
import me.scriptingphoenix.createmod.core.cell.TrackedCell;
import me.scriptingphoenix.createmod.core.grid.GridManager;

public class SomethingCell extends TrackedCell {
    short age = 0;
    public SomethingCell(Rotation rot) {
        super(rot);
    }

    @Override
    public void tick() {
        age += 1;
        if(age > 5)
            return;
        for(Rotation rot : Rotation.values()) {
            if(GridManager.get().getCell(this.getX()+rot.horizontalOffset(), this.getY()+rot.verticalOffset()) instanceof SomethingCell)
                continue;
            SomethingCell cell = new SomethingCell(this.getRotation());
            cell.setLastPosition(getX(), getY());
            GridManager.get().setCell(this.getX()+rot.horizontalOffset(), this.getY()+rot.verticalOffset(), cell);
        }
    }

    @Override
    public boolean[] push(Rotation dir, int bias) { return new boolean[] {false, false}; }

    @Override
    public String getName() {
        return "Something";
    }

    @Override
    protected String getId() {
        return "something";
    }

    @Override
    protected String getModId() {
        return "sm";
    }
}
