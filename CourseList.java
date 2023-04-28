import java.util.ArrayList;

public class CourseList extends ArrayList<Course>{

    public CourseList(){

    }

    public double calculateGPA(){

        double totalCredits = 0;
        double totalGradePoints = 0;

        for(Course course : this){

            // Checks if a course was academically withdrawn
            if(course.getLetterGradeEnum() != GradePointScale.WDN){
                totalCredits += course.getCredit();
                totalGradePoints += course.getGradePoint();   
            }
        }

        return totalGradePoints / totalCredits;
    }


}
