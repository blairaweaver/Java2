/** First click the Set Exercise button and then 
 *  copy and paste your class named Exercise11_17 here. 
 */

import java.util.*;

public class Exercise11_17 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer m: ");
        int value = input.nextInt();
        int n = findN(value);
        int square = n * value;
        System.out.println("The smallest number n for m x n to be a perfect square is " + n);
        System.out.println("m x n is " + (value * n));
    }

    public static ArrayList<Integer> findFactors(int n){
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 2; i <= n; i++){
            System.out.println("i"+i+"n"+n);
            if(n % i == 0){
                temp.add(i);
                n = n / i;
                i = 1;
            }
        }
        return temp;
    }

    public static int findN(int n){
        ArrayList<Integer> factors = findFactors(n);
        removeDuplicates(factors);
        int sum = 1;
        for(int i = 0; i < factors.size(); i++){
            sum *= factors.get(i);
        }
        return sum;
    }

    public static void removeDuplicates(ArrayList<Integer> list){
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            if(!temp.contains(list.get(i))){
                temp.add(list.get(i));
            }
            else{
                temp.remove(list.get(i));
            }
        }
        list.clear();
        for(int i = 0; i < temp.size(); i++){
            list.add(temp.get(i));
        }
    }
}