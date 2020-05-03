package ch.dams333.betterUHC.objects.scenarios;


import org.bukkit.Material;

import java.util.List;

public class GameScenario {

    private String name;
    private Material material;
    private boolean activated;
    private List<String> lore;

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

    public List<String> getLore() {
        return lore;
    }

    public GameScenario(String name,  List<String> lore, Material material) {
        this.name = name;
        this.material = material;
        this.activated = false;
        this.lore = lore;
    }
}
