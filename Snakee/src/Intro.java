
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;



public class Intro {

	public static void intro()
	{
		JWindow window = new JWindow();
		
		window.getContentPane().add(
		new JLabel("", new ImageIcon("src/intro2.gif"), SwingConstants.CENTER));
		window.setBounds(0, 0, 480, 270);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
//		String bip = "src/intro/newMusic.mp3";
//		Media hit = new Media(new File(bip).toURI().toString());
//		MediaPlayer mediaPlayer = new MediaPlayer(hit);
//		mediaPlayer.play();
		
		try {
		    Thread.sleep(8000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		window.setVisible(false);
		

		
	}
	public static void startup​(Runnable runnable)
	{
		
	}
}
