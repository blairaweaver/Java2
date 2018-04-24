import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Text;

public class Exercise16_05 extends Application {
    protected Text text = new Text(50, 50, "JavaFX Programming");
    protected BorderPane getPane() {
        BorderPane pane = new BorderPane();

//        BorderPane paneForTextField = new BorderPane();
        pane.setPadding(new Insets(5, 5, 5, 5));
//        pane.setLeft(new Label("Enter a new message: \n bi: \n hex:"));
//        paneForTextField.setLeft(new Label("2"));
//        paneForTextField.setLeft(new Label("3"));

        VBox test = new VBox(20);
        VBox text = new VBox(30);
        text.getChildren().addAll(new Label("Decimal"),
                new Label("Hexadecimal"),
                new Label("Binary"));

        TextField decimal = new TextField();
//        decimal.setAlignment(Pos.BOTTOM_RIGHT);
//        paneForTextField.setCenter(decimal);


        TextField hexadecimal = new TextField();
//        hexadecimal.setAlignment(Pos.BOTTOM_RIGHT);
//        paneForTextField.setCenter(hexadecimal);

        TextField binary = new TextField();
//        binary.setAlignment(Pos.BOTTOM_RIGHT);
//        paneForTextField.setCenter(binary);
//        pane.setTop(paneForTextField);

        test.getChildren().addAll(decimal, hexadecimal, binary);

        pane.setCenter(test);
        pane.setLeft(text);

        decimal.setOnAction(event -> {
            Integer dec = Integer.parseInt(decimal.getText());
            String hex = dec.toHexString(dec);
            String bin = dec.toBinaryString(dec);

            hexadecimal.setText(hex);
            binary.setText(bin);
        });

        hexadecimal.setOnAction(event -> {
            Integer dec = Integer.parseInt(hexadecimal.getText(), 16);
            String bin = dec.toBinaryString(dec);

            binary.setText(bin);
            decimal.setText(dec.toString());
        });

        binary.setOnAction(event -> {
            Integer dec = Integer.parseInt(binary.getText(), 2);
            String hex = dec.toHexString(dec);

            hexadecimal.setText(hex);
            decimal.setText(dec.toString());
        });

        return pane;
    }

    public void start(Stage primaryStage) {
        // Create a scene and place it in the stage
        Scene scene = new Scene(getPane(), 450, 200);
        primaryStage.setTitle("ButtonDemo"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
}
