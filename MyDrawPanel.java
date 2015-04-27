import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyDrawPanel extends JPanel {
	
	public void paintComponent(Graphics g){
		
	//	g.setColor(Color.white);
	//	g.fillRect(140, 50, 420, 420);
		g.setColor(Color.orange);
		g.fillRect(150, 60, 400, 400);
		g.setColor(Color.black);
		g.fillRect(150, 60, 3, 400);
		g.fillRect(200, 60, 3, 400);
		g.fillRect(250, 60, 3, 400);
		g.fillRect(300, 60, 3, 400);
		g.fillRect(350, 60, 3, 400);
		g.fillRect(400, 60, 3, 400);
		g.fillRect(450, 60, 3, 400);
		g.fillRect(500, 60, 3, 400);
		g.fillRect(550, 60, 3, 400);
		
		g.fillRect(150, 60, 400, 3);
		g.fillRect(150, 110, 400, 3);
		g.fillRect(150, 160, 400, 3);
		g.fillRect(150, 210, 400, 3);
		g.fillRect(150, 260, 400, 3);
		g.fillRect(150, 310, 400, 3);
		g.fillRect(150, 360, 400, 3);
		g.fillRect(150, 410, 400, 3);
		g.fillRect(150, 460, 403, 3);
		
	}
}


