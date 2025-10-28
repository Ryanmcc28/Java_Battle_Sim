public class Archer extends Player implements Ability{
    public Archer(String Name){
        super(Name, 200, 70, 40, 70, 0);
    }
    private boolean deflect = false;

    @Override
    public void useAttackAbility(Player target){
        this.deflect = false;
        System.out.println(getName() + " fires a powerful arrow towards " + target.getName());

        target.takeDamage(getPower(),target,this);

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
        System.out.println(getName() + " readies themselves");
        this.deflect = true;
        this.applyTickDamage();
    }

    public boolean getDeflect(){
        return this.deflect;
    }
    public void setDeflect(boolean deflect){
        this.deflect = deflect;
    }
}
