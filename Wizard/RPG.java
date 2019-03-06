//features
//the enemy has a chance to attack the player when player has chosen heal
//dodge chance for player

package rpg;

import java.io.*;

public class RPG {

    public static Character player;
    public static Enemy enemy;
    public static BufferedReader br;
    public static Wizard wizard;
    public static void main(String[] args)throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter your name: ");
        String name = br.readLine();

        System.out.println("Press enter to continue: ");
        br.readLine();
        System.out.println("This is a part of a Story");
        System.out.println("");
        Story.chapter2();
        System.out.println("Press enter to continue:");
        br.readLine();
        Story.chapter2Part1();
        System.out.println("");
        
        wizard = new Wizard(name,10,11,15,8,20); 
        enemy = new Enemy("Fire Elemental",10,10,10,55,5);
        
        while(enemy.currLife > 0){

            System.out.println("Health: " + wizard.getMaxLife() + "/" + wizard.getCurrLife());
            System.out.println("Magic: " + wizard.getMaxMagic() + "/" + wizard.getCurrMagic());
            System.out.println("What do you want to do?");
            System.out.println("[1]Attack\n"
                    + "[2]Lightning bolt\n"
                    + "[3]Heal");
            System.out.print("Choice: ");
            short choice = Short.parseShort(br.readLine());
            switch(choice){
                case 1:
                    enemy.currLife = wizard.attack(enemy);
                    break;
                case 2:
                    wizard.castLightning(enemy);
                    break;
                case 3:
                    wizard.castHeal();                 
            }
            System.out.println("==============================================");
            if(enemy.currLife > 0){
                System.out.println(enemy.name + " Health: "+ enemy.maxLife + "/" + enemy.currLife);
                wizard.currLife = enemy.attack(wizard);
                if(wizard.currLife <= 0){
                    System.out.println("You lose the battle against " + enemy.name);
                    System.exit(0);
                }
            }
        }
        System.out.println("Press enter to continue:");
        br.readLine();
        Story.chapter2Part2();
        System.out.println("To be continued");
    }
    
}
