import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

public class Exercise16_01 extends Application {
    protected Text text = new Text(50, 50, "JavaFX Programming");

    protected BorderPane getPane() {
        HBox paneForButtons = new HBox(20);
        Button btLeft = new Button("Left", new ImageView("left.gif"));
        Button btRight = new Button("Right", new ImageView("right.gif"));
        paneForButtons.getChildren().addAll(btLeft, btRight);
        paneForButtons.setAlignment(Pos.CENTER);
        paneForButtons.setStyle("-fx-border-color: green");

        BorderPane pane = new BorderPane();
        pane.setBottom(paneForButtons);

        Pane paneForText = new Pane();
        paneForText.getChildren().add(text);
        pane.setCenter(paneForText);

        btLeft.setOnAction(e -> text.setX(text.getX() - 10));
        btRight.setOnAction(e -> text.setX(text.getX() + 10));

        HBox paneForRadioButtons = new HBox(20);
        paneForRadioButtons.setPadding(new Insets(5, 5, 5, 5));
        paneForRadioButtons.setStyle("-fx-border-width: 2px; -fx-border-color: green");

        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbYellow = new RadioButton("Yellow");
        RadioButton rbBlack = new RadioButton("Black");
        RadioButton rbOrange = new RadioButton("Orange");
        RadioButton rbGreen = new RadioButton("Green");
        paneForRadioButtons.getChildren().addAll(rbRed, rbYellow, rbBlack, rbOrange, rbGreen);
        pane.setTop(paneForRadioButtons);

        ToggleGroup group = new ToggleGroup();
        rbRed.setToggleGroup(group);
        rbGreen.setToggleGroup(group);
        rbYellow.setToggleGroup(group);
        rbBlack.setToggleGroup(group);
        rbOrange.setToggleGroup(group);

        rbRed.setOnAction(e -> {
            if (rbRed.isSelected()) {
                text.setFill(Color.RED);
            }
        });

        rbYellow.setOnAction(e -> {
            if (rbYellow.isSelected()) {
                text.setFill(Color.YELLOW);
            }
        });

        rbBlack.setOnAction(e -> {
            if (rbBlack.isSelected()) {
                text.setFill(Color.BLACK);
            }
        });
        rbOrange.setOnAction(e -> {
            if (rbOrange.isSelected()) {
                text.setFill(Color.ORANGE);
            }
        });

        rbGreen.setOnAction(e -> {
            if (rbGreen.isSelected()) {
                text.setFill(Color.GREEN);
            }
        });

        return pane;
    }

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a scene and place it in the stage
        Scene scene = new Scene(getPane(), 450, 200);
        primaryStage.setTitle("ButtonDemo"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}