package magic;

import fight.*;

/**
 * Fire
 */
public class Fire extends Magic{
    public Fire() {
        super("Fire", 10, 5);
    }
    @Override
    public void use(Player p, Enemy enemy) {
        System.out.println(p.getName() + " used " + getName() + "!");
        System.out.println(enemy.getName() + " lost " + getEffect() + " HP!");
        enemy.setMaxHP(enemy.getMaxHP() - getEffect());
        p.setCurrentMP(p.getCurrentMP() - getMpCost());
    }
}