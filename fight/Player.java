package fight;

import items.Item;
import magic.Magic;

/**
 * Player - Port de Optimizacion (meta 6,6 mb de memoria)
 */
public class Player {
    private String name;
    private int level;
    private int maxHP;
    private int currentHP;
    private int maxMP;
    private int currentMP;
    private int attack;
    private int defense;
    private int exp;
    private int expNeeded;
    private Magic[] magic;
    private Item[] items;
    private String[] invokes = {"Soul Slayer"};
    public Player(String name, int maxHP, int maxMP, Magic[] magic, Item[] items) {
        this.name = name;
        level = 1;
        this.maxHP = maxHP;
        currentHP = maxHP;
        this.maxMP = maxMP;
        currentMP = maxMP;
        attack = 4;
        defense = 2;
        exp = 0;
        expNeeded = 1000;
        this.magic = magic;
        this.items = items;
    }
    
	public boolean fight(Enemy enemy) {
        System.out.println(name + " attacks!");
        if (Main.ran.nextInt(100) + 1 > 5){
            int lifeLost = (int)((attack + Main.ran.nextInt(1))/(enemy.getDefense()/2));
            System.out.println("The enemy " + enemy.getName() + " lost " + lifeLost + "HP!");
            enemy.setMaxHP(enemy.getMaxHP() - lifeLost);
        } else {
            System.out.println(name  + "'s attack missed!");
        }
        return true;
    }
    
	public boolean defend() {
        System.out.println(name + " is defending");
        defense = defense * 2;
        return true;
    }
    
	public boolean magic(Enemy e) {
        int pos = 1;
        for (Magic mag : magic) {
            System.out.println(pos + ". " + mag.getName() + " " + mag.getMpCost() + "MP");
            pos++;
        }
        System.out.println(pos + ". Exit");
        System.out.println("Which magic do you want to use?");
        int selection = Integer.parseInt(Main.sc.nextLine());
        if (selection == pos || selection < 0 || selection > magic.length) {
            return false;
        }
        Magic magSelected = magic[selection - 1];
        if (magSelected.getMpCost() > getCurrentMP()) {
            System.out.println("Not enough MP!");
            return false;
        }
        magSelected.use(this, e);
        return true;
    }
    
	public boolean item() {
        int pos = 1;
        for (Item item : items) {
            if (item.getQuantity() > 0) {
                System.out.println(pos + ". " + item.getName() + " Quantitiy: " + item.getQuantity());
                pos++;
            }
        }
        System.out.println(pos + ". Exit");
        System.out.println("Which item do you want to use?");
        int selection = Integer.parseInt(Main.sc.nextLine());
        if (selection == pos || selection < 0 || selection > items.length) {
            return false;
        }
        Item itemSelected = items[selection - 1];
        itemSelected.use(this);
		return true;
    }

    public boolean invoke(Enemy e){
        int cont = 1;
        for (String s : invokes) {
            System.out.println(cont +  ". " +  s);
            cont++;
        }
        System.out.println(cont + ". Exit");
        System.out.print("Select invokation: ");
        switch (Main.sc.nextLine()) {
            case "1":
                return soulSlayer(e);
            default:
                return false;
        }
    }
    
	private boolean soulSlayer(Enemy e) {
        System.out.println("Try Soul Slayer?");
        if (Main.sc.nextLine().toLowerCase().startsWith("y")){
            int chance = Main.ran.nextInt(1) + 1;
            if (Main.ran.nextInt(4) * chance >= 3) {
                System.out.println(name + " awakened his Soul Slayer!");
                System.out.println(name + "'s Soul Slayer destroyed the enemy " + e.getName() + "!");
                e.setMaxHP(0);
            } else
                System.out.println(name + " failed to awake his Soul Slayer...");
            return true;
        } else 
            return false;
    }

    public void gainXP(int xp) {
        int expGained = Main.ran.nextInt(xp) + 500;
        System.out.println("You gained " + expGained + " experience points!");
        exp += expGained;
        if (exp > expNeeded) 
            levelUp();
    }
    private void levelUp() {
        System.out.println("You leveled up!");
        level++;
        System.out.println("Level: " + level);
        maxHP += 5;
        currentHP = maxHP;
        System.out.println("HP: " + maxHP);
        maxMP++;
        maxMP++;
        currentMP = maxMP;
        System.out.println("MP: " + maxMP);
        attack++;
        attack++;
        System.out.println("Attack: " + attack);
        defense++;
        defense++;
        System.out.println("Defense: " + defense);
        expNeeded += level * 100;
        System.out.println("Experience needed for next level: " + expNeeded);
    }
    /**
     * @return the attack
     */
    public int getAttack() {
        return attack;
    }
    /**
     * @return the currentHP
     */
    public int getCurrentHP() {
        return currentHP;
    }
    /**
     * @return the currentMP
     */
    public int getCurrentMP() {
        return currentMP;
    }
    /**
     * @return the defense
     */
    public int getDefense() {
        return defense;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @return the maxHP
     */
    public int getMaxHP() {
        return maxHP;
    }
    /**
     * @return the maxMP
     */
    public int getMaxMP() {
        return maxMP;
    }
    /**
     * @param currentHP the currentHP to set
     */
    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }
    /**
     * @param currentMP the currentMP to set
     */
    public void setCurrentMP(int currentMP) {
        this.currentMP = currentMP;
    }
    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }
}