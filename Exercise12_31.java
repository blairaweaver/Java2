import java.io.File;
import java.util.*;
import java.net.*;

public class Exercise12_31{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int year;
        String gender;
        String name;
        String URL = "http://liveexample.pearsoncmg.com/data/babynamesranking";
        boolean found = false;
        int lineNumber =0;

        System.out.print("Enter the year: ");
        year = input.nextInt();
        URL = URL + year + ".txt";

        System.out.print("Enter the gender: ");
        gender = input.next();

        System.out.print("Enter the name: ");
        name = input.next();
        String namereg = ".*"+name+".*";

        try{
            URL url = new URL(URL);
            Scanner URLinput = new Scanner(url.openStream());

            while(!found && URLinput.hasNext()){
                String line = URLinput.nextLine();
                if (line.matches(namereg)){
                    found = true;
                    String[] split = line.split(" ");
                    lineNumber = Integer.parseInt(split[0]);
                }

            }
        }
        catch(MalformedURLException ex){
            System.out.println("URL doesn't exist");
        }
        catch(java.io.IOException ex) {
            System.out.println("File does not exist");
        }
        if (!found){
            System.out.println("Name is not ranked");
        }
        else{
            if (gender.matches("M")){
                System.out.println("Boy name "+ name+ " is ranked #"+lineNumber+" in year "+year);
            }
            else {
                System.out.println("Girl name "+ name+ " is ranked #"+lineNumber+" in year "+year);
            }
        }
    }

}