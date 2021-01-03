package snake;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Window extends Canvas{

	private static final long serialVersionUID = -8255319694373975038L;
	private JFrame frame;
	
	public Window(int width, int height, String title, Game game){
		frame = new JFrame(title);
		frame.setPreferredSize(new Dimension(width,height));
		frame.setMaximumSize(new Dimension(width,height));
		frame.setMinimumSize(new Dimension(width,height));
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.requestFocus();
		game.start();
		
	}
	public JFrame getFrame(){
		return frame;
	}


}