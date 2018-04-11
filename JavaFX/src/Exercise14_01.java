import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



public class Exercise14_01 extends Application{
    @Override
    public void start(Stage primaryStage) {
//        New GridPane
        GridPane pane = new GridPane();

//        Get new images from internet and set row and column
        ImageView image1 = new ImageView("http://liveexample.pearsoncmg.com/book/image/us.gif");
        GridPane.setConstraints(image1, 0, 0);
        ImageView image2 = new ImageView("http://liveexample.pearsoncmg.com/book/image/ca.gif");
        GridPane.setConstraints(image2, 1, 1);
        ImageView image3 = new ImageView("http://liveexample.pearsoncmg.com/book/image/china.gif");
        GridPane.setConstraints(image3, 1, 0);
        ImageView image4 = new ImageView("http://liveexample.pearsoncmg.com/book/image/fr.gif");
        GridPane.setConstraints(image4, 0, 1);

//        Add all images to gridpane
        pane.getChildren().addAll(image1,image2, image3, image4);

        pane.setAlignment(Pos.CENTER);
//        Create new scene and place it in the stage
        Scene scene = new Scene(pane, 400, 400);
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
