# DarkForest
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

import javax.swing.*;

public class DarkForest{
	
	JFrame frame = new JFrame("DarkForest 3.0");
	MyDrawPanel BoardPanel = new MyDrawPanel();
	static boolean ButtonClicked = true;	
	static boolean TextInput = true;
	static String playerInput = ""; //存储玩家落子显示
	static String hunterInput = ""; //存储hunter显示
	static A BW = new A();
//	static boolean flag11 = true;
	static int count = 0;
	
	JLabel label1 = new JLabel("hunter");
	JLabel label2 = new JLabel("player");
			
	Hunter newHunter = new Hunter(); //初始化三个角色
	Player newPlayer = new Player();
	Judger newJudger = new Judger();
	
	boolean flagProcesser = true; //循环标记
	boolean flagPlayer = true;
	boolean flagHunter = true;
	
	static String inputSoot = null; //双方落子坐标
	String hunterSoot = null;
	
	int inSoot;
	int huSoot;
	
	JTextArea text1 = new JTextArea(50, 50);
	JTextArea text2 = new JTextArea(50, 50);
	
//	JTextField text3 = new JTextField(50);
	JTextField text4 = new JTextField(50);
	
	static String playerSootText;
	static boolean inputFlag;
	
	public String BlackOrWhite(){  //选择颜色，执黑或执白
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please choose color, black or white?");
		
		JLabel label3 = new JLabel("<html><p>Singer says: Wellcome to DarkForest!</p></p>Please choose color, black or white?</p></html>");
		
		BoardPanel.add(label3);
		label3.setBounds(150, 5, 300, 50);
		
	//	Color arrColor[] = new Color[] { Color.black, Color.white };
			

		CircleButton cb1 = new CircleButton(" ",Color.white);
		frame.getContentPane().add(cb1);
		cb1.setBounds(470, 15, 30, 30);
		cb1.addActionListener(new cb1ActionListener());
		      
		CircleButton cb2 = new CircleButton(" ", Color.black);
		frame.getContentPane().add(cb2);
		cb2.setBounds(420, 15, 30, 30);
		cb2.addActionListener(new cb2ActionListener());
		String BWchoose = null;
		do{
			System.out.print("");
		}while(ButtonClicked);
		
		boolean result = false;
		
		label3.setText("Singer says: Please input your soot.");
		frame.remove(cb1);
		frame.remove(cb2);
		frame.repaint();
		
		
		JButton cb11 = new JButton();
			frame.getContentPane().add(cb11);
			cb11.setBounds(151, 60, 18, 18);
			cb11.addActionListener(new cb11ActionListener());
		
		JButton cb12 = new JButton();
			frame.getContentPane().add(cb12);
			cb12.setBounds(183, 60, 36, 18);
			cb12.addActionListener(new cb12ActionListener());
				
		JButton cb13 = new JButton();
			frame.getContentPane().add(cb13);
			cb13.setBounds(233, 60, 36, 18);
			cb13.addActionListener(new cb13ActionListener());
		
		JButton cb14 = new JButton();
			frame.getContentPane().add(cb14);
			cb14.setBounds(286, 60, 36, 18);
			cb14.addActionListener(new cb14ActionListener());
				
		JButton cb15 = new JButton();
			frame.getContentPane().add(cb15);
			cb15.setBounds(333, 60, 36, 18);
			cb15.addActionListener(new cb15ActionListener());
			
		JButton cb16 = new JButton();
			frame.getContentPane().add(cb16);
			cb16.setBounds(383, 60, 36, 18);
			cb16.addActionListener(new cb16ActionListener());
					
		JButton cb17 = new JButton();
			frame.getContentPane().add(cb17);
			cb17.setBounds(433, 60, 36, 18);
			cb17.addActionListener(new cb17ActionListener());
		
		JButton cb18 = new JButton();
			frame.getContentPane().add(cb18);
			cb18.setBounds(483, 60, 36, 18);
			cb18.addActionListener(new cb18ActionListener());
				
		JButton cb19 = new JButton();
			frame.getContentPane().add(cb19);
			cb19.setBounds(533, 60, 18, 18);
			cb19.addActionListener(new cb19ActionListener());
		
		JButton cb21 = new JButton();
			frame.getContentPane().add(cb21);
			cb21.setBounds(151, 92, 18, 36);
			cb21.addActionListener(new cb21ActionListener());
					
		CircleButton cb22 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb22);
			cb22.setBounds(183, 92, 36, 36);
			cb22.addActionListener(new cb22ActionListener());
			
		CircleButton cb23 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb23);
			cb23.setBounds(233, 92, 36, 36);
			cb23.addActionListener(new cb23ActionListener());
					
		CircleButton cb24 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb24);
			cb24.setBounds(283, 92, 36, 36);
			cb24.addActionListener(new cb24ActionListener());
				
		CircleButton cb25 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb25);
			cb25.setBounds(333, 92, 36, 36);
			cb25.addActionListener(new cb25ActionListener());
						
		CircleButton cb26 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb26);
			cb26.setBounds(383, 92, 36, 36);
			cb26.addActionListener(new cb26ActionListener());
			
		CircleButton cb27 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb27);
			cb27.setBounds(433, 92, 36, 36);
			cb27.addActionListener(new cb27ActionListener());
				
		CircleButton cb28 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb28);
			cb28.setBounds(483, 92, 36, 36);
			cb28.addActionListener(new cb28ActionListener());
			
		JButton cb29 = new JButton();
			frame.getContentPane().add(cb29);
			cb29.setBounds(533, 92, 18, 36);
			cb29.addActionListener(new cb29ActionListener());
					
		JButton cb31 = new JButton();
			frame.getContentPane().add(cb31);
			cb31.setBounds(151, 142, 18, 36);
			cb31.addActionListener(new cb31ActionListener());
			
		CircleButton cb32 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb32);
			cb32.setBounds(183, 142, 36, 36);
			cb32.addActionListener(new cb32ActionListener());
					
		CircleButton cb33 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb33);
			cb33.setBounds(233, 142, 36, 36);
			cb33.addActionListener(new cb33ActionListener());
				
		CircleButton cb34 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb34);
			cb34.setBounds(283, 142, 36, 36);
			cb34.addActionListener(new cb34ActionListener());
						
		CircleButton cb35 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb35);
			cb35.setBounds(333, 142, 36, 36);
			cb35.addActionListener(new cb35ActionListener());
			
		CircleButton cb36 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb36);
			cb36.setBounds(383, 142, 36, 36);
			cb36.addActionListener(new cb36ActionListener());
					
		CircleButton cb37 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb37);
			cb37.setBounds(433, 142, 36, 36);
			cb37.addActionListener(new cb37ActionListener());
			
		CircleButton cb38 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb38);
			cb38.setBounds(483, 142, 36, 36);
			cb38.addActionListener(new cb38ActionListener());
						
		JButton cb39 = new JButton();
			frame.getContentPane().add(cb39);
			cb39.setBounds(533, 142, 18, 36);
			cb39.addActionListener(new cb39ActionListener());
				
		JButton cb41 = new JButton();
			frame.getContentPane().add(cb41);
			cb41.setBounds(151, 192, 18, 36);
			cb41.addActionListener(new cb41ActionListener());
						
		CircleButton cb42 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb42);
			cb42.setBounds(183, 192, 36, 36);
			cb42.addActionListener(new cb42ActionListener());
					
		CircleButton cb43 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb43);
			cb43.setBounds(233, 192, 36, 36);
			cb43.addActionListener(new cb43ActionListener());
							
		CircleButton cb44 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb44);
			cb44.setBounds(283, 192, 36, 36);
			cb44.addActionListener(new cb44ActionListener());
				
		CircleButton cb45 = new CircleButton("", Color.white);
			frame.getContentPane().add(cb45);
			cb45.setBounds(333, 192, 36, 36);
			cb45.addActionListener(new cb45ActionListener());
				
		CircleButton cb46 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb46);
			cb45.setBounds(383, 192, 36, 36);
			cb45.addActionListener(new cb46ActionListener());
			
		CircleButton cb47 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb47);
			cb47.setBounds(433, 192, 36, 36);
			cb47.addActionListener(new cb47ActionListener());
					
		CircleButton cb48 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb48);
			cb48.setBounds(483, 192, 36, 36);
			cb48.addActionListener(new cb48ActionListener());
			
		JButton cb49 = new JButton();
			frame.getContentPane().add(cb49);
			cb49.setBounds(533, 192, 18, 36);
			cb49.addActionListener(new cb49ActionListener());
					
		JButton cb51 = new JButton();
			frame.getContentPane().add(cb51);
			cb51.setBounds(151, 242, 18, 36);
			cb51.addActionListener(new cb51ActionListener());
				
		CircleButton cb52 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb52);
			cb52.setBounds(183, 242, 36, 36);
			cb52.addActionListener(new cb52ActionListener());
						
		CircleButton cb53 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb53);
			cb53.setBounds(230, 242, 36, 36);
			cb53.addActionListener(new cb53ActionListener());
		
		CircleButton cb54 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb54);
			cb54.setBounds(283, 242, 36, 36);
			cb54.addActionListener(new cb54ActionListener());
					
		CircleButton cb55 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb55);
			cb55.setBounds(333, 242, 36, 36);
			cb55.addActionListener(new cb55ActionListener());
			
		CircleButton cb56 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb56);
			cb56.setBounds(383, 242, 36, 36);
			cb56.addActionListener(new cb56ActionListener());
						
		CircleButton cb57 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb57);
			cb57.setBounds(433, 242, 36, 36);
			cb57.addActionListener(new cb57ActionListener());
			
		CircleButton cb58 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb58);
			cb58.setBounds(483, 242, 36, 36);
			cb58.addActionListener(new cb58ActionListener());
						
		JButton cb59 = new JButton();
			frame.getContentPane().add(cb59);
			cb59.setBounds(533, 242, 18, 36);
			cb59.addActionListener(new cb59ActionListener());
					
		JButton cb61 = new JButton();
			frame.getContentPane().add(cb61);
			cb61.setBounds(151, 292, 18, 36);
			cb61.addActionListener(new cb61ActionListener());
							
		CircleButton cb62 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb62);
			cb62.setBounds(183, 292, 36, 36);
			cb62.addActionListener(new cb62ActionListener());
				
		CircleButton cb63 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb63);
			cb63.setBounds(233, 292, 36, 36);
			cb63.addActionListener(new cb63ActionListener());
					
		CircleButton cb64 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb64);
			cb64.setBounds(283, 292, 36, 36);
			cb64.addActionListener(new cb64ActionListener());
				
		CircleButton cb65 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb65);
			cb65.setBounds(333, 292, 36, 36);
			cb65.addActionListener(new cb65ActionListener());
						
		CircleButton cb66 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb66);
			cb66.setBounds(383, 292, 36, 36);
			cb66.addActionListener(new cb66ActionListener());
				
		CircleButton cb67 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb67);
			cb67.setBounds(433, 292, 36, 36);
			cb67.addActionListener(new cb67ActionListener());
						
		CircleButton cb68 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb68);
			cb68.setBounds(483, 292, 36, 36);
			cb68.addActionListener(new cb68ActionListener());
					
		JButton cb69 = new JButton();
			frame.getContentPane().add(cb69);
			cb69.setBounds(533, 292, 18, 36);
			cb69.addActionListener(new cb69ActionListener());
							
		JButton cb71 = new JButton();
			frame.getContentPane().add(cb71);
			cb71.setBounds(151, 342, 18, 36);
			cb71.addActionListener(new cb71ActionListener());
				
		CircleButton cb72 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb72);
			cb72.setBounds(183, 342, 36, 36);
			cb72.addActionListener(new cb72ActionListener());
						
		CircleButton cb73 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb73);
			cb73.setBounds(233, 342, 36, 36);
			cb73.addActionListener(new cb73ActionListener());
				
		CircleButton cb74 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb74);
			cb74.setBounds(283, 342, 36, 36);
			cb74.addActionListener(new cb74ActionListener());
							
		CircleButton cb75 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb75);
			cb75.setBounds(333, 342, 36, 36);
			cb75.addActionListener(new cb75ActionListener());
					
		CircleButton cb76 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb76);
			cb76.setBounds(383, 342, 36, 36);
			cb76.addActionListener(new cb76ActionListener());
							
		CircleButton cb77 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb77);
			cb77.setBounds(433, 342, 36, 36);
			cb77.addActionListener(new cb77ActionListener());
						
		CircleButton cb78 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb78);
			cb78.setBounds(483, 342, 36, 36);
			cb78.addActionListener(new cb78ActionListener());
								
		JButton cb79 = new JButton();
			frame.getContentPane().add(cb79);
			cb79.setBounds(533, 342, 18, 36);
			cb79.addActionListener(new cb79ActionListener());
							
		JButton cb81 = new JButton();
			frame.getContentPane().add(cb81);
			cb81.setBounds(151, 392, 18, 36);
			cb81.addActionListener(new cb81ActionListener());
							
		CircleButton cb82 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb82);
			cb82.setBounds(183, 392, 36, 36);
			cb82.addActionListener(new cb82ActionListener());
				
		CircleButton cb83 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb83);
			cb83.setBounds(233, 392, 36, 36);
			cb83.addActionListener(new cb83ActionListener());
					
		CircleButton cb84 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb84);
			cb84.setBounds(283, 392, 36, 36);
			cb84.addActionListener(new cb84ActionListener());
					
		CircleButton cb85 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb85);
			cb85.setBounds(333, 392, 36, 36);
			cb85.addActionListener(new cb85ActionListener());
							
		CircleButton cb86 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb86);
			cb86.setBounds(383, 392, 36, 36);
			cb86.addActionListener(new cb86ActionListener());
					
		CircleButton cb87 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb87);
			cb87.setBounds(433, 392, 36, 36);
			cb87.addActionListener(new cb87ActionListener());
						
		CircleButton cb88 = new CircleButton("white", Color.white);
			frame.getContentPane().add(cb88);
			cb88.setBounds(483, 392, 36, 36);
			cb88.addActionListener(new cb88ActionListener());
					
		JButton cb89 = new JButton();
			frame.getContentPane().add(cb89);
			cb89.setBounds(533, 392, 18, 36);
			cb89.addActionListener(new cb89ActionListener());
								
		JButton cb91 = new JButton();
			frame.getContentPane().add(cb91);
			cb91.setBounds(151, 442, 18, 18);
			cb91.addActionListener(new cb91ActionListener());
				
		JButton cb92 = new JButton();
			frame.getContentPane().add(cb92);
			cb92.setBounds(183, 442, 36, 18);
			cb92.addActionListener(new cb92ActionListener());
						
		JButton cb93 = new JButton();
			frame.getContentPane().add(cb93);
			cb93.setBounds(233, 442, 36, 18);
			cb93.addActionListener(new cb93ActionListener());
				
		JButton cb94 = new JButton();
			frame.getContentPane().add(cb94);
			cb94.setBounds(283, 442, 36, 18);
			cb94.addActionListener(new cb94ActionListener());
							
		JButton cb95 = new JButton();
			frame.getContentPane().add(cb95);
			cb95.setBounds(333, 442, 36, 18);
			cb95.addActionListener(new cb95ActionListener());
						
		JButton cb96 = new JButton();
			frame.getContentPane().add(cb96);
			cb96.setBounds(383, 442, 36, 18);
			cb96.addActionListener(new cb96ActionListener());
								
		JButton cb97 = new JButton();
			frame.getContentPane().add(cb97);
			cb97.setBounds(433, 442, 36, 18);
			cb97.addActionListener(new cb97ActionListener());
							
		JButton cb98 = new JButton();
			frame.getContentPane().add(cb98);
			cb98.setBounds(483, 442, 36, 18);
			cb98.addActionListener(new cb98ActionListener());
									
		JButton cb99 = new JButton();
			frame.getContentPane().add(cb99);
			cb99.setBounds(533, 442, 18, 18);
			cb99.addActionListener(new cb99ActionListener());
		
		return BWchoose;
	}

	 class cb11ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "1,1";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb12ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "1,2";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb13ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "1,3";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb14ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "1,4";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb15ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "1,5";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb16ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "1,6";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb17ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "1,7";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb18ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "1,8";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb19ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "1,9";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb21ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "2,1";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb22ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "2,2";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb23ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "2,3";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb24ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "2,4";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb25ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "2,5";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb26ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "2,6";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb27ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "2,7";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb28ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "2,8";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb29ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "2,9";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb31ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "3,1";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb32ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "3,2";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb33ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "3,3";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb34ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "3,4";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb35ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "3,5";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb36ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "3,6";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb37ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "3,7";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb38ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "3,8";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb39ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "3,9";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb41ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "4,1";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb42ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "4,2";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb43ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "4,3";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb44ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "4,4";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb45ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "4,5";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb46ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "4,6";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb47ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "4,7";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb48ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "4,8";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb49ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "4,9";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb51ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "5,1";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb52ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "5,2";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb53ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "5,3";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb54ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "5,4";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb55ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "5,5";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb56ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "5,6";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb57ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "5,7";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb58ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "5,8";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb59ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "5,9";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb61ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "6,1";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb62ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "6,2";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb63ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "6,3";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb64ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "6,4";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb65ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "6,5";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb66ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "6,6";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb67ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "6,7";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb68ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "6,8";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb69ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "6,9";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb71ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "7,1";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb72ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "7,2";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb73ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "7,3";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb74ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "7,4";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb75ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "7,5";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb76ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "7,6";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb77ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "7,7";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb78ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "7,8";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb79ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "7,9";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb81ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "8,1";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb82ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "8,2";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb83ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "8,3";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb84ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "8,4";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb85ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "8,5";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb86ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "8,6";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb87ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "8,7";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb88ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "8,8";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb89ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "8,9";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb91ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "9,1";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb92ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "9,2";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb93ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "9,3";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb94ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "9,4";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb95ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "9,5";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb96ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "9,6";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb97ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "9,7";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb98ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "9,8";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 class cb99ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 inputSoot = "9,9";
			 TextInput = false;
			 text4.setText("");
			 }
		 }
	 
	
	 class cb1ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 ButtonClicked = false;
			 BW.color = "white";
			 System.out.println(BW.color);
			 } //先后手选择
		 }
	 class cb2ActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 ButtonClicked = false;
			 BW.color = "black";
			 System.out.println(BW.color);
			 } //先后手选择
		 }
	class text4ActionListener implements ActionListener { //玩家输入
		public void actionPerformed(ActionEvent arg0) {	
			inputSoot = text4.getText();
			TextInput = false;
			text4.setText("");
			}
		}

	public void finishGame(){  //结束游戏
		System.out.println("Game is over.");
	}
	
		
	public void forestHunting(){  //游戏过程
		
		BoardPanel.setLayout(null);
		frame.setResizable(false); //固定框架尺寸
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(BoardPanel);
		
		
		BoardPanel.add(label1); //文本域1加到面板
		label1.setBounds(53, 85, 53, 90);
		BoardPanel.add(label2); //文本域2加到面板
		label2.setBounds(606, 85, 606, 90);
	//	BoardPanel.add(text3); //文本框3加到面板
	//	text3.setBounds(27, 420, 91, 25);
		BoardPanel.add(text4); //文本框4加到面板
		text4.setBounds(583, 420, 91, 25);
		
		text1.setLineWrap(true); //滚动条
		JScrollPane scroller1 = new JScrollPane(text1);
		scroller1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		BoardPanel.add(scroller1);
		scroller1.setBounds(30, 160, 85, 240);
		
		text2.setLineWrap(true); //滚动条
		JScrollPane scroller2 = new JScrollPane(text2);
		scroller2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		BoardPanel.add(scroller2);
		scroller2.setBounds(586, 160, 85, 240);
		
		text1.setEditable(false); //文本域1不可输入
		text2.setEditable(false); //文本域2不可输入
	//	text3.setEditable(false); //文本框3不可输入
		
		frame.setSize(700,500);
		frame.setVisible(true);
		
		System.out.println("Wellcome to DarkForest!");
		
		class checkActionListener implements ActionListener{
			 public void actionPerformed(ActionEvent event) {
			//	 if(flag11 == true){
					if("white".equals(BW.color)){
						
						MyDrawPanelBoardWhiteCheck WhiteCheck = new MyDrawPanelBoardWhiteCheck();
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.getContentPane().add(WhiteCheck);
						frame.setSize(700,500);
						frame.setVisible(true);
						
					}else if("black".equals(BW.color)){
						
						MyDrawPanelBoardBlackCheck BlackCheck = new MyDrawPanelBoardBlackCheck();
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.getContentPane().add(BlackCheck);
						frame.setSize(700,500);
						frame.setVisible(true);
				//	}
				//	flag11 = false;
				 }
			 }
			 
			 
			 }
		
		BlackOrWhite();
		String role = BW.color; //先后手
				
		if("white".equals(role)){
						
			MyDrawPanelPiecesWhite PanelWhite = new MyDrawPanelPiecesWhite();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().add(PanelWhite);
			frame.setSize(700,500);
			frame.setVisible(true);
			
		}else if("black".equals(role)){
			
			MyDrawPanelPiecesBlack PanelBlack = new MyDrawPanelPiecesBlack();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().add(PanelBlack);
			frame.setSize(700,500);
			frame.setVisible(true);
		}		
		
		if("white".equals(role)){ //先后手标记
			hunterSoot=newHunter.smartHunter(); //hunter落子
			String[] hunterSootCoor = hunterSoot.split(",");
			int xx = new Integer(hunterSootCoor[0]);
			int yy = new Integer(hunterSootCoor[1]);
			String judgeHunterSoot = newJudger.Judgement("hunter", xx, yy);  //裁判判断输入
			flagHunter = newHunter.obtainHunterJF(judgeHunterSoot, xx, yy);  //判断结果传给hunter
			}
		count = 0;
		text4.addActionListener(new text4ActionListener()); //文本框4响应
		
		JButton checkButton = new JButton("see");
		frame.getContentPane().add(checkButton);
		checkButton.setBounds(27, 420, 91, 25);
		checkButton.addActionListener(new checkActionListener()); //查看局面按钮
				
		while(flagProcesser){  //游戏循环，两个pass结束
			flagPlayer = true;
			flagHunter = true;
			count = count + 1;
			
			while(flagPlayer){  //玩家落子循环，legal或take结束
				inputFlag = false;
				TextInput = true;
				System.out.print(count+" Please input your soot:");
				do{
					System.out.print("");
				}while(TextInput);
				if("pass".equals(inputSoot)){
				}else if(inputSoot.length() == 3 && java.lang.Character.isDigit(inputSoot.charAt(0)) 
						&& java.lang.Character.isDigit(inputSoot.charAt(2)) 
							&& inputSoot.contains(",")){ //判断输入是否合法
					String[] inputSootCoor = inputSoot.split(","); //识别玩家输入
					int xx = new Integer(inputSootCoor[0]);
					int yy = new Integer(inputSootCoor[1]);
					if(xx < 10 && xx > 0 && yy < 10 && yy > 0){
						
						String judgePlayerSoot = newJudger.Judgement("player", xx, yy);  //裁判判断输入
						flagPlayer = newPlayer.obtainPlayerJF(judgePlayerSoot, xx, yy);  //判断结果传给玩家
						if(judgePlayerSoot.equals("legal")){
							playerInput += inputSoot;
							playerInput += "         ";
							text2.setText(playerInput); //更新输入列表
						}
						if(judgePlayerSoot.equals("take")){ //如果出现take，则运行killDeadLife取得死亡名单，传给双方
							ArrayList deadList = new ArrayList();
							deadList = newJudger.killDeadLife();
							newHunter.killTake(deadList);
							newPlayer.killTake(deadList);
							frame.repaint();
							}
						}else{
							System.out.println("Your soot posture is wrong, please try again!");
						}
					}else{
						System.out.println("Your soot posture is wrong, please try again!");
						}
				if("white".equals(role)){
					MyDrawPanelBoardWhite drawPanel = new MyDrawPanelBoardWhite();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.getContentPane().add(drawPanel);
					frame.setSize(700,500);
					frame.setVisible(true);

				}else if("black".equals(role)){
					MyDrawPanelBoardBlack drawPanel = new MyDrawPanelBoardBlack();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.getContentPane().add(drawPanel);
					frame.setSize(700,500);
					frame.setVisible(true);
				}
			}
			
	//		try {
	//			Thread.sleep(1000);
	//		} catch (InterruptedException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
			
			while(flagHunter){ //hunter落子循环
				System.out.print(count+" Hunter's turn:");
				hunterSoot=newHunter.smartHunter(); //hunter落子
				if(hunterSoot == "pass"){
					flagHunter = false;
				}else{
					String[] hunterSootCoor = hunterSoot.split(",");
					int xx = new Integer(hunterSootCoor[0]);
					int yy = new Integer(hunterSootCoor[1]);
					String judgeHunterSoot = newJudger.Judgement("hunter", xx, yy);  //裁判判断输入
					flagHunter = newHunter.obtainHunterJF(judgeHunterSoot, xx, yy);  //判断结果传给hunter
					if(judgeHunterSoot.equals("legal")){
						hunterInput += "Bang!";
						hunterInput += "       ";
						text1.setText(hunterInput); //更新输入列表
					}
					if(judgeHunterSoot.equals("take")){ //如果出现take，则运行killDeadLife取得死亡名单，传给双方
						ArrayList deadList = new ArrayList();
						deadList = newJudger.killDeadLife(); //裁判更新局面
						newHunter.killTake(deadList); //hunter更新局面
						newPlayer.killTake(deadList); //player更新局面
						frame.repaint();
						}
				}
				if("white".equals(role)){
					MyDrawPanelBoardWhite drawPanel1 = new MyDrawPanelBoardWhite();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.getContentPane().add(drawPanel1);
					frame.setSize(700,500);
					frame.setVisible(true);

				}else if("black".equals(role)){
					MyDrawPanelBoardBlack drawPanel2 = new MyDrawPanelBoardBlack();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.getContentPane().add(drawPanel2);
					frame.setSize(700,500);
					frame.setVisible(true);
				}
			}
			if(inputSoot == "pass"&&hunterSoot == "pass") //双方pass，跳出循环
				flagProcesser = false;
		}
		MyDrawPanelBlackJudger drawPanelJudger = new MyDrawPanelBlackJudger();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(drawPanelJudger);
		frame.setSize(700,500);
		frame.setVisible(true);

		newJudger.whoWin(); //判胜负
		finishGame(); //游戏结束
		
		frame.getContentPane().setLayout(null);
	}
	
	public static void main(String[] args){
		int debug = 1;
		DarkForest newDarkForest = new DarkForest();
		newDarkForest.forestHunting();
	}
}
