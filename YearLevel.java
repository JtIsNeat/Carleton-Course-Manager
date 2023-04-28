public enum YearLevel {
    
    // Constants for course year level
    L1 (1000, 1999),
    L2 (2000, 2999),
    L3 (3000, 3999),
    L4 (4000, 4999),
    L5 (5000, 5999);

    private final int yearLevel;
    private final int max;


    // enum Constructor
    private YearLevel(int yearLevel, int max){
        this.yearLevel = yearLevel;
        this.max = max;
    }

    public int getYearLevel(){
        return yearLevel;
    }

    public int getMin(){
        return yearLevel;
    }

    public int getMax(){
        return max;
    }

}
