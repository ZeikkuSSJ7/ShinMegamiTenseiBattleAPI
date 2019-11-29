package magic;

import fight.*;

/**
 * Thunder
 */
public class Thunder extends Magic{
    public Thunder() {
        super("Thunder", 20, 10);
    }
    @Override
    public void use(Player p, Enemy enemy) {
        System.out.println(p.getName() + " used " + getName() + "!");
        System.out.println(enemy.getName() + " lost " + getEffect() + " HP!");
        enemy.setMaxHP(enemy.getMaxHP() - getEffect());
        p.setCurrentMP(p.getCurrentMP() - getMpCost());
    }
}