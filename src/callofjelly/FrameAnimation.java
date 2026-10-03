package callofjelly;

import java.awt.Image;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * @author Mansoor, Zunair, Vedant Date: Jan 4, 2026
 * @filename FrameAnimation Description: This class is used for our animations.
 */
public class FrameAnimation {

    //A FrameAnimation has
    private String name; // the name of the animation. Used for image loading
    private int currentFrame = 0; // the current frame that this animation is on
    private Image[] frames; // the array of frames
    private boolean looping; //if the animation loops or not
    private boolean animationComplete = false; //used only for non-looping animations

    // The constructor for is used to create the object (one time load)
    public FrameAnimation(String name, int frameCount, boolean looping) {
        this.name = name;
        this.looping = looping;
        this.frames = new Image[frameCount]; // sets up the array to the correct length
        // loops once for each frame to load the frames
        for (int counter = 0; counter < frameCount; counter++) {
            String path = "/callofjelly/images/" + name + "/" + name + "_" + counter + ".png";
            frames[counter] = GameResources.readImage(path);
        } // end of loop
    }// end of constructor

    //This getter is used to advance the animation to the next frame
    public Image getNextFrame() {
        this.currentFrame = this.currentFrame + 1; // move to next frame
        if (this.currentFrame >= this.frames.length) {
            //if we have reached the last frame
            if (this.looping == true) {
                //if we are a looping animation
                this.currentFrame = 0; //go back to start
            } else {
                //if not looping
                this.animationComplete = true;
                this.currentFrame = this.frames.length - 1; // stay at last frame
            }//end of looping check
        }// end of if
        return this.frames[this.currentFrame]; // returns the new frame
    }//end of getNextFrame()

    // GETTERS AND SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public void setCurrentFrame(int currentFrame) {
        this.currentFrame = currentFrame;
    }

    public Image[] getFrames() {
        return frames;
    }

    public void setFrames(Image[] frames) {
        this.frames = frames;
    }

    public boolean isLooping() {
        return looping;
    }

    public void setLooping(boolean looping) {
        this.looping = looping;
    }

    public boolean isAnimationComplete() {
        return animationComplete;
    }

    public void setAnimationComplete(boolean animationComplete) {
        this.animationComplete = animationComplete;
    }

}//end of Frame Animation class
