import java.util.*;
import java.lang.*;

public class Exercise12_07{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a binary number: ");
        String binaryString = input.next();
        try{
            System.out.println(bin2Dec(binaryString));
        }
        catch(NumberFormatException ex){
            System.out.println("Not a binary number: "+binaryString);
        }
    }

    public static int bin2Dec(String binaryString) throws NumberFormatException{
        int sum = 0;
        if (!(binaryString.matches("[01]+"))){
            throw new NumberFormatException("Not a binary String");
        }
        else{
            for (int i = 0; i < binaryString.length(); i++){
                if (Character.getNumericValue(binaryString.charAt(i)) == 1){
                    sum += Math.pow(2,binaryString.length()-i-1);
                }
            }
        }
        return sum;
    }
}