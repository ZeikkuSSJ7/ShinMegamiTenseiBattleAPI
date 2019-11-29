package magic;

import fight.*;

/**
 * Dia
 */
public class Dia extends Magic{
    public Dia() {
        super("Dia", 50, 5);
    }
    @Override
    public void use(Player p, Enemy enemy) {
        System.out.println(p.getName() + " used " + getName() + "!");
        System.out.println(p.getName() + " recovered " + getEffect() + " HP!");
        p.setCurrentHP(p.getCurrentHP() + getEffect());
        p.setCurrentMP(p.getCurrentMP() - getMpCost());
    }
}