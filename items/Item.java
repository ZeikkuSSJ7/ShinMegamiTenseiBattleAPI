package items;

import fight.Player;

/**
 * Item
 */
public abstract class Item {
    private String name;
    private int quantity;
    private int effect;
    public Item(String name, int quantity, int effect) {
        this.name = name;
        this.effect = effect;
        this.quantity = quantity;
    }
    public abstract void use(Player p);
    /**
     * @return the effect
     */
    public int getEffect() {
        return effect;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }
}