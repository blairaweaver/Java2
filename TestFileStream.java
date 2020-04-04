import java.io.*;

 

public class TestFileStream {

  public static void main(String[] args) throws Exception {

    try (

      // Create an output stream to the file

      ObjectOutputStream output = new ObjectOutputStream(

        new FileOutputStream("c:\\temp\\test.dat"));

    ) {

      output.writeObject(new java.util.Date());

     

      // Output values to the file

      for (int i = 1000; i < 1010; i++)

        output.writeDouble(i);

    }

 

    try (

      // Create an input stream for the file

      ObjectInputStream input = new ObjectInputStream(

        new FileInputStream("c:\\temp\\test.dat"));

    ) {

     

      java.util.Date o = (java.util.Date)(input.readObject());

      System.out.println(o);

     

      // Read values from the file

      try {

        for ( ; true; )

          System.out.print(input.readDouble() + " ");

      }

      catch (java.io.EOFException ex) {

        System.out.println("End of file! Done!");

      }

    }

  }

}