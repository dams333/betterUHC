package ch.dams333.betterUHC.listener.item;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.UUID;

public class ItemLimit {

    private Player p;
    private Material mat;
    private int count;
    private int limit;
    private UUID uuid;

    public void setCount(int count) {
        this.count = count;
    }

    public Player getP() {

        return p;
    }

    public Material getMat() {
        return mat;
    }

    public int getCount() {
        return count;
    }

    public int getLimit() {
        return limit;
    }

    public UUID getUuid() {
        return uuid;
    }

    public ItemLimit(Player p, Material mat, int count, int limit) {
        this.uuid = UUID.randomUUID();

        this.p = p;
        this.mat = mat;
        this.count = count;
        this.limit = limit;
    }
}
