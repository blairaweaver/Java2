import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.*;
import javafx.scene.Group;

public class Exercise14_03 extends Application{
    @Override
    public void start(Stage primaryStage){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < 53; i++) {
            list.add(new Integer(i));
        }

        Collections.shuffle(list);

        ImageView imageview1 = new ImageView("http://liveexample.pearsoncmg.com/book/image/card/" + list.get(0) + ".png");
        ImageView imageview2 = new ImageView("http://liveexample.pearsoncmg.com/book/image/card/" + list.get(1) + ".png");
        ImageView imageview3 = new ImageView("http://liveexample.pearsoncmg.com/book/image/card/" + list.get(3) + ".png");

        GridPane.setConstraints(imageview1, 0, 0);
        GridPane.setConstraints(imageview2, 1, 0);
        GridPane.setConstraints(imageview3, 2, 0);

//        Group group = new Group();
        GridPane gridpane = new GridPane();
        gridpane.getChildren().addAll(imageview1, imageview2, imageview3);
//        gridpane.setValignment(imageview2, VPos.CENTER);
//        gridpane.setHalignment(imageview2, HPos.CENTER);

        Scene scene = new Scene(gridpane, 400, 400);
        primaryStage.setTitle("Test"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
