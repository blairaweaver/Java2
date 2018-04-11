import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.geometry.Pos;


public class Exercise14_11 extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 600, 600);

        Polygon triangle = new Polygon();
        triangle.setFill(Color.WHITE);
        triangle.setStroke(Color.BLACK);
        ObservableList<Double> list = triangle.getPoints();

        double centerX = pane.getWidth() / 2;
        double centerY = pane.getHeight() / 2;

        list.add(centerX);
        list.add(centerY - (100 / Math.sqrt(3)));
        list.add(centerX - 50);
        list.add(centerY + ( 100 / (2 * Math.sqrt(3))));
        list.add(centerX + 50);
        list.add(centerY + (100 / ( 2 *  Math.sqrt(3))));

        Circle face = new Circle(centerX, centerY, 200.0);
        face.setStroke(Color.BLACK);
        face.setFill(Color.WHITE);

        Ellipse eye1 = new Ellipse(centerX - 75, centerY - 75, 50,25);
        Ellipse eye2 = new Ellipse(centerX + 75, centerY - 75, 50,25);
        eye1.setStroke(Color.BLACK);
        eye1.setFill(Color.WHITE);
        eye2.setStroke(Color.BLACK);
        eye2.setFill(Color.WHITE);

        Circle iris1 = new Circle(centerX - 75, centerY - 75, 25.0);
        Circle iris2 = new Circle(centerX + 75, centerY - 75, 25.0);
        iris1.setStroke(Color.BLACK);
        iris1.setFill(Color.BLACK);
        iris2.setStroke(Color.BLACK);
        iris2.setFill(Color.BLACK);

        Arc arc1 = new Arc(centerX, centerY + 60, 110, 50, 0, -180); // Create an arc
        arc1.setStroke(Color.BLACK); // Set fill color
        arc1.setType(ArcType.OPEN); // Set arc type
        arc1.setFill(Color.WHITE);

        pane.getChildren().addAll(face, eye1, eye2, iris1, iris2, arc1, triangle);

        primaryStage.setTitle("Smiley Face");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
