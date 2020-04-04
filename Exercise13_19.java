import java.util.Scanner;
import java.math.*;

public class Exercise13_19 {
  public static void main(String[] args) {
    // Write your code
	Scanner input = new Scanner(System.in);
    System.out.print("Enter a decimal: ");
    String n1 = input.next();
	String[] items = n1.split("\\.");
	
	Rational r1 = new Rational(new BigInteger(items[0]), BigInteger.ONE);
	String d1 = ((int)Math.pow(10, items[1].length())) + "";
	Rational r2 = new Rational(new BigInteger(items[1]), new BigInteger(d1));
	
	System.out.println("The fraction number is " + r1.add(r2));
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
