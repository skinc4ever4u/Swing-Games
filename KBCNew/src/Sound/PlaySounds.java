package Sound;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class PlaySounds {
	static SoundJLayer mp3;
	public static void playSound(String filePath) throws MalformedURLException, URISyntaxException
	{
		System.out.println(filePath);
		
		//for eclipse
		String urlString=PlaySounds.class.getResource(filePath).toURI().toURL().toString();
		
		// for jar file
		//String path=PlaySounds.class.getResource(filePath).toString().substring(10);
		
		//System.out.println(path);
		
		//File file = new File(path);
		//String str=file.getCanonicalPath().toString();	
		//System.out.println(path.substring(6));
		//System.out.println(file.toPath());
		//System.out.println(str);
		//File fileExist=new File(str);
		//String urlString = file.toURL().toString();
		//File file = new File("C:\\Users\\Sunil\\Documents\\Eclipse\\KBCNew\\src\\Sound\\"+filePath);
		//String urlString = file.toURL().toString();
		
		mp3=new SoundJLayer(urlString);
//		SoundJLayer mp3 = new SoundJLayer(urlString);
		mp3.play();			
	}
	public static void stop()
	{
		mp3.stop();
	}
	public static void rightAnswer() throws MalformedURLException
	{
		File file = new File("C:\\Users\\Sunil\\Documents\\Eclipse\\KBCNew\\src\\Sound\\RightAnswer.mp3");
		String urlString = file.toURL().toString();
		mp3=new SoundJLayer(urlString);
		mp3.play();
	}
/*	public void splashScreenSound() throws MalformedURLException
	{
		//File file = new File(PlaySounds.class.getResource("startTone.mp3").toString());
		File file = new File("C:\\Users\\Sunil\\Documents\\Eclipse\\KBCNew\\src\\Sound\\startTone.mp3");
		String urlString = file.toURL().toString();
		SoundJLayer mp3=new SoundJLayer(urlString);
//		SoundJLayer mp3 = new SoundJLayer(urlString);
		mp3.play();	
	}*/

}
