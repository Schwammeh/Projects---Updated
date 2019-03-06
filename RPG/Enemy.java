package rpg;

import java.util.Random;
import static rpg.Character.dice;

public class Enemy {
    static Dice dice = new Dice();
    String name;
    int str;
    int dex;
    int intel;
    int maxLife;
    int currLife;
    int hitRate;
    int defense;
    
   public Enemy(String n,int s,int d,int i,int maxLife,int def){
       Random r = new Random();
       this.name = n;
       this.str = s;
       this.dex = d;
       this.intel = i;
       this.maxLife = maxLife;
       this.currLife = this.maxLife;
       this.hitRate = this.dex;
       this.defense = def;
   } 
   public int attack(Character character){
       Random r = new Random();
       int missRate = r.nextInt(20)+1;
       int atk = (this.str / 2) + dice.rollD6();
       if(this.hitRate > missRate){//hit
           int enemyAtk = atk;
           int playerDmgTaken = enemyAtk - character.defense;
           if(playerDmgTaken <= 0) playerDmgTaken = 0;
               character.currLife -= Math.abs(playerDmgTaken);
               System.out.println(this.name + " attacked");
               System.out.println(character.name + " took " + Math.abs(playerDmgTaken) + " damage");
               
       }
       else{
           System.out.println(this.name + " Attack missed");
           System.out.println("Enemy HP: " + this.currLife);
           if(character.hitRate > r.nextInt(20)+1){
               int chanceAtk = (character.str /2) + dice.rollD6();
               int enemyDmgTaken = chanceAtk - this.defense;
               if(enemyDmgTaken <= 0) enemyDmgTaken = 0;
                    this.currLife -= Math.abs(enemyDmgTaken);
                    System.out.println(character.name + " took an opportunity to hit");
                    System.out.println(this.name + " took " + Math.abs(enemyDmgTaken) + " damage");
                    System.out.println(this.name + " HP: " + this.currLife);    
           }
       }
       return character.currLife;
   }
}
