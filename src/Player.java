import java.util.ArrayList;
import java.util.NavigableMap;

public abstract class Player implements Ability{
    private String name;
    private int health;
    private int power;
    private int defense;
    private int speed;
    private int tickDamage;

    public Player(String Name, int Health, int Power, int Defence, int Speed, int TickDamage){
        name = Name;
        health = Health;
        power = Power;
        defense = Defence;
        speed = Speed;
        tickDamage = TickDamage;
    }

    public void applyTickDamage(){
        if(tickDamage <= 0) return;
        health -= tickDamage;
        System.out.println(name + " suffers " + tickDamage + " burn damage");
        tickDamage -= 1;
    }

    public void takeDamage(int damage, Player target, Player attacker){
        if(target instanceof Archer archer && archer.getDeflect()){
            if(Math.random() <= 0.5) {
                System.out.println("Attack Deflected!!!!!");
                System.out.println("Direct hit!!! " + attacker.name + " lost " + damage + " health");
                attacker.setHealth(attacker.health -= damage);
            }else {
                System.out.println("Direct hit!!! " + target.name + " lost " + damage + " health");
                target.health -= (damage);
                System.out.println();
            }
        }
        else if(Math.random() <= (double)target.defense/100) System.out.println("Attack defended!!!");
        else{
            System.out.println("Direct hit!!! " + target.name + " lost " + damage + " health");
            target.health -= (damage);
            System.out.println();
        }
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }

    public int getPower() {
        return power;
    }
    public void setPower(int power) {
        this.power = power;
    }

    public int getDefense() {
        return defense;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getTickDamage(){return tickDamage;}
    public void setTickDamage(int tickDamage){this.tickDamage = tickDamage;}

    public boolean isAlive(){
        return this.health > 0;
    }

    public void printStats() {
        System.out.println("===== Player Stats =====");
        System.out.println("Name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Power: " + power);
        System.out.println("Defense: " + defense);
        System.out.println("Speed: " + speed);
        System.out.println("Fire Effect: " + tickDamage);
        System.out.println("========================");
    }

    public void won(){
        System.out.println(name+ " is the winner!!!!");
        System.exit(0);
    }

}
