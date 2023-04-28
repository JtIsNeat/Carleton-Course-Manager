public enum GradePointScale{

    // Constants which call the enum constructor
    APLUS  ("A+" , 3.0 , 6.0, 12.0),
    A      ("A"  , 2.75, 5.5, 11.0),
    AMINUS ("A-" , 2.5,  5.0, 10.0),
    BPLUS  ("B+" , 2.25, 4.5, 9.0 ),
    B      ("B"  , 2.0,  4.0, 8.0 ),
    BMINUS ("B-" , 1.75, 3.5, 7.0 ),
    CPLUS  ("C+" , 1.5,  3.0, 6.0 ),
    C      ("C"  , 1.25, 2.5, 5.0 ),
    CMINUS ("C-" , 1.0,  2.0, 4.0 ),
    DPLUS  ("D+" , 0.75, 1.5, 3.0 ),
    D      ("D"  , 0.5,  1.0, 2.0 ),
    DMINUS ("D-" , 0.25, 0.5, 1.0 ),
    F      ("F"  , 0.0,  0.0, 0.0 ),
    WDN    ("WDN", 0.0,  0.0, 0.0 );

    private final String letterGrade;
    private final double quarterGradePoint;
    private final double halfGradePoint;
    private final double fullGradePoint;

    // enum Constructor
    private GradePointScale(String letterGrade, double quarterGradePoint, double halfGradePoint, double fullGradePoint){
        this.letterGrade = letterGrade;
        this.quarterGradePoint = quarterGradePoint;
        this.halfGradePoint = halfGradePoint;
        this.fullGradePoint = fullGradePoint;
    }

    public String getLetterGrade(){
        return letterGrade;
    }
    
    public double getQuarterGradePoint(){
        return quarterGradePoint;
    }

    public double getHalfGradePoint(){
        return halfGradePoint;
    }

    public double getFullGradePoint(){
        return fullGradePoint;
    }
}