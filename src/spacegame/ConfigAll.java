/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacegame;

import javafx.scene.image.Image;

/**
 *
 * @author DELL
 */
class ConfigAll {

    public static int SCREEN_WIDTH = 1200;
    public static int SCREEN_HEIGHT = 650;
    public static Image image_PlayerShip = new Image(SpaceGame.class.getResourceAsStream("/images/spaceship2.png"));
    public static Image image_opponent_Ship = new Image(SpaceGame.class.getResourceAsStream("/images/opponentShip.png"));        
    public static Image bImage=new Image(SpaceGame.class.getResourceAsStream("/images/background.png"));
    public static Image bImage2=new Image(SpaceGame.class.getResourceAsStream("/images/background.png"));
    public static Image image_bullet=new Image(SpaceGame.class.getResourceAsStream("/images/missile.png"));

    public static boolean playerShipMoveFlag=true;
    public static double PlayerShipX=0;
    public static double PlayerShipY=350;
    
}
