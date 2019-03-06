package rpg;

import java.lang.Math;
import java.util.Random;
import static rpg.Enemy.dice;

public class Character {
    static Dice dice = new Dice();
    String name;
    int str;//strength
    int dex;//dexterity
    int intel;//intelligence
    int maxLife;
    int currLife;
    int hitRate;
    int proficiency;
    int defense;
    int heal;
    
    public Character(String n,int s,int d,int i,int def){
        Random r = new Random();
        this.name = n;
        this.str = s;
        this.dex = d;
        this.intel = i;
        this.maxLife = dice.rollD6() + 50;
        this.currLife = this.maxLife;
        this.proficiency = 2;
        this.defense = def;     
        this.hitRate = this.dex + this.proficiency;
        this.heal = 5;
     
    }
    public int attack(Enemy enemy){
        Random r = new Random();
        int missRate = r.nextInt(20)+1;
        int atk = (this.str / 2) + dice.rollD6();
        if(this.hitRate > missRate){//hit
            int playerAtk = atk;
            int enemyDmgTaken = playerAtk - enemy.defense;
            if(enemyDmgTaken <= 0) enemyDmgTaken = 0;
                enemy.currLife -= Math.abs(enemyDmgTaken);
                System.out.println(this.name + " attacked");
                System.out.println(enemy.name + " took " + Math.abs(enemyDmgTaken) + " damage");
                System.out.println(enemy.name + " HP: " + enemy.maxLife + "/" + enemy.currLife);
        }
        else{
            System.out.println(this.name + " Attack missed");
            System.out.println("Your HP: " + this.currLife);
            if(enemy.hitRate > r.nextInt(20)+1){//opportunity to attack
                int chanceAtk = (enemy.str /2) + dice.rollD6();
                int playerDmgTaken = chanceAtk - this.defense;
                if(playerDmgTaken <= 0) playerDmgTaken = 0;
                     this.currLife -= Math.abs(playerDmgTaken);
                     System.out.println(enemy.name + " took an opportunity to hit");
                     System.out.println(this.name + " took " + Math.abs(playerDmgTaken) + " damage");                  
            }
        } 
        return enemy.currLife;
    }
    public int heal(Enemy enemy){
        Random r = new Random();
        System.out.println("You try to heal");
        if(enemy.hitRate+5 > r.nextInt(20)+1){
            int chanceAtk = (enemy.str/2) + dice.rollD6();
                int playerDmgTaken = chanceAtk - this.defense;
                     int healDmg = Math.abs(playerDmgTaken) - this.heal;
                        System.out.println(enemy.name + " took an opportunity to hit");
                        System.out.println(enemy.name + " dealt " + Math.abs(healDmg));
                        this.heal = healDmg;
                        this.currLife = this.currLife + this.heal;
                        System.out.println("You were able to heal " + this.heal);
                        if(this.currLife >= this.maxLife) this.currLife = this.maxLife;
                        System.out.println(this.name + " HP: " + this.maxLife + "/" + this.currLife);
        }
        else{        
            System.out.println("You heal were able to heal " + this.heal);
            this.currLife = this.currLife + this.heal;
            if(this.currLife >= this.maxLife) this.currLife = this.maxLife;
            System.out.println(this.name + " HP: " + this.maxLife + "/" + this.currLife);
        }
        return this.currLife;
    }
    public String getName(){
        return this.name;
    }
    public int getStrength(){
        return this.str;
    }
    public int getDexterity(){
        return this.dex;
    }
    public int getIntelligence(){
        return this.intel;
    }
    public int getCurrLife(){
        return this.currLife;
    }
    public int getMaxLife(){
        return this.maxLife;
    }
}
