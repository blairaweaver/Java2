import java.util.Scanner;
import java.math.*;

public class Exercise13_21 {
  public static void main(String[] args) {
    // Write your code here
	//h is -b / (2a) and k is (4ac - b^2) / (4a)
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a, b, c: ");
    int a = input.nextInt();
    int b = input.nextInt();
	int c = input.nextInt();
	
	String hn = (-1 * b) + "";
	String hd = (2 * a) + "";
	String kn = (4 * a * c - (int)Math.pow(b,2)) + "";
	String kd = (4 * a) + "";
	Rational h = new Rational(new BigInteger(hn), new BigInteger(hd));
	Rational k = new Rational(new BigInteger(kn), new BigInteger(kd));
	
	System.out.println("h is " + h + " k is " + k);
	}
}


// Copy from the book
class Rational extends Number implements Comparable<Rational> {
    // Data fields for numerator and denominator
    private BigInteger numerator = BigInteger.ZERO;
    private BigInteger denominator = BigInteger.ONE;

    /** Construct a rational with default properties */
    public Rational() {
        numerator = new BigInteger("0");
        denominator = new BigInteger("1");
    }

    /** Construct a rational with specified numerator and denominator */
    public Rational(BigInteger numerator, BigInteger denominator) {
        BigInteger gcd = numerator.gcd(denominator);
        this.numerator = numerator.multiply(denominator.compareTo(BigInteger.ZERO) > 0 ? BigInteger.ONE : new BigInteger("-1")).divide(gcd);
        this.denominator = denominator.abs().divide(gcd);
    }

    /** Return numerator */
    public BigInteger getNumerator() {
        return numerator;
    }

    /** Return denominator */
    public BigInteger getDenominator() {
        return denominator;
    }

    /** Add a rational number to this rational */
    public Rational add(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator()).add(denominator.multiply(secondRational.getNumerator()));
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    /** Subtract a rational number from this rational */
    public Rational subtract(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator()).subtract(denominator.multiply(secondRational.getNumerator()));
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    /** Multiply a rational number to this rational */
    public Rational multiply(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getNumerator());
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    /** Divide a rational number from this rational */
    public Rational divide(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator());
        BigInteger d = denominator.multiply(secondRational.getNumerator());
        return new Rational(n, d);
    }

    @Override
    public String toString() {
        if (denominator.equals(BigInteger.ONE))
            return numerator + "";
        else
            return numerator + "/" + denominator;
    }

    @Override // Override the equals method in the Object class
    public boolean equals(Object other) {
        if ((this.subtract((Rational)(other))).getNumerator().equals(BigInteger.ZERO))
            return true;
        else
            return false;
    }

    @Override // Implement the abstract intValue method in Number
    public int intValue() {
        return (int)longValue();
    }

    @Override // Implement the abstract floatValue method in Number
    public float floatValue() {
        return (float)longValue();
    }

    @Override // Implement the doubleValue method in Number
    public double doubleValue() {
        return numerator.doubleValue() / denominator.doubleValue();
    }

    @Override // Implement the abstract longValue method in Number
    public long longValue() {
        return (long)doubleValue();
    }

    @Override // Implement the compareTo method in Comparable
    public int compareTo(Rational o) {
        if (this.subtract(o).getNumerator().compareTo(BigInteger.ZERO) > 0)
            return 1;
        else if (this.subtract(o).getNumerator().compareTo(BigInteger.ZERO) < 0)
            return -1;
        else
            return 0;
    }
}
