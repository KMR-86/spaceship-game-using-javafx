/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacegame;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;
import static spacegame.OpponentShip.randomPositionFactor;

/**
 *
 * @author DELL
 */
public class GamePlayStart {

    Timeline isDeadLoop;

    public GamePlayStart(Scene scene, Pane root) throws InterruptedException {

        BackGround backGround = new BackGround(scene, root);
        OpponentShip[] opponentShip = new OpponentShip[8];
        Bullet[] bullet = new Bullet[12];
        for (int i = 0; i < 12; i++) {
            bullet[i] = new Bullet(scene, root,i*100,ConfigAll.PlayerShipY);

        }
        int c=0;
        for(int i=0;i<12;i++){
            bullet[i].shoot();
            
        }
        for (int i = 0; i < 8; i++) {
            opponentShip[i] = new OpponentShip(scene, root, -100 - (500 * (i % 2)), i * 100);
        }

        PlayerShip playerShip = new PlayerShip(root, scene);

        Text textGameOver = new Text(500, 300, " ");
        textGameOver.prefHeight(100);
        textGameOver.prefWidth(100);
        textGameOver.setStyle("-fx-font: 54 arial;");
        textGameOver.setFill(Color.WHITE);
        root.getChildren().add(textGameOver);

        isDeadLoop = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {

            @Override
            public void handle(final ActionEvent t) {
                for (int i = 0; i < 8; i++) {
                    if (isDead(playerShip, opponentShip[i])) {

                        textGameOver.setText("Game Over");
                        for (int j = 0; j < 8; j++) {
                            opponentShip[j].OpponentMoveloop.stop();
                        }
                        ConfigAll.playerShipMoveFlag = false;
                        BackGround.BackGroundLoop.stop();
                        for (int j = 0; j < 12; j++) {
                            bullet[j].BulletLoop.stop();
                        }
                    }
                }
            }
        }));
        isDeadLoop.setCycleCount(Timeline.INDEFINITE);
        isDeadLoop.play();
    }

    static boolean isDead(PlayerShip p, OpponentShip o) {
        if (o.imageView.getX() <= p.imageView.getX() + 50 && o.imageView.getX() >= p.imageView.getX() - 50 && o.imageView.getY() <= p.imageView.getY() + 50 && o.imageView.getY() >= p.imageView.getY() - 50) {
            return true;
        }
        return false;

    }

    static void finishGame() {

    }

}
