public enum Credit{
    QUARTER (0.25),
    HALF    (0.5 ),
    FULL    (1.0);

    double numeric;

    private Credit(double numeric){
        this.numeric = numeric;
    }

    public double getNumeric(){
        return this.numeric;
    }
}