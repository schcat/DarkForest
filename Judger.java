import java.util.ArrayList;

public class Judger {
	int debug = 1;
	static String [][]forestJudgerStatus={ //对方是1，自己是2，要加边界
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

	String [][]lifeTestStatus={ 
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
	
	int xPlayerSave = 0;
	int yPlayerSave = 0;
	int xHunterSave = 0;
	int yHunterSave = 0;
	static boolean lifeState = false;
	public String Judgement(String color, int Sootx, int Sooty){ //先判断有没有提子，然后判断有没有非法，剩下的是合法
		
		String JudgerSpeak = "legal";
		lifeState = true;
		if(forestJudgerStatus[Sootx][Sooty].equals("1")||forestJudgerStatus[Sootx][Sooty].equals("2")){ //当前位置有子
			JudgerSpeak = "illegal";
			if(debug == 1){System.out.println("There is occupied.");}
		}else if(Sootx == xPlayerSave && Sooty == yPlayerSave && color.equals("player") && //player方，在判断take前，检查是否打劫
				forestJudgerStatus[Sootx+1][Sooty].equals("2") && forestJudgerStatus[Sootx][Sooty+1].equals("2") &&
				forestJudgerStatus[Sootx-1][Sooty].equals("2") && forestJudgerStatus[Sootx][Sooty-1].equals("2")){
			JudgerSpeak = "illegal";
			if(debug == 1){System.out.println("There is rob.");}
		}else if(Sootx == xHunterSave && Sooty == yHunterSave && color.equals("hunter") && //hunter方，在判断take前，检查是否打劫
				forestJudgerStatus[Sootx+1][Sooty].equals("1") && forestJudgerStatus[Sootx][Sooty+1].equals("1") &&
				forestJudgerStatus[Sootx-1][Sooty].equals("1") && forestJudgerStatus[Sootx][Sooty-1].equals("1")){
			JudgerSpeak = "illegal";
			if(debug == 1){System.out.println("There is rob.");}
		}else if(forestJudgerStatus[Sootx][Sooty].equals("0") && color.equals("player")){ //player落子，递归找气，判断是不是take
			forestJudgerStatus[Sootx][Sooty] = "1"; //放上棋子
			Player.forestPlayerStatus[Sootx][Sooty] = "1"; //放上棋子
			System.out.println("checkkk");
			
			if(forestJudgerStatus[Sootx + 1][Sooty].equals("2")){
				lifeState = false;
				deadCheck("player", Sootx + 1, Sooty, "4");
				if(lifeState == true){
					initia("4");
					}else if(lifeState == false){
						JudgerSpeak = "take";
						}
				}
			
			if(forestJudgerStatus[Sootx - 1][Sooty].equals("2")){
				lifeState = false;
				deadCheck("player", Sootx - 1, Sooty, "5");
				if(lifeState == true){
					initia("5");
					}else if(lifeState == false){
						JudgerSpeak = "take";
						}
				}
			
			if(forestJudgerStatus[Sootx][Sooty + 1].equals("2")){
				lifeState = false;
				deadCheck("player", Sootx, Sooty + 1, "6");
				if(lifeState == true){
					initia("6");
					}else if(lifeState == false){
						JudgerSpeak = "take";
						}
				}
			
			if(forestJudgerStatus[Sootx][Sooty - 1].equals("2")){
				lifeState = false;
				deadCheck("player", Sootx, Sooty - 1, "7");
				if(lifeState == true){
					initia("7");
					}else if(lifeState == false){
						JudgerSpeak = "take";
						}
				}
			
		}else if(forestJudgerStatus[Sootx][Sooty].equals("0") && color.equals("hunter")){ //hunter落子，递归找气，判断是不是take
			forestJudgerStatus[Sootx][Sooty] = "2"; //放上棋子
			Hunter.forestHunterStatus[Sootx][Sooty] = "2"; //放上棋子
			System.out.println("checkll");
			if(forestJudgerStatus[Sootx + 1][Sooty].equals("1")){
				lifeState = false;
				deadCheck("hunter", Sootx + 1, Sooty, "4");
				if(lifeState == true){
					initia("4");
					}else if(lifeState == false){
						JudgerSpeak = "take";
						}
				}
						
			if(forestJudgerStatus[Sootx - 1][Sooty].equals("1")){
				lifeState = false;
				deadCheck("hunter", Sootx - 1, Sooty, "5");
				if(lifeState == true){
					initia("5");
					}else if(lifeState == false){
						JudgerSpeak = "take";
						}
				}
			
			if(forestJudgerStatus[Sootx][Sooty + 1].equals("1")){
				lifeState = false;
				deadCheck("hunter", Sootx, Sooty + 1, "6");
				if(lifeState == true){
					initia("6");
					}else if(lifeState == false){
						JudgerSpeak = "take";
						}
				}
			
			if(forestJudgerStatus[Sootx][Sooty - 1].equals("1")){
				lifeState = false;
				deadCheck("hunter", Sootx, Sooty - 1, "7");
				if(lifeState == true){
					initia("7");
					}else if(lifeState == false){
						JudgerSpeak = "take";
						}
				}
			}
		if(forestJudgerStatus[Sootx+1][Sooty].equals("1") && forestJudgerStatus[Sootx][Sooty+1].equals("1") && //下到自己或对方眼里了，撞气也是禁入点
				forestJudgerStatus[Sootx-1][Sooty].equals("1") && forestJudgerStatus[Sootx][Sooty-1].equals("1")
				&& JudgerSpeak.equals("take") == false){
			forestJudgerStatus[Sootx][Sooty] = "0";
			JudgerSpeak = "illegal";
			if(debug == 1){System.out.println("There is an eye.");}
		}else if(forestJudgerStatus[Sootx+1][Sooty].equals("3") && forestJudgerStatus[Sootx][Sooty+1].equals("1") && //下到自己或对方眼里了，撞气也是禁入点
				forestJudgerStatus[Sootx-1][Sooty].equals("1") && forestJudgerStatus[Sootx][Sooty-1].equals("1")
				&& JudgerSpeak.equals("take") == false){
			forestJudgerStatus[Sootx][Sooty] = "0";
			JudgerSpeak = "illegal";
			if(debug == 1){System.out.println("There is an eye.");}
		}else if(forestJudgerStatus[Sootx+1][Sooty].equals("1") && forestJudgerStatus[Sootx][Sooty+1].equals("3") && //下到自己或对方眼里了，撞气也是禁入点
				forestJudgerStatus[Sootx-1][Sooty].equals("1") && forestJudgerStatus[Sootx][Sooty-1].equals("1")
				&& JudgerSpeak.equals("take") == false){
			forestJudgerStatus[Sootx][Sooty] = "0";
			JudgerSpeak = "illegal";
			if(debug == 1){System.out.println("There is an eye.");}
		}else if(forestJudgerStatus[Sootx+1][Sooty].equals("1") && forestJudgerStatus[Sootx][Sooty+1].equals("1") && //下到自己或对方眼里了，撞气也是禁入点
				forestJudgerStatus[Sootx-1][Sooty].equals("3") && forestJudgerStatus[Sootx][Sooty-1].equals("1")
				&& JudgerSpeak.equals("take") == false){
			forestJudgerStatus[Sootx][Sooty] = "0";
			JudgerSpeak = "illegal";
			if(debug == 1){System.out.println("There is an eye.");}
		}else if(forestJudgerStatus[Sootx+1][Sooty].equals("1") && forestJudgerStatus[Sootx][Sooty+1].equals("1") && //下到自己或对方眼里了，撞气也是禁入点
				forestJudgerStatus[Sootx-1][Sooty].equals("1") && forestJudgerStatus[Sootx][Sooty-1].equals("3")
				&& JudgerSpeak.equals("take") == false){
			forestJudgerStatus[Sootx][Sooty] = "0";
			JudgerSpeak = "illegal";
			if(debug == 1){System.out.println("There is an eye.");}
		}
		if(forestJudgerStatus[Sootx+1][Sooty].equals("2") && forestJudgerStatus[Sootx][Sooty+1].equals("2") && //下到自己或对方眼里了，撞气也是禁入点
				forestJudgerStatus[Sootx-1][Sooty].equals("2") && forestJudgerStatus[Sootx][Sooty-1].equals("2")
				&& JudgerSpeak.equals("take") == false){
			forestJudgerStatus[Sootx][Sooty] = "0";
			JudgerSpeak = "illegal";
			if(debug == 1){System.out.println("There is an eye.");}
		}else if(forestJudgerStatus[Sootx+1][Sooty].equals("3") && forestJudgerStatus[Sootx][Sooty+1].equals("2") && //下到自己或对方眼里了，撞气也是禁入点
				forestJudgerStatus[Sootx-1][Sooty].equals("2") && forestJudgerStatus[Sootx][Sooty-1].equals("2")
				&& JudgerSpeak.equals("take") == false){
			forestJudgerStatus[Sootx][Sooty] = "0";
			JudgerSpeak = "illegal";
			if(debug == 1){System.out.println("There is an eye.");}
		}else if(forestJudgerStatus[Sootx+1][Sooty].equals("2") && forestJudgerStatus[Sootx][Sooty+1].equals("3") && //下到自己或对方眼里了，撞气也是禁入点
				forestJudgerStatus[Sootx-1][Sooty].equals("2") && forestJudgerStatus[Sootx][Sooty-1].equals("2")
				&& JudgerSpeak.equals("take") == false){
			forestJudgerStatus[Sootx][Sooty] = "0";
			JudgerSpeak = "illegal";
			if(debug == 1){System.out.println("There is an eye.");}
		}else if(forestJudgerStatus[Sootx+1][Sooty].equals("2") && forestJudgerStatus[Sootx][Sooty+1].equals("2") && //下到自己或对方眼里了，撞气也是禁入点
				forestJudgerStatus[Sootx-1][Sooty].equals("3") && forestJudgerStatus[Sootx][Sooty-1].equals("2")
				&& JudgerSpeak.equals("take") == false){
			forestJudgerStatus[Sootx][Sooty] = "0";
			JudgerSpeak = "illegal";
			if(debug == 1){System.out.println("There is an eye.");}
		}else if(forestJudgerStatus[Sootx+1][Sooty].equals("2") && forestJudgerStatus[Sootx][Sooty+1].equals("2") && //下到自己或对方眼里了，撞气也是禁入点
				forestJudgerStatus[Sootx-1][Sooty].equals("2") && forestJudgerStatus[Sootx][Sooty-1].equals("3")
				&& JudgerSpeak.equals("take") == false){
			forestJudgerStatus[Sootx][Sooty] = "0";
			JudgerSpeak = "illegal";
			if(debug == 1){System.out.println("There is an eye.");}
		}
		//打劫
		if(debug == 1){
			System.out.printf("Singer's board:\n");
			for(int i = 1; i < forestJudgerStatus.length - 1; i++){
				for(int j = 1;j < forestJudgerStatus.length - 1; j++){
					System.out.print(forestJudgerStatus[i][j]+" ");
				}System.out.print("\n");
			}System.out.print("\n");
		}
		if(color.equals("player")){ //为判断打劫，存储前次落子
			xPlayerSave = Sootx;
			yPlayerSave = Sooty;
		}else if(color.equals("hunter")){ //为判断打劫，存储前次落子
			xHunterSave = Sootx;
			yHunterSave = Sooty;
		}
		
		//	System.out.println("Input is" + JudgerSpeak);
		return JudgerSpeak;
	}
	//存矩阵
	
	int recursionCount = 0;
	String lifeFlag = null;
	String selfFlag = null;
	
	public void initia(String num){
		for(int i = 1; i < lifeTestStatus.length - 1; i++){ //生命状态矩阵归零
			for(int j = 1;j < lifeTestStatus.length - 1; j++){
				if(lifeTestStatus[i][j].equals(num)){
					lifeTestStatus[i][j] = "0";
				}
			}
		}
	}
	
	public void deadCheck(String color, int x, int y, String num){ //递归判断死活
		if(color.equals("player")){
			lifeFlag = "2";
			selfFlag = "1";
		}else if(color.equals("hunter")){
			lifeFlag = "1";
			selfFlag = "2";
		}
		System.out.println("check "+x+" "+y);
		if(forestJudgerStatus[x][y].equals(lifeFlag) && lifeTestStatus[x][y].equals(num) == false){ //把找到的对方子，还未作标记的，作标记
			lifeTestStatus[x][y] = num;
			System.out.println("find");
			if(forestJudgerStatus[x+1][y].equals("0")||forestJudgerStatus[x][y+1].equals("0")||
					forestJudgerStatus[x-1][y].equals("0")||forestJudgerStatus[x][y-1].equals("0")){
				lifeState = true; //如果有气，就是活棋
				System.out.println("true1");
				System.out.println(x+" "+y+" is true");
			}else{
			//	lifeState = false;
				System.out.println("false");
				if(forestJudgerStatus[x+1][y].equals(lifeFlag))
				deadCheck(color, x+1, y, num);
				if(forestJudgerStatus[x-1][y].equals(lifeFlag))
				deadCheck(color, x-1, y, num);
				if(forestJudgerStatus[x][y+1].equals(lifeFlag))
				deadCheck(color, x, y+1, num);
				if(forestJudgerStatus[x][y-1].equals(lifeFlag))
				deadCheck(color, x, y-1, num);
			}
		}
		if(DarkForest.count == 0 || DarkForest.count == 1){
			lifeState = true;
		}
		if(debug == 1){
			System.out.printf("\n");
			System.out.printf("lifeTestStatus board:\n");
			for(int i = 1; i < lifeTestStatus.length - 1; i++){
				for(int j = 1;j < lifeTestStatus.length - 1; j++){
					System.out.print(lifeTestStatus[i][j]+" ");
				}System.out.print("\n");
			}System.out.print("\n");
		}
		System.out.println("initia "+lifeState);
		
	}
	public ArrayList killDeadLife(){ //提子，提去所有标记为4的子
		System.out.println("kill1");
		ArrayList deadList = new ArrayList();
		System.out.println("These lives had been take:");
		for(int i = 1; i < 10; i++ ){
			for(int j = 1; j < 10; j++ ){
				if(lifeTestStatus[i][j].equals("4")||lifeTestStatus[i][j].equals("5")
						||lifeTestStatus[i][j].equals("6")||lifeTestStatus[i][j].equals("7")){
					System.out.println("kill2");
					lifeTestStatus[i][j] = "0";
					forestJudgerStatus[i][j] = "0";
					System.out.printf(forestJudgerStatus[i][j]+" werwerwerwer");
					deadList.add(i*9+j); //传一个代表提子的数组到当前方
					System.out.printf("%d,%d ", i, j);
				}
			}
		}
		System.out.printf("\n");
		return deadList;
	}
	public void whoWin(){ //数子，判胜负
	for(int k = 1; k < 9; k++){
		for(int i = 1; i < 10; i++ ){
			for(int j = 1; j < 10; j++ ){
				if(forestJudgerStatus[i][j].equals("1")){
					if(forestJudgerStatus[i+1][j].equals("0")){
						forestJudgerStatus[i+1][j] = "1";
					}
					if(forestJudgerStatus[i-1][j].equals("0")){
						forestJudgerStatus[i-1][j] = "1";
					}
					if(forestJudgerStatus[i][j+1].equals("0")){
						forestJudgerStatus[i][j+1] = "1";
					}
					if(forestJudgerStatus[i][j-1].equals("0")){
						forestJudgerStatus[i][j-1] = "1";
					}
					
				}
				if(forestJudgerStatus[i][j].equals("2")){
					if(forestJudgerStatus[i+1][j].equals("0")){
						forestJudgerStatus[i+1][j] = "2";
					}
					if(forestJudgerStatus[i-1][j].equals("0")){
						forestJudgerStatus[i-1][j] = "2";
					}
					if(forestJudgerStatus[i][j+1].equals("0")){
						forestJudgerStatus[i][j+1] = "2";
					}
					if(forestJudgerStatus[i][j-1].equals("0")){
						forestJudgerStatus[i][j-1] = "2";
					}
					
				}
			}
		}
	}
		int hunterScale = 0;
		int playerScale = 0;
		for(int i = 1; i < 10; i++ ){
			for(int j = 1; j < 10; j++ ){
				if(forestJudgerStatus[i][j].equals("2")){
					hunterScale ++;
				}else if(forestJudgerStatus[i][j].equals("1")){
					playerScale ++;
				}
			}
		}
		if(hunterScale > playerScale){
			System.out.printf("Hunter is win! Player's scale is %d, Hunter's scale is %d ", hunterScale, playerScale);
		}else if(hunterScale < playerScale){
			System.out.printf("Player is win! Player's scale is %d, Hunter's scale is %d ", hunterScale, playerScale);
		}if(hunterScale == playerScale){
			System.out.printf("Tt is even! Player's scale is %d, Hunter's scale is %d ", hunterScale, playerScale);
		}
		if(debug == 1){
			System.out.printf("Singer's board:\n");
			for(int i = 1; i < forestJudgerStatus.length - 1; i++){
				for(int j = 1;j < forestJudgerStatus.length - 1; j++){
					System.out.print(forestJudgerStatus[i][j]+" ");
				}System.out.print("\n");
			}System.out.print("\n");
		}
	}
}
