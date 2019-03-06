package showstudent;

import java.io.*;

public class ShowStudent {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Enter name of student: ");
        String name = br.readLine();
        
        System.out.print("Enter the ID Number: ");
        int idNum = Integer.parseInt(br.readLine());
        
        System.out.print("Enter Credits: ");
        int creds = Integer.parseInt(br.readLine());
        
        System.out.print("Enter Points: ");        
        int points = Integer.parseInt(br.readLine());
        
        Student st1 = new Student(name,idNum,creds,points);
        st1.display();
    }
    
}
