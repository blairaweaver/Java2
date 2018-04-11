import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Arc;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class Exercise14_13 extends Application {
    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 400, 400);

        Arc quiz = new Arc();

//        borderPane.setCenter();

        primaryStage.setTitle("Grade Percentages");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
