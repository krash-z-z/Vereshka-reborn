package me.alpha432.oyvey.features.modules.movement;

import me.alpha432.oyvey.features.modules.Module;

public class speed extends Module {
    public speed() {
        super("szybki speed na metahvh", Category.MOVEMENT, true, false, false);
    }

    @Override
    public void onUpdate() 
{
        boolean longHop = this.LongHop.getBool() && (Minecraft.player.isJumping() || Minecraft.player.fallDistance != 0.0f);
        boolean onGround = this.OnGround.getBool() && !Minecraft.player.isJumping() && Minecraft.player.onGround && Minecraft.player.isCollidedVertically && MoveMeHelp.getSpeed() < 0.9;
        Speed.mc.timer.speed = 1.2;
        if (longHop) {
            Minecraft.player.jumpMovementFactor = 0.17f;
            Minecraft.player.multiplyMotionXZ(1.005f);
        }
        if (onGround) {
            Minecraft.player.multiplyMotionXZ(1.212f);
        }
    }
    }
}
