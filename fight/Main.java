package fight;

import java.util.Random;
import java.util.Scanner;

import items.Item;
import items.Potion;
import magic.Fire;
import magic.Magic;
import magic.Thunder;

/**
 * Main
 */
public class Main {
    static Scanner sc = new Scanner(System.in);
    static Random ran = new Random();
    static Player player;
    static Enemy enemy;
    static Enemy[] enemies;
    public static void initialize() {
        Magic[] magic = {new Fire(), new Thunder()};
        Item[] items = {new Potion()};
        System.out.print("Introduce a name to be used in battle: ");
        player = new Player(sc.nextLine(), 40, 20, magic, items);
        enemy = enemies[0];
    }
    public static void initializeEnemies() {
        Enemy[] e = {new Enemy("Zombie", 40, 2, 2, 250), new Enemy("Wolf", 80, 15, 8, 750)};
        enemies = e;
    }
    public static void main(String[] args) {
        initializeEnemies();
        initialize();
        boolean endTurn = false;
        while (true && player.getCurrentHP() > 0){
            endTurn = false;
            while (!endTurn) {
            System.out.println("HP: " + player.getCurrentHP() + "/" + player.getMaxHP() + " MP: " + player.getCurrentMP() + "/" + player.getMaxMP() + 
                "\nEnemy HP: " + enemy.getMaxHP() + 
                "\nWhat will " + player.getName() + " do?" + 
                "\n1) Fight 2) Item 3) Magic 4) Defend 5) Invoke");
                switch ("1") {
                    case "1":
                        endTurn = player.fight(enemy);
                        break;
                    case "2":
                        endTurn = player.item();
                        break;
                    case "3":
                        endTurn = player.magic(enemy);                    
                        break;
                    case "4":
                        endTurn = player.defend();                    
                        break;
                    case "5":
                        endTurn = player.invoke(enemy);
                        break;
                    default:
                        System.out.println("poops");
                        break;
                }
            }
            if (enemy.getMaxHP() <= 0){
                player.gainXP(enemy.getXpBase());
                if (player.getLevel() < 10) {
                    enemy = new Enemy("Zombie", 40, 2, 2, 250);
                } else if (player.getLevel() < 20) {
                    enemy = new Enemy("Wolf", 100, 15, 10, 750);
                } else if (player.getLevel() < 30) {
                    enemy = new Enemy("Jack Frost", 300, 50, 40, 2000);
                } else {
                    break;
                }
            } else {
                enemy.fight(player);
            }
            if (player.getCurrentHP() > player.getMaxHP()) {
                player.setCurrentHP(player.getMaxHP());
            }
        }
        System.out.println("Game over!");
    }
}