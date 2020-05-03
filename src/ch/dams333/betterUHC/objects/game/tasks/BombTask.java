package ch.dams333.betterUHC.objects.game.tasks;


import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.scheduler.BukkitRunnable;

public class BombTask extends BukkitRunnable {

    private Location loc;
    private int timer;
    ArmorStand armorStand;

    public BombTask(Location loc, ArmorStand armorStand) {
        this.loc = loc;
        timer = 0;
        this.armorStand = armorStand;
    }

    @Override
    public void run() {
        timer = timer + 1;
        armorStand.setCustomName(String.valueOf(60 - timer));
        if(timer >= 60){

            loc.getBlock().setType(Material.AIR);
            loc.add(1, 0, 0);
            loc.getBlock().setType(Material.AIR);
            armorStand.remove();
            loc.getWorld().createExplosion(loc, 2, false, true);

            cancel();
        }
    }
}
