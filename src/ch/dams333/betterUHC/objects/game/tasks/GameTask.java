package ch.dams333.betterUHC.objects.game.tasks;

import ch.dams333.betterUHC.BetterUHC;
import ch.dams333.betterUHC.objects.gameStep.GameStep;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class GameTask extends BukkitRunnable {
    BetterUHC main;
    public GameTask(BetterUHC main) {
        this.main = main;
    }

    int preGameTimer = 0;
    int gameTimer = 0;

    @Override
    public void run() {
        if(preGameTimer < 20){
            preGameTimer = preGameTimer + 1;
            if(preGameTimer == 19){
                for(Player p : Bukkit.getOnlinePlayers()){
                    p.removePotionEffect(PotionEffectType.BLINDNESS);
                    p.removePotionEffect(PotionEffectType.SLOW);
                }
                main.gameStepManager.setStep(GameStep.GAME);
                Bukkit.getWorld("world").setTime(0);
            }
        }else{
            gameTimer = gameTimer + 1;
            main.gameManager.updateScoreboard(gameTimer);
        }
    }
}
