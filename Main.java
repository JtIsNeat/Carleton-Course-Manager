import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {

    // Calculates the GPA given an array of courses
    public static double calculateGPA(ArrayList<Course> courses){
        double totalCredits = 0;
        double totalGradePoints = 0;

        for(Course course : courses){

            // Checks if a course was academically withdrawn
            if(course.getLetterGradeEnum() != GradePointScale.WDN){
                totalCredits += course.getCredit();
                totalGradePoints += course.getGradePoint();   
            }
        }

        return totalGradePoints / totalCredits;
    }
    
    // Prints the menu options for the user
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

    public static void populateCourseList(ArrayList<Course> courseList, File data) throws Exception{

        // check if file exists
        if(!(data.exists() && !data.isDirectory())){
            System.out.println("\n[!] The file you specified does not exist. [!]\n");
            return;
        }

        // Clear current list
        courseList.clear();

        // scans current data file
        Scanner sc = new Scanner(data);

        // stores current line of file being read
        String[] currentLine;

        // Populate arraylist
        while(sc.hasNextLine()){

            // get next line
            currentLine = sc.nextLine().split(" ");

            // add course to list
            courseList.add(new Course(currentLine[0], Integer.parseInt(currentLine[1]), Credit.valueOf(currentLine[2]) , GradePointScale.valueOf(currentLine[3])));
        }

        // Close scanner
        sc.close();

    }

    public static void main(String[] args) throws Exception{

        /*Object Declarations */

        ArrayList<Course> courseList = new ArrayList<>();  //array of current course data
        Scanner userInput = new Scanner(System.in);        // scans user input for new data file


        // populate courseList if a file was specified as a command-line argument
        if(args.length > 0){
            
            // populate courseList
            populateCourseList(courseList, new File(args[0]));
        }

        // Some variables to keep track of data        
        String tempString;
        String fileName;
        
        if(args.length > 0){
            fileName = args[0];
        } else {
            fileName = "";
        }


        // Main program
        while(true){

            switch(printMenu()){

                // Display all courses
                case 1:

                    if(courseList.size() == 0){
                        System.out.println("\nFile is empty or not specified.\n");
                    } else {
                        System.out.println("\nAll courses listed in file \"" + fileName + "\":\n");

                        for(Course course : courseList){
                            System.out.println(course.toString());
                        } 
                        System.out.println();
                    }
                    
                    break;

                // Import a different data file
                case 2:

                    // Get file name
                    System.out.print("\nNew file name: ");
                    fileName = userInput.nextLine();

                    // Populate courseList
                    populateCourseList(courseList, new File(fileName));
                    System.out.println();
                    break;

                // Sort courses by grade
                case 3:

                    System.out.println("\nDisplaying all courses by grade in descending order:\n");
                    for(GradePointScale grade : GradePointScale.values()){
                        for(Course course : courseList){
                            if(course.getLetterGradeEnum() == grade){
                                System.out.println(course.toString());
                            }
                        }
                    }

                    System.out.println();
                    break;
                
                // Search courses by year level
                case 4:

                    System.out.print("\nPlease specify year level (ex. L1 corresponds to 1000): ");
            
                    // store input
                    tempString = userInput.nextLine();
                    
                    Boolean isValid = false;
                    int j = 0;

                    // check if input is valid
                    for(YearLevel yearLevel : YearLevel.values()){
                        if(tempString.equalsIgnoreCase(yearLevel.name())){

                            isValid = true;

                            System.out.println("\nDisplaying results for level " + yearLevel.getYearLevel() + " courses:\n");
                            for(Course course : courseList){
                                if(yearLevel.getMin() <= course.getNumber() && course.getNumber() <= yearLevel.getMax()){
                                    System.out.println(course.toString());
                                    j += 1;
                                }
                            }

                            if(j == 0){
                                System.out.println("No courses of the specified level exist.\n");
                            } else {
                                System.out.println();
                            }
                        }
                    }

                    // print when input is not valid
                    if(!isValid){
                        System.out.println("\nInput is not a valid year level (L1, L2, L3, L4, L5).\n");
                    }
                    
                    break;
                
                // Search courses by department
                case 5:
                    System.out.print("\nPlease specify department (ex. COMP, MATH): ");
                    tempString = userInput.nextLine();
                    System.out.println("\nDisplaying results for \"" + tempString + "\":\n");

                    int i = 0;
                    for(Course course : courseList){
                        if(course.getDepartment().equals(tempString)){
                            System.out.println(course.toString());
                            i += 1;
                        }
                    }

                    if(i == 0){
                        System.out.println("No courses of the specified department exist or department does not exist.\n");
                    } else {
                        System.out.println();
                    }

                    break;
            
                // Print GPA
                case 6:
                    System.out.println("\nGPA: " + calculateGPA(courseList) + "\n");
                    break;

                // Quit
                case 0:
                userInput.close();
                System.exit(0);
            }
        }
        
    }
}
