/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacegame;

import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



/**
 *
 * @author DELL
 */
public class SpaceGame extends Application {

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {

        Pane root = new Pane();
        Scene scene = new Scene(root, ConfigAll.SCREEN_WIDTH, ConfigAll.SCREEN_HEIGHT);
        
        PlayerShip playerShip=new PlayerShip(root, scene);
        
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
