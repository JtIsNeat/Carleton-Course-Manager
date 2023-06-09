import java.util.Scanner;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{

        CourseList courseList = new CourseList();  
        Scanner userInput = new Scanner(System.in);
        String tempString = "";
        String fileName = "";

        if(args.length > 0){
            courseList.importData(new File(args[0]));
            fileName = args[0];
        }
        
        while(true){
            switch(View.printMenu()){
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

                case 2:

                    System.out.print("\nNew file name: ");
                    fileName = userInput.nextLine();

                    courseList.importData(new File(fileName));
                    System.out.println();
                    break;

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
                
                case 4:

                    System.out.print("\nPlease specify year level (ex. L1 corresponds to 1000): ");
            
                    tempString = userInput.nextLine();
                    
                    Boolean isValid = false;
                    int j = 0;

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

                    if(!isValid){
                        System.out.println("\nInput is not a valid year level (L1, L2, L3, L4, L5).\n");
                    }
                    
                    break;
                
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
            
                case 6:
                    System.out.println("\nGPA: " + courseList.calculateGPA() + "\n");
                    break;

                case 0:
                userInput.close();
                System.exit(0);
            }
        }
    }

}
