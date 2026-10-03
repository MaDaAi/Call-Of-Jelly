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
 * @date Jan 3, 2026
 * @filename EmptyGunSFX
 * @description a class specifically meant for the Empty Gun sound
 */
public class EmptyGunSFX {

    // Fields 
    private static boolean allowCSFX = true;
    private static AudioInputStream EmptyMusic;
    private static Clip EmptyEffect; // Clip used to play title music

    public static void play() {

        if (BasicSFXstuff.getSFXtogglevalue() == 0) { // If the toggleValue is 0 

            try {
                //First we load in the sound effects/music.
                EmptyMusic = GameResources.openAudio("/callofjelly/audio/emptyGun.wav");//imports our sound
                EmptyEffect = AudioSystem.getClip();// Create a Clip to hold and control audio playback
                EmptyEffect.open(EmptyMusic);//Open and load the audio into the clip
                EmptyEffect.start();

            } catch (Exception e) {
                System.out.println(e + "emptyGun file not found");
            }
        }

    }

    //getters
    public static boolean isAllowCSFX() {
        return allowCSFX;
    }

    public static AudioInputStream getEmptyMusic() {
        return EmptyMusic;
    }

    public static Clip getEmptyEffect() {
        return EmptyEffect;
    }

    //setters
    public static void setAllowCSFX(boolean allowCSFX) {
        EmptyGunSFX.allowCSFX = allowCSFX;
    }

    public static void setEmptyMusic(AudioInputStream EmptyMusic) {
        EmptyGunSFX.EmptyMusic = EmptyMusic;
    }

    public static void setEmptyEffect(Clip EmptyEffect) {
        EmptyGunSFX.EmptyEffect = EmptyEffect;
    }
}
