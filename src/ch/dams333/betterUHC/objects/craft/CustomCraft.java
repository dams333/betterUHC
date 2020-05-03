package ch.dams333.betterUHC.objects.craft;

import ch.dams333.betterUHC.BetterUHC;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import java.util.*;

public class CustomCraft {

    private ItemStack aa;
    private ItemStack ab;
    private ItemStack ac;
    private ItemStack ba;
    private ItemStack bb;
    private ItemStack bc;
    private ItemStack ca;
    private ItemStack cb;
    private ItemStack cc;
    private ItemStack result;
    private UUID uuid;

    public ItemStack getAa() {
        return aa;
    }

    public void setAa(ItemStack aa) {
        if(aa != null) {
            this.aa = aa;
        }else{
            this.aa = new ItemStack(Material.AIR);
        }
    }

    public void setAb(ItemStack ab) {
        if(ab != null) {
            this.ab = ab;
        }else{
            this.ab = new ItemStack(Material.AIR);
        }    }

    public void setAc(ItemStack ac) {
        if(ac != null) {
            this.ac = ac;
        }else{
            this.ac = new ItemStack(Material.AIR);
        }    }

    public void setBa(ItemStack ba) {
        if(ba != null) {
            this.ba = ba;
        }else{
            this.ba = new ItemStack(Material.AIR);
        }    }

    public void setBb(ItemStack bb) {
        if(bb != null) {
            this.bb = bb;
        }else{
            this.bb = new ItemStack(Material.AIR);
        }    }

    public void setBc(ItemStack bc) {
        if(bc != null) {
            this.bc = bc;
        }else{
            this.bc = new ItemStack(Material.AIR);
        }    }

    public void setCa(ItemStack ca) {
        if(ca != null) {
            this.ca = ca;
        }else{
            this.ca = new ItemStack(Material.AIR);
        }    }

    public void setCb(ItemStack cb) {
        if(cb != null) {
            this.cb = cb;
        }else{
            this.cb = new ItemStack(Material.AIR);
        }    }

    public void setCc(ItemStack cc) {
        if(cc != null) {
            this.cc = cc;
        }else{
            this.cc = new ItemStack(Material.AIR);
        }    }

    public void setResult(ItemStack result) {
        this.result = result;
    }

    public CustomCraft() {
        this.uuid = UUID.randomUUID();
    }

    public ItemStack getAb() {
        return ab;
    }

    public ItemStack getAc() {
        return ac;
    }

    public ItemStack getBa() {
        return ba;
    }

    public ItemStack getBb() {
        return bb;
    }

    public ItemStack getBc() {
        return bc;
    }

    public ItemStack getCa() {
        return ca;
    }

    public ItemStack getCb() {
        return cb;
    }

    public ItemStack getCc() {
        return cc;
    }

    public ItemStack getResult() {
        return result;
    }

    public UUID getUuid() {

        return uuid;
    }

    public CustomCraft(ItemStack aa, ItemStack ab, ItemStack ac, ItemStack ba, ItemStack bb, ItemStack bc, ItemStack ca, ItemStack cb, ItemStack cc, ItemStack result, UUID uuid) {

        this.aa = aa;
        this.ab = ab;
        this.ac = ac;
        this.ba = ba;
        this.bb = bb;
        this.bc = bc;
        this.ca = ca;
        this.cb = cb;
        this.cc = cc;
        this.result = result;
        this.uuid = uuid;
    }

    public void apply(BetterUHC main) {

        Map<Material, Character> matSymbol = new HashMap<>();

        List<Character> symbols = Arrays.asList('*', '#', '%', '&', '/', '(', ')', '=', '?');

        List<ItemStack> ingredients = new ArrayList<>();
        ingredients.add(this.getAa());
        ingredients.add(this.getAb());
        ingredients.add(this.getAc());
        ingredients.add(this.getBa());
        ingredients.add(this.getBb());
        ingredients.add(this.getBc());
        ingredients.add(this.getCa());
        ingredients.add(this.getCb());
        ingredients.add(this.getCc());

        int index = 0;

        for(ItemStack it : ingredients){
            if(!matSymbol.keySet().contains(it.getType())){
                matSymbol.put(it.getType(), symbols.get(index));
                index = index + 1;
            }
        }

        String line1 = String.valueOf(matSymbol.get(this.getAa().getType()) + "" + matSymbol.get(this.getAb().getType()) + "" + matSymbol.get(this.getAc().getType()));
        String line2 = String.valueOf(matSymbol.get(this.getBa().getType()) + "" + matSymbol.get(this.getBb().getType()) + "" + matSymbol.get(this.getBc().getType()));
        String line3 = String.valueOf(matSymbol.get(this.getCa().getType()) + "" + matSymbol.get(this.getCb().getType()) + "" + matSymbol.get(this.getCc().getType()));

        ShapedRecipe craftRecipe = new ShapedRecipe(this.getResult());

        craftRecipe.shape(line1, line2, line3);

        for(Material mat : matSymbol.keySet()){
            craftRecipe.setIngredient(matSymbol.get(mat), mat);
        }

        main.getServer().addRecipe(craftRecipe);
    }
}
