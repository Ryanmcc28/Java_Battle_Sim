public class Mage extends Player implements Ability{
    public Mage(String Name){
        super(Name, 200, 40, 20, 60 ,0);
    }

    @Override
    public void useAttackAbility(Player target){
        System.out.println(getName() + " casts a poweful fireball towards " + target.getName());
            target.takeDamage(getPower(), target, this);
            target.setTickDamage(target.getTickDamage()+6);


        this.applyTickDamage();
        target.isAlive();
        if(!target.isAlive()){
            System.out.println(target.getName() + " has fallen!!");
            System.out.println(this.getName() + " has won the fight...");
            System.exit(0);
        }
    }
    @Override
    public void useDefenceAbility(){
        System.out.println(getName() + " uses a spell to heal 30 health");
        this.applyTickDamage();
        this.setHealth(this.getHealth() + 30);
    }
}
