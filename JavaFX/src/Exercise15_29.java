import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.beans.EventHandler;

import static java.lang.Boolean.TRUE;
import static javafx.animation.Animation.Status.PAUSED;

public class Exercise15_29 extends Application {
    @Override
    public void start(Stage primaryStage) {
        CarPane carPane = new CarPane();
        Scene scene = new Scene(carPane, 500, 500);

        carPane.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.UP) {
                carPane.increaseSpeed();
            }
            else if (event.getCode() == KeyCode.DOWN) {
                carPane.decreaseSpeed();
            }
        });
        carPane.setOnMousePressed(event -> carPane.pause());
        carPane.setOnMouseReleased(event -> carPane.play());

        primaryStage.setTitle("Color Change");
        primaryStage.setScene(scene);
        primaryStage.show();

        carPane.requestFocus();
    }
}

class CarPane extends Pane {
    private double segHeight = 30 / 3;
    private double segWidth = 50 / 5;
    private double x = 0, y = 480;

    private javafx.event.EventHandler<ActionEvent> eventHandler = e -> {
        moveCar();
    };

    private Timeline animation = new Timeline(new KeyFrame(Duration.millis(500), eventHandler));

    public CarPane() {

        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }

    public void pause() {
        animation.pause();
    }

    public void play() {
        animation.play();
    }

    public void increaseSpeed() {
        animation.setRate(animation.getRate() + 0.1);
    }

    public void decreaseSpeed() {
        animation.setRate(animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
    }

    private void paintCar() {
        Rectangle body = new Rectangle(x, y, 50, segHeight);
        body.yProperty().bind(heightProperty().subtract(2 * segHeight));
        body.setFill(Color.GREEN);
        body.setStroke(Color.GREEN);

        Circle t2 = new Circle(segHeight / 2);
        t2.centerXProperty().bind(body.xProperty().add(segWidth * 3.5));
        t2.centerYProperty().bind(body.yProperty().add(segWidth * 1.5));
        t2.setFill(Color.BLACK);
        t2.setStroke(Color.BLACK);

        Circle t1 = new Circle(segHeight / 2);
        t1.centerXProperty().bind(body.xProperty().add(segWidth * 1.5));
        t1.centerYProperty().bind(body.yProperty().add(segWidth * 1.5));
        t1.setFill(Color.BLACK);
        t1.setStroke(Color.BLACK);

        Polygon top = new Polygon();
        top.setStroke(Color.RED);
        top.setFill(Color.RED);
        ObservableList<Double> list = top.getPoints();
        list.add(body.getX() + segWidth);
        list.add(body.getY());
        list.add(body.getX() + segWidth * 2);
        list.add(body.getY() - segHeight);
        list.add(body.getX() + segWidth * 3);
        list.add(body.getY() - segHeight);
        list.add(body.getX() + segWidth * 4);
        list.add(body.getY());

        getChildren().clear();
        getChildren().addAll(body,top,t1,t2);
    }

    protected void moveCar() {
        if (x > getWidth() - 50) {
            x = 0;
        }
        else {
            x += 10;
        }

        paintCar();
    }
}
