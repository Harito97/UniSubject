package lab5.b1c7b1c8;

public class MyComplex {
    //Attributes
    private double real = 0.0;
    private double imag = 0.0;

    //Constructors
    public MyComplex(){}

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    //Getters Setters
    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag){
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString(){
        StringBuilder description = new StringBuilder();
        description.append(this.real)
                .append(" + ")
                .append(this.imag)
                .append("*")
                .append("i");
        return description.toString();
    }

    public boolean isReal(){
        if (Double.compare(this.imag, 0.0) == 0){
            return true;
        }
        return false;
    }

    public boolean isImaginary(){
        if (Double.compare(this.real, 0.0) == 0){
            return true;
        }
        return false;
    }

    public boolean equals(double real, double imag){
        if (Double.compare(this.real, real) == 0
            && Double.compare(this.imag, imag) == 0){
            return true;
        }
        return false;
    }

    public boolean equals(MyComplex another){
        if (Double.compare(this.real, another.real) == 0
                && Double.compare(this.imag, another.imag) == 0){
            return true;
        }
        return false;
    }

    public double magnitude(){
        //Module of a complex
        return Math.sqrt(this.real * this.real
                        + this.imag * this.imag);
    }

    public double argument(){
        //La so do goc luong giac cua z = a + bi tren mat phang Oxy
        return Math.atan(this.imag / this.real);
    }
    public MyComplex addInto(MyComplex right){
        this.real += right.real;
        this.imag += right.imag;
        return this;
    }

    public MyComplex addNew(MyComplex right){
        MyComplex output = new MyComplex();
        output.real = this.real + right.real;
        output.imag = this.imag + right.imag;
        return output;
    }

    public MyComplex subtractInto(MyComplex right){
        this.real -= right.real;
        this.imag -= right.imag;
        return this;
    }

    public MyComplex subtractNew(MyComplex right){
        MyComplex output = new MyComplex();
        output.real = this.real - right.real;
        output.imag = this.imag - right.imag;
        return output;
    }

    public MyComplex multiply(MyComplex right){
        double tempReal = this.real * right.real
                - this.imag * right.imag;
        double tempImag = this.real * right.imag
                + this.imag * right.real;
        this.real = tempReal;
        this.imag = tempImag;
        return this;
    }

    public MyComplex divide(MyComplex right){
        double c = this.real;
        double d = this.imag;
        double a = right.real;
        double b = right.imag;
        double tempReal = (a*c + b*d) / (a*a + b*b);
        double tempImag = (a*d - b*c) / (a*a + b*b);
        this.real = tempReal;
        this.imag = tempImag;
        return this;
    }

    public MyComplex conjugate(){
        this.imag = - this.imag;
        return this;
    }
}
