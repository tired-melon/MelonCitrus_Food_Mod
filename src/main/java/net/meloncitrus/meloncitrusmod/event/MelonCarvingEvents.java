package net.meloncitrus.meloncitrusmod.event;

import net.meloncitrus.meloncitrusmod.MelonCitrusMod;
import net.meloncitrus.meloncitrusmod.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MelonCitrusMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MelonCarvingEvents {

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        Player player = event.getEntity();
        ItemStack heldItem = event.getItemStack();

        if (!heldItem.is(Items.SHEARS)) return;
        if (level.isClientSide) return;

        BlockState state = level.getBlockState(pos);

        // Your uncarved melon block
        if (state.is(Blocks.MELON)) {

            // Replace with carved version
            BlockState carved = ModBlocks.CARVED_MELON.get().defaultBlockState();
            level.setBlock(pos, carved, 3);

            // Damage the shears
            heldItem.hurtAndBreak(1, player,
                    p -> p.broadcastBreakEvent(event.getHand()));

            // Sound + drops
            level.playSound(null, pos, SoundEvents.PUMPKIN_CARVE,
                    SoundSource.BLOCKS, 1.0f, 1.0f);

            assert event.getFace() != null;
            Block.popResource(level, pos.relative(event.getFace()),
                    new ItemStack(Items.MELON_SEEDS, 4));

            event.setCanceled(true);
            event.setCancellationResult(InteractionResult.SUCCESS);
        }
    }
}
