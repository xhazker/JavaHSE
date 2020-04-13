public class ComplexNumber {
    private double a;
    private double b;

    public ComplexNumber(){
        this.a = 0;
        this.b = 0;
    }

    public ComplexNumber(double a){
        this.a = a;
        this.b = 0;
    }

    public ComplexNumber(double a, double b){
        this.a = a;
        this.b = b;
    }

    public double getA(){
        return a;
    }

    public double getB(){
        return b;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setValue(ComplexNumber x){
        a = x.getA();
        b = x.getB();
    }

    public ComplexNumber plus(ComplexNumber x){
        double a = this.a + x.a;
        double b = this.b + x.b;
        return new ComplexNumber(a,b);
    }

    public ComplexNumber minus(ComplexNumber x){
        double a = this.a - x.a;
        double b = this.b - x.b;
        return new ComplexNumber(a,b);
    }

    public ComplexNumber multip(ComplexNumber x){
        double a = this.a * x.a - this.b * x.b;
        double b = this.a * x.b + this.b * x.a;
        return new ComplexNumber(a,b);
    }

    public double abs(){
        return Math.sqrt(a*a + b*b);
    }

    public String printTrigon(){
        double z = abs();
        return "z=|" + z + "| * (cos(" + Math.cos(this.a / z) + ") + sin(" +  Math.sin(this.b / z) + ")";
    }

    public String toString(){
        if (b!=0)
            return a + "+" + b + "i";
        else
            return a + "";
    }

}
