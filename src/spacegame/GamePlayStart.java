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

    public GamePlayStart(Scene scene, Pane root) {

        BackGround backGround = new BackGround(root);
        OpponentShip[] opponentShip = new OpponentShip[8];
        
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
                //System.out.println("X" + playerShip.imageView.getX() + " , " + opponentShip.imageView.getX());
                //System.out.println("Y" + playerShip.imageView.getY() + " , " + opponentShip.imageView.getY());
                for (int i = 0; i < 8; i++) {
                    if (isDead(playerShip, opponentShip[i])) {
                        System.out.println("game over");
                        textGameOver.setText("Game Over");
                        for(int j=0;j<8;j++){
                            opponentShip[j].OpponentMoveloop.stop();
                        }
                        ConfigAll.playerShipMoveFlag=false;
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
    static void finishGame(){
        
    }

}
