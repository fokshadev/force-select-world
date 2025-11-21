package io.github.foksha.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.gui.screen.world.WorldListWidget;
import net.minecraft.world.level.storage.LevelStorage;
import net.minecraft.world.level.storage.LevelSummary;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.List;

@Mixin(WorldListWidget.class)
public class WorldListWidgetMixin {
    @WrapOperation(method = "loadLevels", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/storage/LevelStorage$LevelList;isEmpty()Z"))
	private boolean forceOpenScreen(LevelStorage.LevelList instance, Operation<Boolean> original) {
		return false;
	}

    @WrapOperation(method = "show", at = @At(value = "INVOKE", target = "Ljava/util/List;isEmpty()Z"))
    private boolean forceOpenScreen(List<LevelSummary> instance, Operation<Boolean> original) {
        return false;
    }
}