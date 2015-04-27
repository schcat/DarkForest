import java.util.ArrayList;

//import java.util.*;
public class Hunter {
	String hunterSoot;
	int hunterSootLoca;
	int debug = 0;
	static String [][]forestHunterStatus={
		{"3","3","3","3","3","3","3","3","3","3","3"},
		{"3","0","0","0","0","0","0","0","0","0","3"},
		{"3","0","0","0","0","0","0","0","0","0","3"},
		{"3","0","0","0","0","0","0","0","0","0","3"},
		{"3","0","0","0","0","0","0","0","0","0","3"},
		{"3","0","0","0","0","0","0","0","0","0","3"},
		{"3","0","0","0","0","0","0","0","0","0","3"},
		{"3","0","0","0","0","0","0","0","0","0","3"},
		{"3","0","0","0","0","0","0","0","0","0","3"},
		{"3","0","0","0","0","0","0","0","0","0","3"},
		{"3","3","3","3","3","3","3","3","3","3","3"}
    	};
	public String [][]forestWeight={
			{"-1","-1","-1","-1","-1","-1","-1","-1","-1","-1","-1"},
    		{"-1","0","0","0","0","0","0","0","0","0","-1"},
    		{"-1","0","0","1","1","1","1","1","0","0","-1"},
    		{"-1","0","1","2","3","4","3","2","1","0","-1"},
    		{"-1","0","1","3","4","5","4","3","1","0","-1"},
    		{"-1","0","1","4","5","6","5","3","1","0","-1"},
    		{"-1","0","1","3","4","5","4","3","1","0","-1"},
    		{"-1","0","1","2","3","3","3","2","1","0","-1"},
    		{"-1","0","0","1","1","1","1","1","0","0","-1"},
    		{"-1","0","0","0","0","0","0","0","0","0","-1"},
    		{"-1","-1","-1","-1","-1","-1","-1","-1","-1","-1","-1"}
    	};
	public boolean obtainHunterJF(String hunterFeedback, int xx, int yy){  //裁判的反馈，合法，非法，提子
		boolean flagHunter = true;
		if(hunterFeedback.equals("take")){
			flagHunter = false;
		}else if(hunterFeedback.equals("illegal")){ //得知非法，已知对应坐标为0，则断定是对方地盘（棋子或眼），计入矩阵
			forestHunterStatus[xx][yy] = "1";
			int txx = xx;
			int tyy = yy;
			trap(txx, tyy);
			flagHunter = true;
		}else if(hunterFeedback.equals("legal")){ //如果合法，将己方落子计入矩阵
			forestHunterStatus[xx][yy] = "2";
			flagHunter = false;
		}
		
		if(debug == 1){
			System.out.printf("Singer said that hunter's soot is %s.\n", hunterFeedback);
			System.out.println("Hunter's board:");
			for(int i = 1; i < forestHunterStatus.length - 1; i++){
				for(int j = 1;j < forestHunterStatus.length - 1; j++){
					System.out.print(forestHunterStatus[i][j]+" ");
				}
				System.out.print("\n");
			}
			System.out.print("\n");
		}
		if(debug == 1){
			System.out.printf("Hunter's weight matrix is.\n");
			for(int i = 1; i < forestWeight.length - 1; i++){
				for(int j = 1; j < forestWeight.length - 1; j++){
					System.out.print(forestWeight[i][j]+" ");
				}
				System.out.print("\n");
			}
			System.out.print("\n");
		}
		return flagHunter;
	}
	public void killTake(ArrayList deadList){
		int deadNum = 0;
		int m = 0;
		int n = 0;
		for(int i = 0; i < deadList.size(); i++){
			deadNum = (Integer) deadList.get(i);
			m = deadNum / 9;
			n = deadNum % 9;
			forestHunterStatus[m][n] = "0";
		}
	}
	public String smartHunter(){ //落子策略
		String hunterSoot="bang";
		
		int optimum = 0;
		int optix = 0;
		int optiy = 0;
		
		for(int i = 1; i < forestWeight.length - 1; i++ ){
			for(int j = 1; j < forestWeight.length - 1; j++ ){
				
				int num = Integer.parseInt(forestWeight[i][j]);
				if(num == optimum && forestHunterStatus[i][j].equals("0")){ //如果权值相等，随机选一个
					
					int randomNum = (int)(Math.random()*2);
					if(randomNum == 1){
						optix = i;
						optiy = j;
					}
				}else if(num > optimum && forestHunterStatus[i][j].equals("0")){ //如果新坐标权值更大，用新坐标
					optix = i;
					optiy = j;
					optimum = num;
				}
			}
		}
		
		//＊其他策略
		if(optix == 0 && optiy == 0){ //无处落子时，返回pass
			hunterSoot = "pass";
		}
		
		hunterSoot = optix+","+optiy;
		
		if(debug == 1){
			System.out.printf("Bang!! Hunter soot at %s.\n", hunterSoot);
		}
		return hunterSoot;
	}
	public void trap(int trapx, int trapy){ //遇到对方棋子则提高周围权重
		if(forestHunterStatus[trapx+1][trapy].equals("0")){
			forestWeight[trapx+1][trapy] = "5";
		}else if(forestHunterStatus[trapx-1][trapy].equals("0")){
			forestWeight[trapx-1][trapy] = "5";
		}else if(forestHunterStatus[trapx][trapy+1].equals("0")){
			forestWeight[trapx][trapy+1] = "5";
		}else if(forestHunterStatus[trapx][trapy-1].equals("0")){
			forestWeight[trapx][trapy-1] = "5";
		}
	}
	
	public void matrixRefresh(){
		for(int i = 0; i < forestWeight.length; i ++){
			for(int j = 0; j < forestWeight.length; j ++){
				if(forestHunterStatus[i][j].equals("0") && //不下愚形
						((forestHunterStatus[i+1][j].equals("2") && forestHunterStatus[i-1][j].equals("2") && 
						forestHunterStatus[i][j+1].equals("2") && forestHunterStatus[i][j-1].equals("0")) || 
						(forestHunterStatus[i+1][j].equals("0") && forestHunterStatus[i-1][j].equals("2") && 
						forestHunterStatus[i][j+1].equals("2") && forestHunterStatus[i][j-1].equals("2")) ||
						(forestHunterStatus[i+1][j].equals("2") && forestHunterStatus[i-1][j].equals("0") && 
						forestHunterStatus[i][j+1].equals("2") && forestHunterStatus[i][j-1].equals("2")) ||
						(forestHunterStatus[i+1][j].equals("2") && forestHunterStatus[i-1][j].equals("2") && 
						forestHunterStatus[i][j+1].equals("0") && forestHunterStatus[i][j-1].equals("2")))){
					forestWeight[i][j] = "0";
				}else if(forestHunterStatus[i][j].equals("0") && //直线的连接和切断
						(forestHunterStatus[i+1][j].equals("1") && forestHunterStatus[i-1][j].equals("1"))||
						(forestHunterStatus[i][j+1].equals("1") && forestHunterStatus[i][j-1].equals("1"))||
						(forestHunterStatus[i+1][j].equals("2") && forestHunterStatus[i-1][j].equals("2"))||
						(forestHunterStatus[i][j+1].equals("2") && forestHunterStatus[i][j-1].equals("2"))){
					forestWeight[i][j] = "5";
				}else if(forestHunterStatus[i][j].equals("0")){ //一个子从虎口中逃出
					if(forestHunterStatus[i+1][j].equals("1") && forestHunterStatus[i-1][j].equals("1") && 
							forestHunterStatus[i][j+1].equals("1") && forestHunterStatus[i][j-1].equals("0")){
						forestWeight[i][j-1] = "5";
					}else if(forestHunterStatus[i+1][j].equals("0") && forestHunterStatus[i-1][j].equals("1") && 
							forestHunterStatus[i][j+1].equals("1") && forestHunterStatus[i][j-1].equals("1")){
						forestWeight[i+1][j] = "5";
					}else if(forestHunterStatus[i+1][j].equals("1") && forestHunterStatus[i-1][j].equals("0") && 
							forestHunterStatus[i][j+1].equals("1") && forestHunterStatus[i][j-1].equals("1")){
						forestWeight[i-1][j] = "5";
					}else if(forestHunterStatus[i+1][j].equals("1") && forestHunterStatus[i-1][j].equals("1") && 
							forestHunterStatus[i][j+1].equals("0") && forestHunterStatus[i][j-1].equals("1")){
						forestWeight[i][j+1] = "5";
					}	
				}
			}
		}
	}
}
