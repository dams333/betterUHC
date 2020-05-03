package ch.dams333.betterUHC.objects.game.tasks;

import ch.dams333.betterUHC.BetterUHC;
import org.bukkit.Bukkit;
import org.bukkit.WorldBorder;
import org.bukkit.scheduler.BukkitRunnable;

public class Bordertask extends BukkitRunnable {
    BetterUHC main;
    WorldBorder worldBorder1;
    WorldBorder worldBorder2;
    int blockperSec;
    int time;
    public Bordertask(BetterUHC main) {
        this.main = main;
        worldBorder1 = Bukkit.getWorld("world").getWorldBorder();
        worldBorder2 = Bukkit.getWorld("world_nether").getWorldBorder();
        blockperSec = (main.gameVariables.preBorder - main.gameVariables.postBorder)/(main.gameVariables.reductionTime);
        if(blockperSec < 1){
            blockperSec = 1;
        }
        time = 0;
    }

    @Override
    public void run() {
        time = time + 1;
        if(time <= main.gameVariables.reductionTime){
            worldBorder1.setSize((main.gameVariables.preBorder - (time * blockperSec)) * 2);
            worldBorder2.setSize((main.gameVariables.preBorder - (time * blockperSec)) * 2);
            main.gameManager.setBorder(main.gameVariables.preBorder - (time * blockperSec));
        }else{
            cancel();
        }
    }
}
