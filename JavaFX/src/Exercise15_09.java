import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.Line;


public class Exercise15_09 extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        pane.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP: pane.getChildren().add(new Line(LinePosition.getCurrentX(), LinePosition.getCurrentY(), LinePosition.getCurrentX(), LinePosition.getCurrentY() - 10)); LinePosition.setCurrentY(-10);  break;
                case DOWN: pane.getChildren().add(new Line(LinePosition.getCurrentX(), LinePosition.getCurrentY(), LinePosition.getCurrentX(), LinePosition.getCurrentY() + 10)); LinePosition.setCurrentY(10); break;
                case LEFT: pane.getChildren().add(new Line(LinePosition.getCurrentX(), LinePosition.getCurrentY(), LinePosition.getCurrentX() - 10, LinePosition.getCurrentY())); LinePosition.setCurrentX(-10);  break;
                case RIGHT: pane.getChildren().add(new Line(LinePosition.getCurrentX(), LinePosition.getCurrentY(), LinePosition.getCurrentX()+ 10, LinePosition.getCurrentY())); LinePosition.setCurrentX(10);  break;
            }
        });

        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("Drawing");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        pane.requestFocus();
    }
}

class LinePosition {
    private static double currentX = 200;
    private static double currentY = 200;

    public static double getCurrentX() {
        return currentX;
    }

    public static double getCurrentY() {
        return currentY;
    }

    public static void setCurrentX(double change) {
        currentX += change;
    }

    public static void setCurrentY(double change) {
        currentY += change;
    }
}
