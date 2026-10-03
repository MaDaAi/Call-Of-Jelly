package callofjelly;

//imports
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

/**
 *
 * @author veda1380, Mansoor, Zunair
 * @date Dec 16, 2025
 * @filename Player
 * @description The Player which extends entity, a class for the player meant
 * for our game.
 */
public class Player extends Entity {

    //Instance variables for movement direction
    private Rectangle hitbox; //Player specific hitbox
    private int xDirection = 0;//Horizontal movement direction(-1 left, 0 none, 1 right)
    private int yDirection = 0;//Vertical movement direction for future proofing

    private Image currentImage; //this will be the image that represents the player
    private int widthPlayer; //currrent width (can be negative for flipping image)
    private boolean facingRight; //direction player is facing(true = right, false = left)    

    // Animation
    private FrameAnimation playeridle; //player idle animation(player standing still)
    private FrameAnimation playerwalking;//player walking animation(moving either left or right)
    private FrameAnimation playerstate; // tracks the current animation state(idle or walking)

    //animation timing variables
    private int timeDelay = 5; // variable used to slow down animations the higher the number the slower animation, is used in draw
    private int currentTime = 0; // tracks how much time has passed since last frame update

    //constructor for player class(inheritance,extends entity and encapsulation private fields)
    //PosX, PosY position(like where it actually is)
    //width and height of image
    //speed is movement 
    public Player(int posX, int posY, int width, int height, int speed) {
        super("Player", 100, posX, posY, speed);
        // Set width and height for the player
        setWidth(width);
        setHeight(height);

        // Create hitbox and assign the players hitbox
        //shares the same propertys as the player(posx,posy,width,height)
        this.hitbox = new Rectangle(posX, posY, width, height);
        setHitBox(this.hitbox); // Set the players hitbox

        // ************************* ANIMATION STUFF HERE **********************
        this.playeridle = new FrameAnimation("idle", 2, true);//meanign there are 2 frames of idle
        this.playerwalking = new FrameAnimation("walking", 16, true);//meaning we have 16 frames of walking
        this.playerstate = this.playeridle;  // defaults to idle
        this.facingRight = true;//defaults to facing right
        this.widthPlayer = width;//default draw width
        this.currentImage = this.playeridle.getNextFrame();//load first frame
    }

    public void move(boolean left, boolean right) {
        //dead players cannot move
        //if the player isnt alive
        if (!isAlive()) {
            return;
        }

        // ALL THE CODE IS RELATIVELY THE SAME BUT ADD MORE COMMENTS 
        //safe guards
        if (this.xDirection != 0 && this.playerstate != this.playerwalking) {//if the player xdirection is not equal 0 and it is not walking
            //only change animation if not already walking and we're moving
            this.playerstate = this.playerwalking; // switch animation state to walking
            this.playerwalking.setCurrentFrame(0);//set it to the first frame of walking
        }

        if (this.xDirection > 0) { // if trying to move right
            setPosX(getPosX() + this.xDirection * getSpeed());//update positon( set posX  the current posX + the direction times his speed)
            this.playerstate = this.playerwalking; // state is walking
            this.facingRight = true;//the player faces right
            setWidthPlayer(getWidth());//Set the player width drawing so that the image is properly oriontated
        } else if (this.xDirection < 0) {// if trying to move left
            setPosX(getPosX() + this.xDirection * getSpeed());//update positon( set posX  the current posX + the direction times his speed)
            this.playerstate = this.playerwalking; // state is walking
            this.facingRight = false;//the player faces left
            setWidthPlayer(-getWidth());//Set the player width drawing to the the inverse to flip the drawing
        } else if (this.xDirection == 0) {//if the xdirection is 0(idle)/ not moving
            // If not moving, go back to idle
            if (this.playerstate != this.playeridle) { //if the player state is not already idle
                this.playeridle.setCurrentFrame(0);//set it to the first frame of idle
                this.playerstate = this.playeridle;// state is idle
            }
        }

        // Update hitbox position to match new player position
        updateHitbox();
    }

    //our visual stuff
    public void draw(Graphics2D g2) {
        this.currentTime = this.currentTime + 1;//increment currentTime
        if (this.currentTime > this.timeDelay) {//if current time is greater than time delay(check if enough frames have passsed to update the animation)
            //if enough time has passed
            this.currentTime = 0;//set current time to 0 to start counter again
            //move to next frame based on the state
            this.currentImage = this.playerstate.getNextFrame();
        }

        // Player is always drawn at center of screen
        if (facingRight) {//if the player is facing right, draw the palyer normally
            g2.drawImage(this.currentImage, 960, this.getPosY(), this.widthPlayer, getHeight(), null);//we use hardcoding because the player will always be at the center of the screen
        } else {
            g2.drawImage(this.currentImage, 960 + getWidth(), this.getPosY(), this.widthPlayer, getHeight(), null);//if its left then the player gets flipped -width so how we add it back so it doesnt mess up
            //positioning just add width
        }

        //testing purposes:
//        // Draw hitbox at screen position (player is fixed at X=960)
//        g2.setColor(Color.red);
//        g2.drawRect(960, getPosY(), this.hitbox.width, this.hitbox.height);
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public int getXDirection() {
        return xDirection;
    }

    public void setXDirection(int xDirection) {
        this.xDirection = xDirection;
    }

    public int getYDirection() {
        return yDirection;
    }

    public void setYDirection(int yDirection) {
        this.yDirection = yDirection;
    }

    public int getWidthPlayer() {
        return widthPlayer;
    }

    public void setWidthPlayer(int widthPlayer) {
        this.widthPlayer = widthPlayer;
    }

    public Image getCurrentImage() {
        return currentImage;
    }

    public void setCurrentImage(Image currentImage) {
        this.currentImage = currentImage;
    }

    public FrameAnimation getIdle() {
        return playeridle;
    }

    public FrameAnimation getWalking() {
        return playerwalking;
    }

    public FrameAnimation getState() {
        return playerstate;
    }

    //method for current player frame animation state
    public void setState(FrameAnimation state) {

        //just in case for any possible bugs you never know
        if (this.playerstate == this.playeridle && state == this.playerwalking) {//check if the player state is idle and the state is changing to walking
            this.playerwalking.setCurrentFrame(0);//reset the walking animation to the first frame
        }
        this.playerstate = state;//update player current state
    }

    public int getTimeDelay() {
        return timeDelay;
    }

    public int getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }

    public void updateHitbox() {

        // update the players hitbox to match entity hitbox
        getHitBox().x = getPosX();
        getHitBox().y = getPosY();

    }

    //getter and setter
    public boolean getFacingRight() {
        return facingRight;
    }

    public void setFacingRight(boolean facingRight) {
        this.facingRight = facingRight;
    }
}// end of Player Class
