import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CourseList extends ArrayList<Course>{

    public double calculateGPA(){

        double totalCredits = 0;
        double totalGradePoints = 0;

        for(Course course : this){
            if(course.getLetterGradeEnum() != GradePointScale.WDN){
                totalCredits += course.getCredit();
                totalGradePoints += course.getGradePoint();   
            }
        }

        return totalGradePoints / totalCredits;
    }

    public boolean importData(File file) throws FileNotFoundException{

        if(!(file.exists() && !file.isDirectory())){
            System.out.println("\n[!] The file you specified does not exist. [!]\n");
            return false;
        }

        this.clear();

        Scanner sc = new Scanner(file);

        String[] currentLine;
        while(sc.hasNextLine()){
            currentLine = sc.nextLine().split(" ");
            this.add(new Course(currentLine[0], Integer.parseInt(currentLine[1]), Credit.valueOf(currentLine[2]) , GradePointScale.valueOf(currentLine[3])));
        }

        sc.close();

        return true;
    }

}
