package magic;

import fight.*;

/**
 * Magic
 */
public abstract class Magic {
    private String name;
    private int effect;
    private int mpCost;
    public Magic(String name, int effect, int mpCost) {
        this.name = name;
        this.effect = effect;
        this.mpCost = mpCost;
    }
    public abstract void use(Player p, Enemy enemy);
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
     * @return the mpCost
     */
    public int getMpCost() {
        return mpCost;
    }
}