public class Warrior extends Player implements Ability{
    public Warrior(String Name){
        super(Name, 350, 30, 20, 40, 0);
    }

    @Override
    public void useAttackAbility(Player target){


        System.out.println(getName() + " Performs a powerful slash");

        target.takeDamage(getPower(), target,this);


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
        System.out.println(getName() + " takes a defensive stace. Defence increased by 10");
        this.applyTickDamage();
        this.setDefense(getDefense()+10);

    }
}
