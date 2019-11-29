package items;

import fight.Player;

/**
 * Potion
 */
public class Potion extends Item {
    public Potion() {
        super("Potion", 5, 50);
    }
    @Override
    public void use(Player p) {
        System.out.println(p.getName() + " used " + getName() + "!");
        System.out.println(p.getName() + " recovered " + getEffect() + "HP!");
        p.setCurrentHP(p.getCurrentHP() + getEffect());
    }
}