//features
//the enemy has a chance to attack the player when player has chosen heal
//dodge chance for player

package rpg;

import java.io.*;

public class RPG {

    public static Character player;
    public static Enemy enemy;
    public static BufferedReader br;
    public static void main(String[] args)throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter your name: ");
        String name = br.readLine();

        System.out.println("Press enter to continue: ");
        br.readLine();
        System.out.println("This is a part of a Story");
        System.out.println("");
        Story.chapter1();
        System.out.println("Press enter to continue:");
        br.readLine();
        Story.chapter1Part1();
        System.out.println("");
        
        player = new Character(name,15,10,9,8); 
        enemy = new Enemy("Lion",12,14,7,55,5);
        
        while(enemy.currLife > 0){

            System.out.println(player.name + " Health: " + player.getMaxLife() + "/" + player.getCurrLife());
            System.out.println("What do you want to do?");
            System.out.println("[1]Attack\n"
                    + "[2]Heal");
            System.out.print("Choice: ");
            short choice = Short.parseShort(br.readLine());
            switch(choice){
                case 1:
                    enemy.currLife = player.attack(enemy);
                    break;
                case 2:
                    player.heal(enemy);
                    break;
            }
            System.out.println("==============================================");
            if(enemy.currLife > 0){
                System.out.println(enemy.name + " Health: "+ enemy.maxLife + "/" + enemy.currLife);
                player.currLife = enemy.attack(player);
                if(player.currLife <= 0){
                    System.out.println("You were eaten by the " + enemy.name);
                    System.exit(0);
                }
            }
        }
        System.out.println("Press enter to continue:");
        br.readLine();
        Story.chapter1Part2();
        System.out.println("To be continued");
    }
    
}
