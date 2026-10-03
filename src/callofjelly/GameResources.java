package callofjelly;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Loads game assets from the application classpath so they work both in
 * NetBeans and when the game is launched from its compiled JAR.
 */
public final class GameResources {

    private static boolean fontsRegistered;

    private GameResources() {
    }

    public static URL require(String path) {
        URL resource = GameResources.class.getResource(path);
        if (resource == null) {
            throw new IllegalStateException("Required game resource is missing: " + path);
        }
        return resource;
    }

    public static BufferedImage readImage(String path) {
        try {
            BufferedImage image = ImageIO.read(require(path));
            if (image == null) {
                throw new IllegalStateException("Unsupported image resource: " + path);
            }
            return image;
        } catch (IOException ex) {
            throw new IllegalStateException("Unable to read image resource: " + path, ex);
        }
    }

    public static AudioInputStream openAudio(String path) {
        try {
            return AudioSystem.getAudioInputStream(require(path));
        } catch (IOException | UnsupportedAudioFileException ex) {
            throw new IllegalStateException("Unable to read audio resource: " + path, ex);
        }
    }

    public static synchronized void registerFonts() {
        if (fontsRegistered) {
            return;
        }

        registerFont("/callofjelly/fonts/RoadRage-Regular.ttf");
        registerFont("/callofjelly/fonts/HelpMe.ttf");
        fontsRegistered = true;
    }

    private static void registerFont(String path) {
        try (InputStream input = require(path).openStream()) {
            Font font = Font.createFont(Font.TRUETYPE_FONT, input);
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
        } catch (FontFormatException | IOException ex) {
            throw new IllegalStateException("Unable to load font resource: " + path, ex);
        }
    }
}
