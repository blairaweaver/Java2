import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TransitionDemo extends Application {

  @Override // Override the start method in the Application class

  public void start(Stage primaryStage) {

    // Create a pane

    Pane pane = new Pane();

   

    // Create a rectangle

    Rectangle rectangle = new Rectangle(100, 150, 30, 10);

    rectangle.setFill(Color.ORANGE);

   

    pane.getChildren().add(rectangle);

 

    EventHandler<ActionEvent> action = e ->

      {rectangle.setX(rectangle.getX() + 1); };

    Timeline animation = new Timeline(new KeyFrame(Duration.millis(500), action));

    animation.setCycleCount(Timeline.INDEFINITE);

    animation.play();

   

    // Create a scene and place it in the stage

    Scene scene = new Scene(pane, 250, 200);

    primaryStage.setTitle("PathTransitionDemo"); // Set the stage title

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