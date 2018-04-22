import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import static javafx.animation.Animation.Status.PAUSED;

public class Exercise15_25 extends Application {
    @Override
    public void start (Stage primaryStage) {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 500, 500);

        double centerX = pane.getWidth() / 2;
        double centerY = pane.getHeight() / 2;

        //drawing graph
        drawArrowLine(0, centerY, pane.getWidth(), centerY, pane);
        drawArrowLine(centerX, pane.getHeight(), centerX, 0, pane);
        Polyline sine = new Polyline();
        sine.setStroke(Color.BLUE);
        ObservableList<Double> sineList = sine.getPoints();

        for (int x = -200; x <= 200; x++) {
            sineList.add(x + centerX);
            //            refer to http://jwilson.coe.uga.edu/EMAT6680Fa07/O'Kelley/Assignment%201/Transformations.html
            //            for transformations of the graph
            sineList.add(centerY - (centerY / 2) * Math.sin(x / 25.0));
        }

            //Adding Labels (move to drawSineWave and make more accurate?)
            Text xLabel = new Text(pane.getWidth() - 20, centerY - 20, "X");
            Text yLabel = new Text(centerX + 20, 20, "Y");
            Text origin = new Text(centerX, centerY + 10, "0");
            Text posPi = new Text(centerX + 78, centerY + 10, "\u03c0");
            Text posTwoPi = new Text(centerX + 156, centerY + 10, "2\u03c0");
            Text negPi = new Text(centerX - 78, centerY + 10, "-\u03c0");
            Text negTwoPi = new Text(centerX - 156, centerY + 10, "-2\u03c0");

            //drawing circle
            Circle circle = new Circle(0, 0, 20);
            circle.setStroke(Color.BLACK);
            circle.setFill(Color.GREEN);

            pane.getChildren().addAll(circle, sine, xLabel, yLabel, origin, posPi, posTwoPi, negPi, negTwoPi);

            //path transition
            PathTransition pathTransition = new PathTransition();
            pathTransition.setDuration(Duration.seconds(4));
            pathTransition.setPath(sine);
            pathTransition.setNode(circle);
            pathTransition.setCycleCount(Timeline.INDEFINITE);
//            pathTransition.setAutoReverse(true);
            pathTransition.play();

            pane.setOnMouseClicked(event -> {
                if (pathTransition.getStatus() == PAUSED) {
                    pathTransition.play();
                }
                else {
                    pathTransition.pause();
                }
            });

            primaryStage.setTitle("Sine");
            primaryStage.setScene(scene);
            primaryStage.show();

            pane.requestFocus();
    }

    public static void drawArrowLine(double x1, double y1, double x2, double y2, Pane pane) {
        pane.getChildren().add(new Line(x1, y1, x2, y2));

        // find slope of this line
        double slope = ((((double) y1) - (double) y2))
                / (((double) x1) - (((double) x2)));

        double arctan = Math.atan(slope);

        // This will flip the arrow 45 off of a
        // perpendicular line at pt x2
        double set45 = 1.57 / 2;

        // arrows should always point towards i, not i+1
        if (x1 < x2) {
            // add 90 degrees to arrow lines
            set45 = -1.57 * 1.5;
        }

        // set length of arrows
        int arrlen = 15;

        // draw arrows on line
        pane.getChildren().add(new Line(x2, y2, (x2 + (Math.cos(arctan + set45) * arrlen)),
                ((y2)) + (Math.sin(arctan + set45) * arrlen)));

        pane.getChildren().add(new Line(x2, y2, (x2 + (Math.cos(arctan - set45) * arrlen)),
                ((y2)) + (Math.sin(arctan - set45) * arrlen)));
    }
}
