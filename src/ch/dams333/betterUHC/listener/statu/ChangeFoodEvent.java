package ch.dams333.betterUHC.listener.statu;

import ch.dams333.betterUHC.BetterUHC;
import ch.dams333.betterUHC.objects.gameStep.GameStep;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class ChangeFoodEvent implements Listener {
    BetterUHC main;
    public ChangeFoodEvent(BetterUHC main) {
        this.main = main;
    }

    @EventHandler
    public void changeFood(FoodLevelChangeEvent e){
        Player p = (Player) e.getEntity();
        if(main.gameStepManager.isStep(GameStep.PREGAME)){
            e.setCancelled(true);
        }else{
            if(main.gameManager.getGameTime() < main.gameVariables.graceTime){
                e.setCancelled(true);
            }
        }
    }
}
