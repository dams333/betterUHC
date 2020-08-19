package ch.dams333.betterUHC.objects.scenarios;


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;

public class GameScenario {

    private String name;
    private Material material;
    private boolean activated;
    private List<String> lore;
    private List<ScenarioArgument> arguments;

    public String getName() {
        return name;
    }

    public Material getMaterial() {
        return material;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public List<ScenarioArgument> getArguments() {
        return arguments;
    }

    public List<String> getLore() {
        if(arguments == null){
            return lore;
        }else{
            List<String> result = new ArrayList<>();
            result.addAll(lore);

            result.add(ChatColor.GOLD + "Clique droit pour paramétrer");
            return result;
        }
    }

    public GameScenario(String name,  List<String> lore, Material material, List<ScenarioArgument> arguments) {
        this.name = name;
        this.material = material;
        this.activated = false;
        this.lore = lore;
        this.arguments = arguments;
    }

    public Inventory addArguments(Inventory inv) {
        int index = 0;
        for(ScenarioArgument arg : this.arguments){
            inv.setItem(index, arg.getItem());
            index++;
        }
        return inv;
    }
}
