package me.alpha432.oyvey.features.modules.combat;

import com.google.common.eventbus.Subscribe;
import me.alpha432.oyvey.event.impl.PacketEvent;
import me.alpha432.oyvey.features.modules.Module;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.network.packet.c2s.play.PlayerInteractEntityC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;

public class Criticals extends Module {
    public Criticals() {
        super("Criticals", "Makes you do critical hits", Category.COMBAT, true, false, false);
    }public void onUpdate() {
      if (!this.EntityHit.getBool() && !this.Bowing.getBool() && !this.VehicleInstakill.getBool()) {
         Client.msg("§f§lModules:§r §7[§l" + this.name + "§r§7] false);
         this.toggle(false);
      } else {
         if (this.ticksInningShoot > 0) {
            this.ticksInningShoot--;
         }

         if (doAddPacket && yawS != 0.0F && pitchS != 0.0F) {
            Minecraft.player.connection.sendPacket(new Rotation(yawS, pitchS, groundS));
            doAddPacket = false;
         }

         boolean debug = false;
         if (debug && Minecraft.player.isJumping()) {
            Client.msg(Minecraft.player.posY + " | " + Minecraft.player.fallDistance, false);
         }
      }
   

}
