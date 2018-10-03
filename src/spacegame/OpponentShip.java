/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacegame;

import java.io.FileOutputStream;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 *
 * @author DELL
 */
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class OpponentShip {

    Image image = ConfigAll.image_opponent_Ship;
    ImageView imageView = new ImageView(image);
    public Timeline OpponentMoveloop;

    public OpponentShip(Scene scene, Pane root,int x,int y) {
        imageView.setX(x);
        imageView.setY(y);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        root.getChildren().add(imageView);

        OpponentMoveloop = new Timeline(new KeyFrame(Duration.millis(3), new EventHandler<ActionEvent>() {

            @Override
            public void handle(final ActionEvent t) {
                if(imageView.getX()>-510){
                imageView.setX(imageView.getX() - 1);
                }
               else{
                imageView.setX(1200);
                imageView.setY(randomPositionFactor());
                }
                
            }
        }));
        OpponentMoveloop.setCycleCount(Timeline.INDEFINITE);
        OpponentMoveloop.play();

    }

    public static int randomSpeedFactor() {

        return ThreadLocalRandom.current().nextInt(1, 10);
    }

    public static int randomPositionFactor() {

        return ThreadLocalRandom.current().nextInt(50, 510);
    }

}
