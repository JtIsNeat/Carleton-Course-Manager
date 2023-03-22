public class Course {
    private String department;
    private int number;
    private GradePointScale grade;
    private Credit credit;

    public Course(String department, int number, Credit credit, GradePointScale grade){
        this.department = department;
        this.number = number;
        this.grade = grade;
        this.credit = credit;
    }

    // Get department
    public String getDepartment(){
        return this.department;
    }

    // Get number
    public int getNumber(){
        return this.number;
    }

    // Get course name
    public String getName(){
        return this.department + " " + this.number;
    }

    // Get course credit value
    public double getCredit(){
        return this.credit.getNumeric();
    }

    // Get course letter grade
    public String getLetterGrade(){
        return this.grade.getLetterGrade();
    }

    // Get course letter grade enum
    public GradePointScale getLetterGradeEnum(){
        return this.grade;
    }

    // Get course grade point
    public double getGradePoint(){
        if(this.credit == Credit.QUARTER){
            return this.grade.getQuarterGradePoint();
        } else if(this.credit == Credit.HALF){
            return this.grade.getHalfGradePoint();
        } else {
            return this.grade.getFullGradePoint();
        }
    }

    // Course string representation
    public String toString(){

        return String.format("%s | %-3s | %.1f | %.1f " , this.getName(), this.getLetterGrade(), getCredit(), getGradePoint());
    }

    public static String compareByDepartment(Course course1, Course course2){
        if(course1.department.compareTo(course2.department) < 0){
            return course1.toString();
        } else {
            return course2.toString();
        }
    }
    
}
