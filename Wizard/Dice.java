package rpg;

import java.util.Random;

public class Dice {
    private Random r;
    
    public Dice(){
        r = new Random();
    }
    public int rollD6(){
        int roll = r.nextInt(6)+1;
        return roll;
    }
}
