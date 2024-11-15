import javax.swing.JFrame;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;


public class music extends JFrame {
    public static JFrame frame;
    public static Clip clip, sfx;
    music(String path){
        frame = new JFrame("Music player");
        frame.setSize(100,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void togglebkg(String path) {
        if (database.muted) {
            System.out.println("Audio is Muted");
            if (clip != null) {  // Ensure clip is initialized
                clip.stop();
            }
        } else {
            if (path.equals("stop")) {
                if (clip != null) {  // Ensure clip is initialized
                    clip.stop();
                }
            } else {
                try {
                    // Print the raw path passed to the method
                    System.out.println("Raw path passed: " + path);
    
                    // Print current working directory to confirm
                    System.out.println("Current working directory: " + System.getProperty("user.dir"));
    
                    // Adjust path construction: Don't prefix 'Audio/' if it's already included in the path
                    // We will check if 'Audio' is part of the path, and if so, don't add it again.
                    File musicPath = new File(path);
    
                    // If 'Audio' is part of the path, don't add 'Audio/' again
                    if (!path.startsWith("Audio/")) {
                        musicPath = new File("Audio/" + path);
                    }
    
                    // Print the absolute path for debugging
                    System.out.println("Absolute path: " + musicPath.getAbsolutePath());
    
                    // Check if the file exists
                    if (musicPath.exists()) {
                        AudioInputStream AIS = AudioSystem.getAudioInputStream(musicPath);
                        clip = AudioSystem.getClip();
                        clip.open(AIS);
                        clip.loop(Clip.LOOP_CONTINUOUSLY);
                        clip.start();
                        System.out.println("Playing " + musicPath);
                    } else {
                        System.out.println("File not found at: " + musicPath.getAbsolutePath());
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e);
                }
            }
        }
    }
    
    
    


    public static void playsfx(String path){
        try{
            File musicPath = new File(path);
            AudioInputStream AIS = AudioSystem.getAudioInputStream(musicPath);
            sfx = AudioSystem.getClip();
            if(musicPath.exists()){
                sfx.open(AIS);
                sfx.start();
                System.out.println("Playing "+musicPath); 
            }
        }
        catch(Exception e){
        System.out.println(e);
        }
        
    }
        

}
        
 
    

