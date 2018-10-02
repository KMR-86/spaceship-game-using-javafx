/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacegame;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

/**
 *
 * @author DELL
 */
public class PlayerShip {

    Image image = ConfigAll.image_PlayerShip;
    ImageView imageView = new ImageView(image);

    public PlayerShip(Pane root, Scene scene) {
        //Image image = new Image(new FileInputStream("C:\\Users\\DELL\\Downloads\\spaceship1.png"));

        //Setting the position of the image 
        imageView.setX(0);
        imageView.setY(350);
        imageView.setFitHeight(80);
        imageView.setFitWidth(150);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (ConfigAll.playerShipMoveFlag == true) {

                    if (event.getCode() == KeyCode.DOWN && imageView.getY() < 550) {
                        imageView.setY(imageView.getY() + 10);
                    }
                    if (event.getCode() == KeyCode.UP && imageView.getY() > -40) {
                        imageView.setY(imageView.getY() - 10);
                    }
                }
            }

        });
        root.getChildren().add(imageView);

    }

}
