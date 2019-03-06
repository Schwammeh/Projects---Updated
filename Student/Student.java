package showstudent;

public class Student {
    
    private String name;
    private int idNum;
    int credits;
    int points;
    double average;
    
    public Student(String name,int idNum,int credits,int points){
        this.name = name;
        this.idNum = idNum;
        this.credits = credits;
        this.points = points;
        this.average = this.points/this.credits;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setIdNum(int idNum){
        this.idNum = idNum;
    }
    public int getIdNum(){
        return this.idNum;
    }
    //sets the credits in objects
    public void setCredits(int credits){
        this.credits = credits;//stores the credits
    }
    //method to retrieve the name from the object
    public int getCredits(){
        return this.credits;//return the value of credits to caller
    }
    public void setPoints(int points){
        this.points = points;
    }
    public int getPoints(){
        return this.points;
    }
    public void getAve(int points,int creds){
        this.average = points/creds;
    }
    public double setAve(){
        return this.average;
    }
    public void display(){
        System.out.println("Student name: " + this.name);
        System.out.println("Student ID number: " + this.idNum);
        System.out.println("Credits earned: " + this.credits);
        System.out.println("Points earned: " + this.points);
        System.out.println("Average: " + this.average);
    }
}
