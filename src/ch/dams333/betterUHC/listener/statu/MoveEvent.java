package ch.dams333.betterUHC.listener.statu;

import ch.dams333.betterUHC.BetterUHC;
import ch.dams333.betterUHC.objects.gameStep.GameStep;
import net.minecraft.server.v1_15_R1.ChatMessageType;
import net.minecraft.server.v1_15_R1.IChatBaseComponent;
import net.minecraft.server.v1_15_R1.PacketPlayOutChat;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_15_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;


public class MoveEvent implements Listener {
    BetterUHC main;
    public MoveEvent(BetterUHC main) {
        this.main = main;
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        if (main.gameStepManager.isStep(GameStep.GAME)) {
            sendActionBar(e.getPlayer(),ChatColor.WHITE + "X: " + ChatColor.GOLD + String.valueOf(Math.round(e.getTo().getX())) + ChatColor.GRAY + " | "
                    + ChatColor.WHITE + "Y: " + ChatColor.GOLD + String.valueOf(Math.round(e.getTo().getY())) + ChatColor.GRAY + " | "
                    + ChatColor.WHITE + "Z: " + ChatColor.GOLD + String.valueOf(Math.round(e.getTo().getZ())));

        }
    }

    private void sendActionBar(Player player, String message) {
        IChatBaseComponent chat = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + message + "\"}");

        PacketPlayOutChat packetPlayOutChat = new PacketPlayOutChat(chat, ChatMessageType.GAME_INFO);

        CraftPlayer craft = (CraftPlayer) player;

        craft.getHandle().playerConnection.sendPacket(packetPlayOutChat);
    }
}
