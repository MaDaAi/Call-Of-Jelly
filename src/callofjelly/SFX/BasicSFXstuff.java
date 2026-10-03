/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package callofjelly.SFX;

import callofjelly.GameResources;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author mans5320, zunair, vedant
 * @date Jan 3 2026
 * @filename BasicSFXstuff
 * @description a class specifically meant for the basic sfx stuff like having the toggle option originated here for sfx and the
 * Clicking sound. basically the basic stuff that we have is on here for sfx.
 */
public class BasicSFXstuff {

    // Fields 
    private static boolean allowCSFX = true;
    private static AudioInputStream ClickMusic;
    private static Clip ClickEffect; // Clip used to play title music
    private static int SFXtogglevalue = 0;

    public static void loadSound() {
        try {
            //First we load in the sound effects/music.
            ClickMusic = GameResources.openAudio("/callofjelly/audio/click.wav");//imports our sound
            ClickEffect = AudioSystem.getClip();// Create a Clip to hold and control audio playback
            ClickEffect.open(ClickMusic);//Open and load the audio into the clip

        } catch (Exception e) {
            System.out.println(e + "TMusic file not found");
        }
    }

    public static void play() {
        if (SFXtogglevalue == 0) { // If the toggleValue is 0 
            if (ClickEffect == null) { // If clickEffect is null then return the value 
                return;
            }

            ClickEffect.setFramePosition(0); //restart the sound back to the beginning of the clip
            ClickEffect.start(); //plays the clip 
        }

    }
    
    
    //getters

    public static boolean isAllowCSFX() {
        return allowCSFX;
    }

    public static AudioInputStream getClickMusic() {
        return ClickMusic;
    }

    public static Clip getClickEffect() {
        return ClickEffect;
    }

    public static int getSFXtogglevalue() {
        return SFXtogglevalue;
    }
    
    
    
    //setters

    public static void setAllowCSFX(boolean allowCSFX) {
        BasicSFXstuff.allowCSFX = allowCSFX;
    }

    public static void setClickMusic(AudioInputStream ClickMusic) {
        BasicSFXstuff.ClickMusic = ClickMusic;
    }

    public static void setClickEffect(Clip ClickEffect) {
        BasicSFXstuff.ClickEffect = ClickEffect;
    }

    public static void setSFXtogglevalue(int SFXtogglevalue) {
        BasicSFXstuff.SFXtogglevalue = SFXtogglevalue;
    }
    
    
    
    
    

}
