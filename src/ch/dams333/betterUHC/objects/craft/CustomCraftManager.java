package ch.dams333.betterUHC.objects.craft;

import ch.dams333.betterUHC.BetterUHC;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomCraftManager {
    BetterUHC main;

    private List<CustomCraft> customCrafts;

    public CustomCraftManager(BetterUHC betterUHC) {
        this.main = betterUHC;
        customCrafts = new ArrayList<>();
    }

    public List<CustomCraft> getCustomCrafts() {
        return customCrafts;
    }

    public boolean addCraft(Inventory inv) {
        if(inv.getContents()[24] != null) {
            if (inv.getContents()[10] != null || inv.getContents()[11] != null || inv.getContents()[12] != null || inv.getContents()[19] != null || inv.getContents()[20] != null || inv.getContents()[21] != null || inv.getContents()[28] != null || inv.getContents()[29] != null || inv.getContents()[30] != null) {
                CustomCraft customCraft = new CustomCraft();
                customCraft.setAa(inv.getContents()[10]);
                customCraft.setAb(inv.getContents()[11]);
                customCraft.setAc(inv.getContents()[12]);
                customCraft.setBa(inv.getContents()[19]);
                customCraft.setBb(inv.getContents()[20]);
                customCraft.setBc(inv.getContents()[21]);
                customCraft.setCa(inv.getContents()[28]);
                customCraft.setCb(inv.getContents()[29]);
                customCraft.setCc(inv.getContents()[30]);
                customCraft.setResult(inv.getContents()[24]);
                this.customCrafts.add(customCraft);
                return true;
            }
        }
        return false;
    }

    public void setCustomCrafts(List<CustomCraft> customCrafts) {
        this.customCrafts = customCrafts;
    }

    public void removeCraft(UUID uuid){
        for(CustomCraft customCraft : this.customCrafts){
            if(customCraft.getUuid().toString().equalsIgnoreCase(uuid.toString())){
                this.customCrafts.remove(customCraft);
                return;
            }
        }
    }

    public void applyCrafts() {
        for(CustomCraft customCraft : this.customCrafts){
            customCraft.apply(main);
        }
    }
}
