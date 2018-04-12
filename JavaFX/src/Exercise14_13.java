import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise14_13 extends Application {
    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 400, 400);

        double centerX = borderPane.getWidth() / 2;
        double centerY = borderPane.getHeight() / 2;
        double quizLength = 360 * 0.1;
        double projectLength = 360 * 0.2;
        double midtermLength = 360 * 0.3;
        double finalsLength = 360 * 0.4;

        Arc quiz = new Arc(centerX, centerY, 100, 100, 0.0, quizLength);
        quiz.setFill(Color.BLUE);
        quiz.setType(ArcType.ROUND);

        Arc project = new Arc(centerX, centerY, 100, 100, quizLength, projectLength);
        project.setFill(Color.RED);
        project.setType(ArcType.ROUND);

        Arc midterm = new Arc(centerX, centerY, 100, 100, quizLength + projectLength, midtermLength);
        midterm.setFill(Color.DARKGREEN);
        midterm.setType(ArcType.ROUND);

        Arc finals = new Arc(centerX, centerY, 100, 100, 0.0, -finalsLength);
        finals.setFill(Color.GOLDENROD);
        finals.setType(ArcType.ROUND);

        borderPane.getChildren().addAll(quiz, project, midterm, finals, new Text(centerX + 100, centerY - 20, "Quiz -- 10%"),
                new Text(centerX, centerY - 100, "Project -- 20%"), new Text(centerX - 125, centerY, "Midterm -- 30%"),
                new Text(centerX + 25, centerY + 125, "Final -- 40%"));

        primaryStage.setTitle("Grade Percentages");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
