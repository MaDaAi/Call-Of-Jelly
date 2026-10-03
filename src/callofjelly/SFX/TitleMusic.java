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
 * @date Dec 28, 2025
 * @filename TitleMusic
 * @description a class specifically meant for the Music
 *
 */
public class TitleMusic {
    
    //Fields 
    private static AudioInputStream TitleMusic;
    private static Clip MusicEffect; // Clip used to play title music
    private static int musictogglevalue = 0;

    public static void play() {
        if (musictogglevalue == 0) {// If the toggleValue is 0 
            try {
                //First we load in the sound effects/music.
                TitleMusic = GameResources.openAudio("/callofjelly/audio/tittlemusic.wav");//imports our song
                MusicEffect = AudioSystem.getClip();// Create a Clip to hold and control audio playback

                MusicEffect.open(TitleMusic);//Open and load the audio into the clip
                MusicEffect.start(); //plays the clip
                MusicEffect.loop(-1);//This will loop forever once played

            } catch (Exception e) {
                System.out.println(e + "TMusic file not found");
            }
        }

    }

    public static void stop() {
        if (MusicEffect == null) {
            return;
        }

        MusicEffect.stop();
    }

//getters
    public static AudioInputStream getTitleMusic() {
        return TitleMusic;
    }

    public static Clip getMusicEffect() {
        return MusicEffect;
    }

    public static int getMusictogglevalue() {
        return musictogglevalue;
    }

    //setters
    public static void setTitleMusic(AudioInputStream aTitleMusic) {
        TitleMusic = aTitleMusic;
    }

    public static void setMusicEffect(Clip aMusicEffect) {
        MusicEffect = aMusicEffect;
    }

    public static void setMusictogglevalue(int aMusictogglevalue) {
        musictogglevalue = aMusictogglevalue;
    }

}
