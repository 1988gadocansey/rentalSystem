package project.views;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;
import project.controllers.PropertyController;

public class PropertyView extends Application {

    PropertyController pCtrl=null;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Add Property");

        // Create the registration form grid pane
        GridPane gridPane = createRegistrationFormPane();
        // Add UI controls to the registration form grid pane
        addUIControls(gridPane);
        // Create a scene with registration form grid pane as the root node
        Scene scene = new Scene(gridPane, 800, 500);
        // Set the scene in primary stage
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);

        primaryStage.show();
    }


    private GridPane createRegistrationFormPane() {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(10);

        // Set the vertical gap between rows
        gridPane.setVgap(10);

        // Add Column Constraints

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }

    private void addUIControls(GridPane gridPane) {
        // Add Header
        Label headerLabel = new Label("Add Property here");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));


        // Add name Label
        Label nameLabel = new Label("Street Name: ");
        gridPane.add(nameLabel, 0, 1);

        // Add Email Text Field
        TextField nameText = new TextField();
        nameText.setPrefHeight(40);
        gridPane.add(nameText, 1, 1);



        // Add number Label
        Label streetLabel = new Label("Street Number: ");
        gridPane.add(streetLabel, 0,2);

        // Add Number Text Field
        TextField streetField = new TextField();
        streetField.setPrefHeight(40);
        gridPane.add(streetField, 1,2);



        // Add suburb Label
        Label suburbLabel = new Label("Suburb: ");
        gridPane.add(suburbLabel, 0,3);

        // Add suburb Text Field
        TextField suburbField = new TextField();
        suburbField.setPrefHeight(40);
        gridPane.add(suburbField, 1,3);


        // Add property type Label
        Label ptypeLabel = new Label("Property Type: ");
        gridPane.add(ptypeLabel, 0,4);

        // Add property type Text Field
        TextField ptypeField = new TextField();
        ptypeField.setPrefHeight(40);
        gridPane.add(ptypeField, 1,4);



        // Add number of bedroom type Label
        Label numOfBedRoom = new Label("No.of bedrooms: ");
        gridPane.add(numOfBedRoom, 0,5);

        // Add number of bedroom Text Field
        TextField numOfBedRoomField = new TextField();
        numOfBedRoomField.setPrefHeight(40);
        gridPane.add(numOfBedRoomField, 1,5);


        // Add property type Label
        Label statusLabel = new Label("Status: ");
        gridPane.add(statusLabel, 0,6);

        // Add property type Text Field
        TextField statusField = new TextField();
        statusField.setPrefHeight(40);
        gridPane.add(statusField, 1,6);





        // Add Submit Button
        Button submitButton = new Button("Save");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);


        // add clear button
        Button clearButton = new Button("Clear");

        clearButton.setPrefHeight(40);
        clearButton.setDefaultButton(true);
        clearButton.setPrefWidth(100);


        gridPane.add(submitButton, 0, 7, 2, 1);
        gridPane.add(clearButton, 0, 7, 2, 1);

        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setHalignment(clearButton, HPos.RIGHT);

        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));




        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(nameText.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your street name");
                    return;
                }
                if(streetField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your street number");
                    return;
                }

                String sub=suburbField.getText();
                String  street=streetField.getText();
                String status=statusField.getText();
                String name=nameText.getText();

                String pty=ptypeField.getText();

                int room=Integer.parseInt(numOfBedRoomField.getText());


                //showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Registration Successful!", "Welcome " + nameText.getText());

                PropertyController.insert(1,name,sub,name,status,room,pty);
            }
        });



        clearButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                suburbField.setText("");
                streetField.setText("");
                statusField.setText("");
                nameText.setText("");
                statusField.setText("");
                ptypeField.setText("");
                numOfBedRoomField.setText("");


               // showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Registration Successful!", "Welcome " + nameText.getText());
            }
        });




    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}