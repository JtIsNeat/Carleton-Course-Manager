import java.util.Scanner;

public class View {
    
    static void printError(String s){
        System.out.println(s);
    }

    static void println(String s){
        System.out.println(s);
    }

    static void println(){
        System.out.println();
    }

    public static int printMenu(){

        Scanner scannerObject = new Scanner(System.in);
        int input;
        System.out.println("-----------------------------------");
        System.out.println("OPTION MENU");
        System.out.println("[1] Display all courses");
        System.out.println("[2] Import new data");
        System.out.println("[3] Sort courses by grade");
        System.out.println("[4] Search courses by year level");
        System.out.println("[5] Search courses by department");
        System.out.println("[6] Print GPA");
        System.out.println("[0] Quit");
        System.out.print("\nInput: ");

        if(scannerObject.hasNextInt()){
            input = scannerObject.nextInt();
        } else {
            input = -1;
        }

        System.out.println("-----------------------------------");
        scannerObject = null;
        return input;
    }
}
