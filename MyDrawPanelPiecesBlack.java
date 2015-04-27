import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MyDrawPanelPiecesBlack extends JPanel {
		public void paintComponent(Graphics g){
			g.setColor(Color.black);
			g.fillOval(600, 50, 50, 50);
			
			g.fillOval(50, 50, 50, 50);
			g.setColor(Color.white);
			g.fillOval(52, 52, 46, 46);
			}
		}
