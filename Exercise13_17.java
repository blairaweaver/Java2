import java.util.Scanner;


public class Exercise13_17 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the first complex number: ");
    double a = input.nextDouble();
    double b = input.nextDouble();
    Complex c1 = new Complex(a, b);

    System.out.print("Enter the second complex number: ");
    double c = input.nextDouble();
    double d = input.nextDouble();
    Complex c2 = new Complex(c, d);

    System.out.println("(" + c1 + ")" + " + " + "(" + c2 + ")" + " = " + c1.add(c2));
    System.out.println("(" + c1 + ")" + " - " + "(" + c2 + ")" + " = " + c1.subtract(c2));
    System.out.println("(" + c1 + ")" + " * " + "(" + c2 + ")" + " = " + c1.multiply(c2));
    System.out.println("(" + c1 + ")" + " / " + "(" + c2 + ")" + " = " + c1.divide(c2));
    System.out.println("|" + c1 + "| = " + c1.abs());
    
    Complex c3 = (Complex)c1.clone();
    System.out.println(c1 == c3);
    System.out.println(c3.getRealPart());
    System.out.println(c3.getImaginaryPart());
    Complex c4 = new Complex(4, -0.5);
    Complex[] list = {c1, c2, c3, c4};
    java.util.Arrays.sort(list);
    System.out.println(java.util.Arrays.toString(list));
  }
}

class Complex implements Cloneable, Comparable<Complex>{
	private double a = 0;
	private double b = 0;
	
	public Complex(){
		
	}
	
	public Complex(double a){
		this.a = a;
	}
	
	public Complex(double a, double b){
		this.a = a;
		this.b = b;
	}

	public double getRealPart(){
		return this.a;
	}
	
	public double getImaginaryPart(){
		return this.b;
	}
	
	public String add(Complex c){
		return (this.a + c.getRealPart()) + " + " + (this.b + c.getImaginaryPart()) + "i";
	}
	
	public String subtract(Complex c){
		return (this.a - c.getRealPart()) + " + " + (this.b - c.getImaginaryPart()) + "i";
	}

	public String multiply(Complex c){
		return (this.a * c.getRealPart() - this.b * c.getImaginaryPart()) + " + " + (this.b * c.getRealPart() + this.a * c.getImaginaryPart()) + "i";
	}

	public String divide(Complex c){
		return ((this.a * c.getRealPart() + this.b * c.getImaginaryPart()) / (Math.pow(c.getRealPart(),2) + Math.pow(c.getImaginaryPart(),2))) + " + " 
			+ ((this.b * c.getRealPart() - this.a * c.getImaginaryPart()) / (Math.pow(c.getRealPart(),2) + Math.pow(c.getImaginaryPart(),2))) + "i";
	}

	public double abs(){
		return Math.sqrt(Math.pow(this.a, 2) + Math.pow(this.b, 2));
	}
	
	@Override
	public String toString() {
		if (b == 0){
			return this.a + "";
		}
		else{
			return this.a + " + " + this.b + "i";
		}
	}
	
	@Override /** Override the protected clone method defined in 
    the Object class, and strengthen its accessibility */
	public Object clone() {
		try {
			return super.clone();
		}
		catch (CloneNotSupportedException ex) {
			return null;
		}
	}
	
	@Override
	public int compareTo(Complex c){
		if (this.abs() > c.abs())
			return 1;
		else if (this.abs() < c.abs())
			return -1;
		else
			return 0;
	}
}