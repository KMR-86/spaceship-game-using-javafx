/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacegame;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;

/**
 *
 * @author DELL
 */
public class BackGround {

    public BackGround(Pane root) {
        
        BackgroundImage myBI = new BackgroundImage(new Image(SpaceGame.class.getResourceAsStream("/images/background.png"), ConfigAll.SCREEN_WIDTH, ConfigAll.SCREEN_HEIGHT, true, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
//
        root.setBackground(new javafx.scene.layout.Background(myBI));
        
    }

}
