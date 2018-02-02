import java.util.Scanner;
import java.util.*;
import java.lang.*;

public class Main{
    static int groupNumber;
    static int namesNumber;
    static int perGroup;
    static int remainder;
    static String collection[][];
    
    public static void main(String[] args){
        get_group_number();
        get_names_number();
        declare_arrays();
        
        build_list();
      	System.out.println(collection.toString());
    }
    
    public static void build_list(){
        boolean containsRepeat = false;
        while(!containsRepeat){
            for (int i = 0; i < groupNumber; i++ ){
                for (int j = 0; j < perGroup; j++ ){
                    String newName = random_name();
                    if(Arrays.asList(collection).contains(newName)){
                        containsRepeat = true;
                    }else{
                        collection[i][j] = newName;
                    }
                }
            } 
        }
    }
    
    public static String random_name(){
        String name;
        Random rand = new Random();
        int namesIndex = rand.nextInt(namesNumber) + 1;
        switch(namesIndex){
            case 1: name = "Ken"; break;
            case 2: name = "Ellie"; break;
            case 3: name = "Jordan"; break;
            case 4: name = "Max"; break;
            case 5: name = "Jake P"; break;
            case 6: name = "Jacob C"; break;
            case 7: name = "Layla"; break;
            case 8: name = "Liesl"; break;
            case 9: name = "Alexah"; break;
            case 10: name = "Vanessa"; break;
            case 11: name = "Faith"; break;
            case 12: name = "Savannah"; break;
            case 13: name = "Zahara"; break;
            case 14: name = "Jocelyn"; break;
            case 15: name = "Josh"; break;
            case 16: name = "Avery"; break;
            case 17: name = "Ehryn"; break;
            case 18: name = "Sarah"; break;
            case 19: name = "Carlee"; break;
            case 20: name = "Gaven"; break;
            case 21: name = "Griffin"; break;
            case 22: name = "Megan"; break;
            case 23: name = "Morgan"; break;
            case 24: name = "Micah"; break;
            case 25: name = "Katie"; break;
            case 26: name = "Rebekah"; break;
            case 27: name = "Ella"; break;
            case 28: name = "Lorelei"; break;
            default: name = " "; break;
        }
        return name;
    }
    
    public static void declare_arrays(){
        if((groupNumber % namesNumber) == 0){
            perGroup = groupNumber / namesNumber;
        }
        else{
            remainder = groupNumber % namesNumber;
            perGroup = groupNumber / (namesNumber - remainder);
        }
        
        collection = new String[groupNumber][perGroup]; 
    }
    
    public static void get_names_number(){
        boolean pass = false;
        while(!pass){
            try{
                Scanner input = new Scanner(System.in);
                System.out.println("Enter number of people >>>");
                namesNumber = input.nextInt();
                pass = true;
            } catch(Exception e){
                System.out.println("Error, try again");
                pass = false;
            }
        }    
    }
    
    public static void get_group_number(){
        boolean pass = false;
        while(!pass){
            try{
                Scanner input = new Scanner(System.in);
                System.out.println("Enter number of groups >>>");
                groupNumber = input.nextInt();
                pass = true;
            } catch(Exception e){
                System.out.println("Error, try again");
                pass = false;
            }
        }
    }
}