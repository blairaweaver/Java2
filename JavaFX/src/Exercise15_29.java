import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Exercise15_29 extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 500, 500);

        Group car = new Group();

        double segHeight = 30 / 3;
        double segWidth = 50 / 5;

        Rectangle body = new Rectangle(0, 480, 50, segHeight);
        body.yProperty().bind(pane.heightProperty().subtract(2 * segHeight));
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
//        top.translateYProperty().bind(body.yProperty());

//        list.add(50.0);
//        list.add(50.0);
//        list.add(25.0);
//        list.add(25.0);
//        list.add(50.0);
//        list.add(25.0);
//        list.add(25.0);
//        list.add(50.0);

        System.out.println(body.getX() + " " + body.getY());

        car.getChildren().addAll(body, t1, t2, top);
        int count = 1;
        car.setTranslateX(50);
        pane.setOnMouseClicked(event -> {

            car.translateXProperty();
            System.out.println("hello");
        });

        pane.getChildren().add(car);


        primaryStage.setTitle("Color Change");
        primaryStage.setScene(scene);
        primaryStage.show();

        pane.requestFocus();
    }
}
