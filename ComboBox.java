import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ComboBoxSelection extends Application {
    int count = 3;


    public void start(Stage primaryStage) {
       /* Stage errorStage = new Stage();
        Scene errorScene = new Scene(new Pane());
        errorStage.setScene(errorScene);*/
        Alert errorOutput = new Alert(Alert.AlertType.ERROR);
        Alert welcomeOutput = new Alert(Alert.AlertType.INFORMATION);
       /* errorOutput.initOwner(errorStage);*/
        TextField username = new TextField();
        TextField password = new TextField();
        Label output = new Label();
        String access = "";

        final ComboBox<String> cbo = new ComboBox<>();
        cbo.getItems().addAll("Administrator", "Faculty", "Staff", "Student", "Guest");
        cbo.getSelectionModel().selectFirst();

        FlowPane pane = new FlowPane();
        pane.setPadding(new Insets(1, 1, 1, 1));
        pane.setHgap(5);
        pane.setVgap(5);
        pane.getChildren().addAll(new Label("Username"), username, new Label("ACCESS"), cbo);
        pane.getChildren().addAll(new Label("Password "), password);

        Scene scene = new Scene(pane, 500, 200);
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();

        Button submit = new Button("Submit");
        submit.setPrefWidth(200);
        pane.getChildren().add(submit);
        pane.getChildren().add(output);


        submit.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    String access = "";

                    switch (cbo.getValue()) {
                        case "Administrator":
                            access = "Administrator";
                            break;
                        case "Faculty":
                            access = "Faculty";
                            break;
                        case "Staff":
                            access = "Staff";
                            break;
                        case "Student":
                            access = "Student";
                            break;
                        case "Guest":
                            access = "Guest";
                            break;

                    }
                    if (username.getText().equals("William") && password.getText().equals("password")) {
                        output.setText("Welcome " + access);
                        primaryStage.hide();
                        welcomeOutput.setContentText("Welcome "+ access);
                        welcomeOutput.showAndWait();
                    } else {
                        output.setText("Wrong Username or Password");
                        count--;

                    }
                    if (count==0){
                        primaryStage.hide();
                        errorOutput.setContentText("Please Contact Administration");
                        errorOutput.setHeaderText("Unable To Access Due to Multiple Attempts");
                        errorOutput.showAndWait();


                    }


                }

            });



        /*int count = 3;
        while (count>0) {
            if (username.getText().equals("William") && password.getText().equals("password")) {
                count = -1;
                output.setText("Welcome " + access);
            } else {
                count--;
                output.setText("Wrong Username or Password");
            }
            if (count == 0) {
                output.setText("Please Contact Administration");
            }
        }*/

    }
}
