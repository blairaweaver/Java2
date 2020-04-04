/** First click the Set Exercise button and then 
 *  copy and paste your class named Exercise11_15 here. 
 */
 import java.util.*;

public class Exercise11_15 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		ArrayList<Double> coords = new ArrayList<>();
		int total;
		double value;
		System.out.println("Enter the total number of points:");
		total = input.nextInt();
		System.out.println("Enter the coordinates of the points:");
		for(int i = 0; i < 2 * total; i++){
			value = input.nextDouble();
			coords.add(value);
		}
		System.out.println("The total area is " + ConcavePolygons.getArea(coords));
	}
}

class ConcavePolygons{
	public static double firstSum(ArrayList<Double> list){
		double sum = 0;
		for(int i = 0; i < list.size() - 4; i+=2){
			sum = sum + list.get(i) * list.get(i + 3);
		}
		sum = sum + list.get(1) * list.get(list.size() - 2);
		return sum;
	}
	public static double secondSum(ArrayList<Double> list){
		double sum = 0;
		for(int i = 1; i < list.size() - 2; i+=2){
			sum = sum + list.get(i) * list.get(i + 1);
		}
		sum = sum + list.get(0) * list.get(list.size() - 1);
		return sum;
	}
	public static double getArea(ArrayList<Double> list){
		double area = 0.5 * (firstSum(list) - secondSum(list));
		return Math.abs(area);
	}
}