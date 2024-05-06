import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloWorldFX extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a label with "Hello, World!" text
        Label helloLabel = new Label("Hello, World!");

        // Create a layout pane (StackPane) and add the label to it
        StackPane root = new StackPane();
        root.getChildren().add(helloLabel);

        // Create a scene with the layout pane as root
        Scene scene = new Scene(root, 300, 200);

        // Set the scene to the stage (primary window)
        primaryStage.setScene(scene);

        // Set the title of the stage
        primaryStage.setTitle("Hello World in JavaFX");

        // Show the stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        // Launch the JavaFX application
        launch(args);
    }
}

