import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Exercise15_07 extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Circle circle = new Circle(150, 150, 50);
        circle.centerXProperty().bind(pane.widthProperty().divide(2));
        circle.centerYProperty().bind(pane.heightProperty().divide(2));
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        pane.getChildren().add(circle);

        circle.setOnMousePressed(event -> {
            circle.setFill(Color.BLACK);
        });

        circle.setOnMouseReleased(event -> {
            circle.setFill(Color.WHITE);
        });

        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setTitle("Color Change");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
