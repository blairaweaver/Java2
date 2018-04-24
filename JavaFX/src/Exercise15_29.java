import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
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

        carPane.setOnKeyPressed(event -> );
        carPane.setOnKeyReleased(event -> );
        carPane.setOnKeyTyped(event -> );


        car.getChildren().addAll(body, t1, t2, top);
        int count = 1;
        car.setTranslateX(1);

        pane.getChildren().add(car);

        javafx.event.EventHandler<ActionEvent> action = e -> {
//            car.translateXProperty();
            System.out.println("hey");
            body.setX(body.getX() + 1);
        };

        Timeline animation = new Timeline(new KeyFrame(Duration.millis(500), action));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();


        primaryStage.setTitle("Color Change");
        primaryStage.setScene(scene);
        primaryStage.show();

        pane.requestFocus();
    }
}

class CarPane extends Pane {
    private double segHeight = 30 / 3;
    private double segWidth = 50 / 5;

    private javafx.event.EventHandler<ActionEvent> eventHandler = e -> {

    }

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

    public void changeStatus() {
        if (animation.getStatus() == PAUSED) {
            play();
        }
        else pause();
    }

    private void paintCar() {
        Rectangle body = new Rectangle(0, 480, 50, segHeight);
        body.yProperty().bind(pane.heightProperty().subtract(2 * segHeight));
    }



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
}
