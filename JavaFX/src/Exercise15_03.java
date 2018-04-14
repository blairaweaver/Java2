import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Exercise15_03 extends Application {
    private CirclePane circlePane = new CirclePane();
    @Override
    public void start(Stage primaryStage) {

        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        Button moveUp = new Button("Up");
        Button moveDown = new Button("Down");
        Button moveLeft = new Button("Left");
        Button moveRight = new Button("Right");
        hBox.getChildren().addAll(moveUp, moveDown, moveLeft, moveRight);

        moveUp.setOnAction(new UpHandler());
        moveDown.setOnAction(new DownHandler());
        moveLeft.setOnAction(new LeftHandler());
        moveRight.setOnAction(new RightHandler());

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(circlePane);
        borderPane.setBottom(hBox);

        Scene scene = new Scene(borderPane, 400, 400);
        primaryStage.setTitle("Movable Circle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    class UpHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            circlePane.moveUp();
        }
    }
    class DownHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            circlePane.moveDown();
        }
    }
    class LeftHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            circlePane.moveLeft();
        }
    }
    class RightHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            circlePane.moveRight();
        }
    }
}

class CirclePane extends Pane {
    private Circle circle = new Circle(100, 100, 60);

    public CirclePane () {
        getChildren().add(circle);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
    }

    public void moveUp() {
        if (circle.getCenterY() - 10 > circle.getRadius()) {
            circle.setCenterY(circle.getCenterY() - 10);
        }
    }
    public void moveDown() {
        if (circle.getCenterY() + 10 < getHeight() - circle.getRadius()) {
            circle.setCenterY(circle.getCenterY() + 10);
        }
    }
    public void moveLeft() {
        if (circle.getCenterX() - 10 > circle.getRadius()) {
            circle.setCenterX(circle.getCenterX() - 10);
        }
    }
    public void moveRight() {
        if (circle.getCenterX() + 10 < getWidth() - circle.getRadius()) {
            circle.setCenterX(circle.getCenterX() + 10);
        }
    }
}