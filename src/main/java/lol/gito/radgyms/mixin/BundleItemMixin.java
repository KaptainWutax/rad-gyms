package lol.gito.radgyms.mixin;

import lol.gito.radgyms.item.dataComponent.DataComponentManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BundleItem;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ClickType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BundleItem.class)
public abstract class BundleItemMixin {
    @Inject(method = "dropAllBundledItems", at = @At("RETURN"), cancellable = true)
    private static void RadGyms$dropAllBundledItems(ItemStack stack, PlayerEntity player, CallbackInfoReturnable<Boolean> cir) {
        Boolean bundleComponent = stack.get(DataComponentManager.INSTANCE.getRAD_GYM_BUNDLE_COMPONENT());

        if (!cir.getReturnValue()) {
            return;
        }

        if (bundleComponent != null && player instanceof ServerPlayerEntity) {
            stack.decrement(1);
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "onStackClicked", at = @At("HEAD"), cancellable = true)
    private void RadGyms$preventPuttingItems(
        ItemStack stack,
        Slot slot,
        ClickType clickType,
        PlayerEntity player,
        CallbackInfoReturnable<Boolean> cir
    ) {
        if (clickType != ClickType.RIGHT) {
            cir.setReturnValue(false);
        }

        Boolean bundleComponent = stack.get(DataComponentManager.INSTANCE.getRAD_GYM_BUNDLE_COMPONENT());

        if (bundleComponent == null) {
            cir.setReturnValue(false);
        }
    }

}
