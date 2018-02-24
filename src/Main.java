import java.util.Scanner;
import java.util.*;
import java.lang.*;

public class Main{
    static int groupNumber;
    static int namesNumber;
    static int perGroup;
    static int remainder;
    static String namesRaw;
    static String[] namesArray;
    static String collection[][];

    public static void main(String[] args){
        get_group_number();
        get_names();
        if (groupNumber == 0){
            System.out.println(random_name());
        } else {
            declare_arrays();

            build_list();
            if (remainder > 0) {
                distribute_remainder();
            }
            iterate_through_groups();
        }
    }

    public static void iterate_through_groups(){
        for (int i = 0; i < groupNumber; i++) {
            System.out.println("============");
            System.out.println("Group " + (i + 1));
            for (int j = 0; j < collection[i].length; j++) {
                if(collection[i][j] == null){

                }else {
                    System.out.println(collection[i][j]);
                }
            }
        }
    }

    public static boolean array_contains_duplicate(String val){
        for (int i = 0; i < groupNumber; i++) {
            for (int j = 0; j < collection[i].length; j++){
                if (collection[i][j] != null) {
                    if (collection[i][j].equalsIgnoreCase(val)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void distribute_remainder(){
        for (int i = 0; i < remainder; i++) {
            String newName = random_name();
            if (array_contains_duplicate(newName)) {
                i--;
            } else {
                collection[i][perGroup] = newName;
            }
        }
    }

    public static void build_list(){
        if (remainder > 0) {
            perGroup --;
        }
        boolean repeat = true;
        while (repeat) {
            for (int i = 0; i < groupNumber; i++) {
                for (int b = 0; b < perGroup; b++) {
                    String newName = random_name();
                    if (array_contains_duplicate(newName)) {
                        if (b == 0 && i != 0) {
                            b = perGroup - 1;
                            i--;
                        } else {
                            b--;
                        }
                    } else {
                        collection[i][b] = newName;
                        repeat = false;
                    }
                }
            }
        }
    }

    public static String random_name(){
        String name;
        Random rand = new Random();
        int namesIndex = rand.nextInt(namesNumber) + 1;
        name = namesArray[namesIndex - 1];
        return name;
    }

    public static void declare_arrays(){
        if((namesNumber % groupNumber) == 0){
            perGroup = namesNumber / groupNumber;
        }
        else if(namesNumber < groupNumber){
            System.out.println("Less names than there are groups");
        }
        else{
            remainder = namesNumber % groupNumber;
            perGroup = (namesNumber - remainder) / groupNumber;
        }

        if (remainder > 0) {
            perGroup++;
        }
        collection = new String[groupNumber][perGroup];
    }

    public static void get_names(){
        boolean pass = false;
        while(!pass){
            try{
                Scanner input = new Scanner(System.in);
                System.out.println("Enter names, separated by commas >>>");
                namesRaw = input.nextLine();
                namesArray = namesRaw.split("\\s*,\\s*");
                namesNumber = namesArray.length;
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
                System.out.println("Enter number of groups (zero for one random name) >>>");
                groupNumber = input.nextInt();
                pass = true;
                if (groupNumber < 0){
                    pass = false;
                }
            } catch(Exception e){
                System.out.println("Error, try again");
                pass = false;
            }
        }
    }
}