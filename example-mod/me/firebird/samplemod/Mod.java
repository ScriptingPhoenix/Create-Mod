package me.firebird.samplemod;

import me.scriptingphoenix.createmod.core.cell.Rotation;
import me.scriptingphoenix.createmod.core.grid.CellManager;

public class Mod implements me.scriptingphoenix.createmod.modding.Mod {
    @Override
    public void enable() {
        CellManager.registerCell(new SomethingCell(Rotation.RIGHT));
        CellManager.addToUpdateOrder(CellManager.UpdateOrderOffset.PRE_GENERATOR, new SomethingCell(Rotation.RIGHT).type);
        System.out.println("Hi");
    }

    @Override
    public void disable() {
        CellManager.unregisterCell(new SomethingCell(Rotation.RIGHT));
        CellManager.removeFromUpdateOrder(new SomethingCell(Rotation.RIGHT).type);
        System.out.println("Bye");
    }
}
