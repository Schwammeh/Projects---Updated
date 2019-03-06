package rpg;


public class Wizard extends Character{
    
    int maxMagic;
    int currMagic;
            
    public Wizard(String n,int s,int d,int i,int def,int maxMagic){
        super(n,s,d,i,def);
        this.maxMagic = maxMagic;
        this.currMagic = this.maxMagic;
    }
    public int castLightning(Enemy enemy){        
        if(this.currMagic >= 5){
            this.currMagic -= 5;
            int magicDmg = (this.intel/2) + dice.rollD6();
            int playerAtk = magicDmg;
            int enemyDmgTaken = playerAtk;
            enemy.currLife -= Math.abs(enemyDmgTaken);
            System.out.println(this.name + " used lightning bolt");
            System.out.println(enemy.name + " took " + Math.abs(enemyDmgTaken) + " damage");
            System.out.println(enemy.name + " HP: " + enemy.maxLife + "/" + enemy.currLife);
        }
        else{
            if(this.currMagic < 4);
            System.out.println("You cannot use spells");
        }
        return this.currMagic;
    }
    public int castHeal(){
        if(this.currMagic >= 8){
            this.currMagic -= 8;
            int magicHeal = this.intel + dice.rollD6();
            this.currLife = this.currLife + magicHeal;
            System.out.println("Healed for " + magicHeal);
            if(this.currLife >= this.maxLife) this.currLife = this.maxLife;
        }
        else{
            if(this.currMagic < 7);
            System.out.println("You cannot use spells");
        }
        return this.currMagic;
    }
    public int getMaxMagic(){
        return this.maxMagic;
    }
    public int getCurrMagic(){
        return this.currMagic;
    }
    
}
