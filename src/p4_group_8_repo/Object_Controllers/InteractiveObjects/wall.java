package p4_group_8_repo.Object_Controllers.InteractiveObjects;

import javafx.scene.image.Image;
import p4_group_8_repo.Object_Controllers.Actor;

/***
 * This function is to set and control the Walls
 */
public class wall extends Actor {
    /***
     * Override act in Actor
     * @param now current time
     */
    @Override
    public void act(long now) {
        // TODO Auto-generated method st
    }

    /***
     * set the position of the wall
     * @param xpos set the X position of the wall
     * @param ypos set the Y position of the wall
     * @param w set the width of the wall
     * @param h set the height of the wall
     */
    public wall(int xpos, int ypos,int w, int h) {
        setX(xpos);
        setY(ypos);
        setImage(new Image("file:src/p4_group_8_repo/Assets/FrogImagePosition/wall.png", w,h, false, true));
    }
}
