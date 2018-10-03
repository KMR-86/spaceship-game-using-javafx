/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacegame;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import static spacegame.OpponentShip.randomPositionFactor;

/**
 *
 * @author DELL
 */
public class Bullet {

    Image image = ConfigAll.image_bullet;
    ImageView imageView = new ImageView(image);
    Timeline BulletLoop;
    

    public Bullet(Scene scene, Pane root,double x,double y) {

        imageView.setFitHeight(50);
        imageView.setFitWidth(70);
        root.getChildren().add(imageView);
        imageView.setX(ConfigAll.PlayerShipX-x);
        imageView.setY(y);
        BulletLoop = new Timeline(new KeyFrame(Duration.millis(3), new EventHandler<ActionEvent>() {

            @Override
            public void handle(final ActionEvent t) {
                
                if(imageView.getX()==-60){
                   imageView.setY(ConfigAll.PlayerShipY); 
                }
                if (imageView.getX() < 1200) {
                    imageView.setX(imageView.getX() + 1);
                    
                } else {
                    imageView.setX(ConfigAll.PlayerShipX);
                    imageView.setY(ConfigAll.PlayerShipY);
                   
                    
                }

            }
        }));

    }

    public void shoot() {
        BulletLoop.setCycleCount(Timeline.INDEFINITE);
        BulletLoop.play();


    }

}
