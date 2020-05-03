package ch.dams333.betterUHC.listener;

import ch.dams333.betterUHC.BetterUHC;
import ch.dams333.betterUHC.listener.actions.ClickInInventoryEvent;
import ch.dams333.betterUHC.listener.actions.ClickOnItemEvent;
import ch.dams333.betterUHC.listener.block.BreakBlockEvent;
import ch.dams333.betterUHC.listener.chat.ChatEvent;
import ch.dams333.betterUHC.listener.scenarios.*;
import ch.dams333.betterUHC.listener.item.*;
import ch.dams333.betterUHC.listener.block.PlaceBlockEvent;
import ch.dams333.betterUHC.listener.connexion.JoinEvent;
import ch.dams333.betterUHC.listener.damage.DamageByEntityEvent;
import ch.dams333.betterUHC.listener.damage.DamageEvent;
import ch.dams333.betterUHC.listener.spawn.EntitiesSpawnEvent;
import ch.dams333.betterUHC.listener.statu.ChangeFoodEvent;
import ch.dams333.betterUHC.listener.statu.MoveEvent;

public class ListenerManager {

    public ListenerManager(BetterUHC main) {

        main.getServer().getPluginManager().registerEvents(new JoinEvent(main), main);
        main.getServer().getPluginManager().registerEvents(new ClickOnItemEvent(main), main);
        main.getServer().getPluginManager().registerEvents(new ClickInInventoryEvent(main), main);
        main.getServer().getPluginManager().registerEvents(new DamageEvent(main), main);
        main.getServer().getPluginManager().registerEvents(new DamageByEntityEvent(main), main);
        main.getServer().getPluginManager().registerEvents(new ChangeFoodEvent(main), main);
        main.getServer().getPluginManager().registerEvents(new DropItemEvent(main), main);
        main.getServer().getPluginManager().registerEvents(new PlaceBlockEvent(main), main);
        main.getServer().getPluginManager().registerEvents(new BreakBlockEvent(main), main);
        main.getServer().getPluginManager().registerEvents(new GetItemEvent(main), main);
        main.getServer().getPluginManager().registerEvents(new EquipArmorEvent(main), main);
        main.getServer().getPluginManager().registerEvents(new EnchantEvent(main), main);
        main.getServer().getPluginManager().registerEvents(new AnvilEvent(main), main);
        main.getServer().getPluginManager().registerEvents(new ChatEvent(main), main);
        main.getServer().getPluginManager().registerEvents(new CutCleanEvents(main), main);
        main.getServer().getPluginManager().registerEvents(new FastSmeltingEvent(main), main);
        main.getServer().getPluginManager().registerEvents(new TimberEvent(main), main);
        main.getServer().getPluginManager().registerEvents(new BestPVEevents(main), main);
        main.getServer().getPluginManager().registerEvents(new BloodDiamondEvent(main), main);
        main.getServer().getPluginManager().registerEvents(new LongShotEvent(main), main);
        main.getServer().getPluginManager().registerEvents(new ParanoiaEvent(main), main);
        main.getServer().getPluginManager().registerEvents(new HasteyBoysEvent(main), main);
        main.getServer().getPluginManager().registerEvents(new NetherLessEvent(main), main);
        main.getServer().getPluginManager().registerEvents(main.savesManager, main);
        main.getServer().getPluginManager().registerEvents(new MoveEvent(main), main);
        main.getServer().getPluginManager().registerEvents(new InventorEvent(main), main);
        main.getServer().getPluginManager().registerEvents(new EntitiesSpawnEvent(main), main);
    }
}
