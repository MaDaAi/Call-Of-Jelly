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
 * @filename ReloadSFX
 * @description a class specifically meant for the Reloading sound
 */
public class ReloadSFX {

    // Fields  
    private static boolean allowCSFX = true;
    private static AudioInputStream ReloadMusic;
    private static Clip ReloadEffect; // Clip used to play title music
    
    public static void loadSound() {
        try {
            //First we load in the sound effects/music.
            ReloadMusic = GameResources.openAudio("/callofjelly/audio/reload.wav");//imports our sound
            ReloadEffect = AudioSystem.getClip();// Create a Clip to hold and control audio playback
            ReloadEffect.open(ReloadMusic);//Open and load the audio into the clip

        } catch (Exception e) {
            System.out.println(e + "Reload file not found");
        }
    }

    public static void play() {
        if (BasicSFXstuff.getSFXtogglevalue() == 0) { // If toggleValue is 0 
            if (ReloadEffect == null) { // If clickEffect is null then return the value 
                return;
            }

            ReloadEffect.setFramePosition(0); //restart the sound back to the beginning of the clip
            ReloadEffect.start(); //plays the clip 
        }

    }
    
    //getters
    public static boolean isAllowCSFX() {
        return allowCSFX;
    }

    public static AudioInputStream getReloadMusic() {
        return ReloadMusic;
    }

    public static Clip getReloadEffect() {
        return ReloadEffect;
    }    
    
    //setters
    public static void setAllowCSFX(boolean allowCSFX) {
        ReloadSFX.allowCSFX = allowCSFX;
    }

    public static void setReloadMusic(AudioInputStream ReloadMusic) {
        ReloadSFX.ReloadMusic = ReloadMusic;
    }

    public static void setReloadEffect(Clip ReloadEffect) {
        ReloadSFX.ReloadEffect = ReloadEffect;
    }
}
