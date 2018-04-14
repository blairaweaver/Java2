import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Exercise15_02 extends Application {
    private RectanglePane rectanglePane = new RectanglePane();
    @Override
    public void start(Stage primaryStage) {

        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        Button rotate = new Button("Rotate");
        hBox.getChildren().add(rotate);

        rotate.setOnAction(new RotateHandler());

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(rectanglePane);
        borderPane.setBottom(hBox);


        Scene scene = new Scene(borderPane, 200, 150);
        primaryStage.setTitle("Rotate Rectangle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    class RotateHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            rectanglePane.rotate();
        }
    }
}

class RectanglePane extends StackPane {
    private Rectangle rectangle = new Rectangle(25, 10, 60, 30);

    public RectanglePane () {
        getChildren().add(rectangle);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);
    }

    public void rotate() {
        rectangle.setRotate(rectangle.getRotate() + 15);
    }
}
