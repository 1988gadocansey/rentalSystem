package project;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import project.views.PropertyView;

public class Main extends Application {

    PropertyView pview=null;
    /*@Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("gui.fxml"));
        primaryStage.setTitle("Flexirent System ");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }
*/
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("RentalSystem");

        MenuBar menuBar = new MenuBar();

        VBox vBox = new VBox(menuBar);

        Scene scene = new Scene(vBox, 960, 600);

        Menu home = new Menu("Home");
        Menu apartments = new Menu("Apartments");
        Menu properties = new Menu("Properties");
        Menu rent = new Menu("Rent");
        Menu data = new Menu("Data");
        Menu search = new Menu("Search");
        Menu exit = new Menu("Exit");


        MenuItem addApartment = new MenuItem("Add Apartment");
        MenuItem viewApartments = new MenuItem("View Apartment");

        MenuItem importData = new MenuItem("Import data");
        MenuItem exportData = new MenuItem("Export data");


        apartments.getItems().add(addApartment);
        apartments.getItems().add(viewApartments);


        data.getItems().add(importData);
        data.getItems().add(exportData);



        menuBar.getMenus().add(home);
        menuBar.getMenus().add(apartments);
        menuBar.getMenus().add(properties);
        menuBar.getMenus().add(rent);
        menuBar.getMenus().add(data);
        menuBar.getMenus().add(search);
        menuBar.getMenus().add(exit);


        addApartment.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent t) {

            }

        });





        exit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                System.exit(0);
            }
        });


        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {



            launch(args);

    }
}
