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
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import static spacegame.OpponentShip.randomPositionFactor;

/**
 *
 * @author DELL
 */
public class BackGround {

    Image image = ConfigAll.bImage;
    ImageView imageView = new ImageView(image);

    Image image2 = ConfigAll.bImage2;
    ImageView imageView2 = new ImageView(image2);

    public static Timeline BackGroundLoop;

    public BackGround(Scene scene, Pane root) {
        imageView.setFitHeight(ConfigAll.SCREEN_HEIGHT);
        imageView.setFitWidth(ConfigAll.SCREEN_WIDTH);
        imageView2.setFitHeight(ConfigAll.SCREEN_HEIGHT);
        imageView2.setFitWidth(ConfigAll.SCREEN_WIDTH);
        imageView.setX(0);
        imageView.setY(0);
        imageView2.setX(1200);
        imageView2.setY(0);

        root.getChildren().add(imageView);
        root.getChildren().add(imageView2);

        BackGroundLoop = new Timeline(new KeyFrame(Duration.millis(3), new EventHandler<ActionEvent>() {

            @Override
            public void handle(final ActionEvent t) {
                if (imageView.getX() > -1195) {
                    imageView.setX(imageView.getX() - 1);
                } else {
                    imageView.setX(1200);

                }
                if (imageView2.getX() > -1195) {
                    imageView2.setX(imageView2.getX() - 1);
                } else {
                    imageView2.setX(1200);

                }
                //System.out.println("x1 : " + imageView.getX());
                //System.out.println("x2 : " + imageView2.getX());
            }
        }));
        BackGroundLoop.setCycleCount(Timeline.INDEFINITE);
        BackGroundLoop.play();

        /*BackgroundImage myBI = new BackgroundImage(new Image(SpaceGame.class.getResourceAsStream("/images/background.png"), ConfigAll.SCREEN_WIDTH, ConfigAll.SCREEN_HEIGHT, true, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
//
        root.setBackground(new javafx.scene.layout.Background(myBI));*/
    }

}
