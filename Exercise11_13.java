/** First click the Set Exercise button and then 
 *  copy and paste your class named Exercise11_13 here. 
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise11_13 {
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        System.out.println("Enter 10 integers.");
        int value;


        for(int i = 0; i < 10; i++){
            value = input.nextInt();
            list.add(value);
        }
        removeDuplicates(list);
        for(int i = 0; i < list.size() - 1; i++){
            System.out.print(list.get(i) + " ");
        }
    }

    public static void removeDuplicates(ArrayList<Integer> list){
        for(int i = 0; i < list.size() - 1; i++){
            for(int r = i+1; r < list.size() - 1; r++){
                if(list.get(i) == list.get(r)){
                    list.remove(r);
                    r--;
                    i--;
                }
            }
        }
    }
}