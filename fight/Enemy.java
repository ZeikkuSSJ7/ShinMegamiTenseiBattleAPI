package fight;

public class Enemy{
    private String name;
    private int maxHP;
    private int attack;
    private int defense;
    private int xpBase;
    public Enemy(String name, int maxHP, int attack, int defense, int xpBase) {
        this.name = name;
        this.maxHP = maxHP;
        this.attack = attack;
        this.defense = defense;
        this.xpBase = xpBase;
    }
    public boolean fight(Player enemy) {
        System.out.println(name + " attacks!");
        if (Main.ran.nextInt(100) + 1 > 5){
            int lifeLost = (int)((attack + Main.ran.nextInt(1))/(enemy.getDefense()/2));
            System.out.println(enemy.getName() + " lost " + lifeLost + "HP!");
            enemy.setCurrentHP(enemy.getCurrentHP() - lifeLost);
        } else {
            System.out.println(name  + "'s attack missed!");
        }
        return true;
    }
    /**
     * @return the attack
     */
    public int getAttack() {
        return attack;
    }
    /**
     * @return the defense
     */
    public int getDefense() {
        return defense;
    }
    /**
     * @return the maxHP
     */
    public int getMaxHP() {
        return maxHP;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param attack the attack to set
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }
    /**
     * @param defense the defense to set
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }
    /**
     * @param maxHP the maxHP to set
     */
    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }/**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the xpBase
     */
    public int getXpBase() {
        return xpBase;
    }
}
