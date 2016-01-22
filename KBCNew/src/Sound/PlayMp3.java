package Sound;

import java.io.File;

import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;



class SoundJLayer extends PlaybackListener implements Runnable
{
    private String filePath;
    private AdvancedPlayer player;
    private Thread playerThread;   
    private String urlAsString;

    public SoundJLayer(String urlAsString)
    {
        this.urlAsString = urlAsString;
    }

    public void play()
    {
        try
        {
            /*String urlAsString = 
                "file:///" 
                + new java.io.File(".").getCanonicalPath          + "/" 
                + this.filePath;*/
        	//File file = new File("D:\\10-30Codes\\TestingFile1\\BMB-Zinda.mp3");
            //String urlAsString = file.toURL().toString();
        	this.player = new AdvancedPlayer
            (
                new java.net.URL(urlAsString).openStream(),
                javazoom.jl.player.FactoryRegistry.systemRegistry().createAudioDevice()
            );

            this.player.setPlayBackListener(this);

            this.playerThread = new Thread(this, "AudioPlayerThread");

            this.playerThread.start();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    // PlaybackListener members

    public void stop()
    {
    	this.playerThread.stop();
    }
    public void playbackStarted(PlaybackEvent playbackEvent)
    {
       // System.out.println("playbackStarted");
    }

    public void playbackFinished(PlaybackEvent playbackEvent)
    {
        //System.out.println("playbackEnded");
    }    

    // Runnable members

    public void run()
    {
        try
        {
        	
            this.player.play();
        }
        catch (javazoom.jl.decoder.JavaLayerException ex)
        {
            ex.printStackTrace();
        }

    }
}
public class PlayMp3 {
	/*public static void main(String[] args)
    {
		
        SoundJLayer soundToPlay = new SoundJLayer("Test.mp3");

        soundToPlay.play();
    }*/
}