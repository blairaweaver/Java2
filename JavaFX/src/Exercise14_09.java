import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class Exercise14_09 extends Application{
    @Override
    public void start(Stage primaryStage){

        Circle circle = new Circle(0, 0, 100);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);

        Arc arc1 = new Arc(0, 0, 80, 80, 30, 35); // Create an arc
        arc1.setFill(Color.RED); // Set fill color
        arc1.setType(ArcType.ROUND); // Set arc type

        Arc arc2 = new Arc(0, 0, 80, 80, 30 + 90, 35); // Create an arc
        arc2.setFill(Color.RED); // Set fill color
        arc2.setType(ArcType.ROUND); // Set arc type

        Arc arc3 = new Arc(0, 0, 80, 80, 30 + 180, 35); // Create an arc
        arc3.setFill(Color.RED); // Set fill color
        arc3.setType(ArcType.ROUND); // Set arc type

        Arc arc4 = new Arc(0, 0, 80, 80, 30 + 270, 35); // Create an arc
        arc4.setFill(Color.RED); // Set fill color
        arc4.setType(ArcType.ROUND); // Set arc type

        Circle circle2 = new Circle(0, 0, 100);
        circle2.setStroke(Color.BLACK);
        circle2.setFill(Color.WHITE);

        Arc arc21 = new Arc(0, 0, 80, 80, 30, 35); // Create an arc
        arc21.setFill(Color.RED); // Set fill color
        arc21.setType(ArcType.ROUND); // Set arc type

        Arc arc22 = new Arc(0, 0, 80, 80, 30 + 90, 35); // Create an arc
        arc22.setFill(Color.RED); // Set fill color
        arc22.setType(ArcType.ROUND); // Set arc type

        Arc arc23 = new Arc(0, 0, 80, 80, 30 + 180, 35); // Create an arc
        arc23.setFill(Color.RED); // Set fill color
        arc23.setType(ArcType.ROUND); // Set arc type

        Arc arc24 = new Arc(0, 0, 80, 80, 30 + 270, 35); // Create an arc
        arc24.setFill(Color.RED); // Set fill color
        arc24.setType(ArcType.ROUND); // Set arc type

        Circle circle3 = new Circle(0, 0, 100);
        circle3.setStroke(Color.BLACK);
        circle3.setFill(Color.WHITE);

        Arc arc31 = new Arc(0, 0, 80, 80, 30, 35); // Create an arc
        arc31.setFill(Color.RED); // Set fill color
        arc31.setType(ArcType.ROUND); // Set arc type

        Arc arc32 = new Arc(0, 0, 80, 80, 30 + 90, 35); // Create an arc
        arc32.setFill(Color.RED); // Set fill color
        arc32.setType(ArcType.ROUND); // Set arc type

        Arc arc33 = new Arc(0, 0, 80, 80, 30 + 180, 35); // Create an arc
        arc33.setFill(Color.RED); // Set fill color
        arc33.setType(ArcType.ROUND); // Set arc type

        Arc arc34 = new Arc(0, 0, 80, 80, 30 + 270, 35); // Create an arc
        arc34.setFill(Color.RED); // Set fill color
        arc34.setType(ArcType.ROUND); // Set arc type

        Circle circle4 = new Circle(0, 0, 100);
        circle4.setStroke(Color.BLACK);
        circle4.setFill(Color.WHITE);

        Arc arc41 = new Arc(0, 0, 80, 80, 30, 35); // Create an arc
        arc41.setFill(Color.RED); // Set fill color
        arc41.setType(ArcType.ROUND); // Set arc type

        Arc arc42 = new Arc(0, 0, 80, 80, 30 + 90, 35); // Create an arc
        arc42.setFill(Color.RED); // Set fill color
        arc42.setType(ArcType.ROUND); // Set arc type

        Arc arc43 = new Arc(0, 0, 80, 80, 30 + 180, 35); // Create an arc
        arc43.setFill(Color.RED); // Set fill color
        arc43.setType(ArcType.ROUND); // Set arc type

        Arc arc44 = new Arc(0, 0, 80, 80, 30 + 270, 35); // Create an arc
        arc44.setFill(Color.RED); // Set fill color
        arc44.setType(ArcType.ROUND); // Set arc type


        Group group1 = new Group();
        group1.getChildren().addAll(circle, arc1, arc2, arc3, arc4);

        Group group2 = new Group();
        group2.getChildren().addAll(circle2, arc21, arc22, arc23, arc24);

        Group group3 = new Group();
        group3.getChildren().addAll(circle3, arc31, arc32, arc33, arc34);

        Group group4 = new Group();
        group4.getChildren().addAll(circle4, arc41, arc42, arc43, arc44);

        GridPane gridpane = new GridPane();

        gridpane.add(group1, 0, 0);
        gridpane.add(group2, 1, 1);
        gridpane.add(group3, 0, 1);
        gridpane.add(group4, 1, 0);

        gridpane.setHgap(50);
        gridpane.setVgap(50);

        gridpane.getColumnConstraints().add(new ColumnConstraints(200));
        gridpane.getRowConstraints().add(new RowConstraints(200));

        gridpane.setAlignment(Pos.CENTER);
        Scene scene = new Scene(gridpane, 500, 500);
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
