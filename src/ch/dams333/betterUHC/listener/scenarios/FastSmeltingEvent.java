package ch.dams333.betterUHC.listener.scenarios;

import ch.dams333.betterUHC.BetterUHC;
import org.bukkit.event.Listener;

public class FastSmeltingEvent implements Listener {
    BetterUHC main;
    public FastSmeltingEvent(BetterUHC main) {
        this.main = main;
    }

    /*@EventHandler
    public void onBurn(FurnaceBurnEvent e)
    {
        if (main.gameScenariosManager.isScenarioActivate("fast smelting")) {
            handleCookingTime((Furnace)e.getBlock().getState(), 4);
        }
    }

    private void handleCookingTime(final Furnace block, final int speed)
    {
        new BukkitRunnable()
        {
            public void run()
            {
                if ((block.getCookTime() > 0) || (block.getBurnTime() > 0))
                {
                    block.setCookTime((short)(block.getCookTime() + speed));
                    block.update();
                }
                else
                {
                    cancel();
                }
            }
        }.runTaskTimer(main, 5, 5);
    }*/

}
