import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
public class MyDrawPanelBoardWhite extends JPanel {
	public void paintComponent(Graphics g){
		
		for(int i = 1; i<10; i++){
			for(int j = 1; j<10; j++){
				if((Judger.forestJudgerStatus[i][j]).equals("1")){
					g.setColor(Color.white);
					g.fillOval(133 + (j - 1) * 50, 42 + (i - 1) * 50, 36, 36);
					}
			}
		}
		for(int i = 1; i<10; i++){
			for(int j = 1; j<10; j++){
				if((Judger.forestJudgerStatus[i][j]).equals("2")){
					g.setColor(Color.black);
					g.fillOval(133 + (j - 1) * 50, 42 + (i - 1) * 50, 36, 36);
					}
			}
		}
	}
}
