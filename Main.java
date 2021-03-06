
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Main {
    static TPanel panel;
    static Game game;
    
    public static void main(String[] args) {
	JFrame frame = new JFrame("Tetris");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(24 * 16, 24 * 25);
	game = new Game();

	panel = new TPanel(game);
	panel.setFocusable(true);
	panel.addKeyListener(new KeyListener() {

		@Override
		public void keyTyped(KeyEvent e) {
		    	switch (e.getExtendedKeyCode()) {
	    
			case KeyEvent.VK_W:
			    game.up();
			    panel.update();
			    break;
			    
			case KeyEvent.VK_A:
			    game.left();
			    panel.update();
			    break;
			    
			case KeyEvent.VK_S:
			    game.down();
			    panel.update();
			    break;
			    
			case KeyEvent.VK_D:
			    game.right();
			    panel.update();
			    break;

			case KeyEvent.VK_J:
			    game.counterTurn();
			    panel.update();
			    break;

			case KeyEvent.VK_K:
			    game.clockTurn();
			    panel.update();
			    break;

			case KeyEvent.VK_L:
			    game.hold();
			    panel.update();
			    break;
			    
			default:
			    break;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {}

		@Override
		public void keyPressed(KeyEvent e) {}
	    });

	frame.add(panel);
	frame.setVisible(true);

	Tetromino.test();

	Timer timer = new Timer(1000, new TimerListener());
	timer.start();
    }

    static class TimerListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
	    game.tick();
	    panel.update();
	}
    }

    
}
