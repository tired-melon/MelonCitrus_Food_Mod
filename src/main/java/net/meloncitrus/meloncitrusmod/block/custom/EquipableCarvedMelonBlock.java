package net.meloncitrus.meloncitrusmod.block.custom;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.jetbrains.annotations.NotNull;

public class EquipableCarvedMelonBlock extends CarvedMelonBlock implements Equipable {
    public EquipableCarvedMelonBlock(BlockBehaviour.Properties p_289677_) {
        super(p_289677_);
    }

    public @NotNull EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.HEAD;
    }
}
