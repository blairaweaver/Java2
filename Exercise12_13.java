import java.io.*;
import java.util.*;

public class Exercise12_13{
	public static void main(String[] args) throws Exception{
		File file = new File(args[0]);
		Scanner input = new Scanner(file);
		String temp;
		String[] tempArray;
		char[] charArray;
		int words = 0;
		int characters = 0;
		int lines = 0;
		while(input.hasNext()){
			//Gets the entire line
			temp = input.nextLine();
			lines++;
			//Converts string into array of words
			tempArray = temp.split(" ");
			words += tempArray.length;
			for (int i = 0; i < tempArray.length; i++){
				charArray = tempArray[i].toCharArray();
				characters += charArray.length;
			}
		}
		
		System.out.println("File " + file + " has");
		System.out.println(characters + " characters");
		System.out.println(words + " words");
		System.out.println(lines + " lines");
	}
}